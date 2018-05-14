package com.homedepot.pmum.UT.api.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Scanner;

import javax.naming.NamingException;

import org.h2.tools.DeleteDbFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2Database {

	private static final Logger LOGGER = LoggerFactory.getLogger(H2Database.class);

	private static H2Database instance;

	private Connection connection = null;
	private Statement statement = null;

	private H2Database() {
		connection=createConnection("DB2");
	}

	public static synchronized H2Database getInstance() {
		if (instance == null) {
			instance = new H2Database();
		}
		return instance;
	}

	public void createDatabase(String sql) throws ClassNotFoundException, SQLException, NamingException {
		statement = connection.createStatement();
		statement.execute("DROP ALL OBJECTS");
		statement.execute(sql);
	}
	
	public void excuteQuery(String sql) throws ClassNotFoundException, SQLException, NamingException {

		statement = connection.createStatement();
		statement.execute(sql);

	}

	public void createDatabaseFromFile(String FileName) throws ClassNotFoundException, SQLException, NamingException {

		statement = connection.createStatement();
		statement.execute("DROP ALL OBJECTS");
		processFromFile(FileName);

	}

	public static Connection createConnection(String dbType) {
		String H2_URL = "jdbc:h2:mem:test{0};DB_CLOSE_DELAY=-1;MODE={1}";
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(MessageFormat.format(H2_URL, dbType, dbType));

			return conn;
		} catch (Exception e) {
			throw new IllegalStateException("Error creating H2 Driver class for service " + dbType, e);
		}
	}

	public Connection getConnection(){
		return this.connection;
	}
	
	private void processFromFile(String fileName)
			throws SQLException {
		final InputStream file = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(fileName);

		try (Scanner sc = new Scanner(file)) {
			sc.useDelimiter(";");
			String sql = null;
			while (sc.hasNext()) {
				sql = sc.next();
				if (sql != null && sql.trim().length() > 0) {
					statement.execute(sql);
				}
			}
		}
	}
	
	
	public synchronized void tearDownH2Instance() {
		try {
			if (statement != null) {
				statement.execute("DROP ALL OBJECTS");
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}

			DeleteDbFiles.execute("mem", "test", true);

		} catch (Exception e) {
			LOGGER.info("Error tearing down the H2 Instance:" + e.getMessage());
		}
	}
}
