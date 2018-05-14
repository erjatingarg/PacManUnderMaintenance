package com.homedepot.IT.api;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.homedepot.pmum.api.config.TransactionManager;

public class DatabaseHelper {


	private static DatabaseHelper instance;

	private static Connection connection = null;

	private DatabaseHelper() throws SQLException {
		connection=TransactionManager.getOraConnection();
		excuteQueryFromFile("Application_Schema.sql");
	}

	public static synchronized DatabaseHelper getInstance() throws SQLException {
		if (instance == null) {
			instance = new DatabaseHelper();
		}
		return instance;
	}
	
	
	public void executeOra(String sql ) throws SQLException{		
	
		
		PreparedStatement ps = null; 
								
			ps = connection.prepareStatement(sql);			
			 ps.execute();		
	
		
		
		 
	}
	
	private void excuteQueryFromFile(String fileName) throws SQLException
			 {
		final InputStream file = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(fileName);

		try (Scanner sc = new Scanner(file)) {
			sc.useDelimiter(";");
			String sql = null;
			while (sc.hasNext()) {
				sql = sc.next();
				if (sql != null && sql.trim().length() > 0) {
					 executeOra(sql);
				}
			}
		}
	}
	
	
	public void closeConnection(){
		TransactionManager.close(connection, null);
	
	}
	

	
	
}
