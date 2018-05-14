package com.homedepot.pmum.api.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.homedepot.pmum.api.constants.Constants;

public class TransactionManager {

	public static final transient Logger LOGGER = LogManager.getLogger(TransactionManager.class);
	
	/*
	 * As per sonarQube recommendation this constructor forces the user not to instantiate the class
	 * directly and instead use the static methods by using the class name
	 */	
	private TransactionManager(){
		
	}
	public static Connection getOraConnection() throws SQLException{
		Connection con = null;
		try{
			DataSource ds = DataSourceCache.getDataSource(Constants.ORACLE_SERVICE_NAME);
			con = ds.getConnection();
		}
		catch(Exception exp){
			LOGGER.error(exp.getMessage(), exp);
			throw exp;
		}
		
		return con;
	}
	
	public static Connection getOraConnection(String dbServiceName ) throws SQLException{
		Connection con = null;
		try{
			DataSource ds = DataSourceCache.getDataSource(dbServiceName);
			con = ds.getConnection();
		}
		catch(Exception exp){
			LOGGER.error(exp.getMessage(), exp);
			throw exp;
		}
		
		return con;
	}
	
	
	
	public static void close(Connection con,Statement st) {
		try {
			if(Objects.nonNull(st))
				st.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(),e);
		}
		try {
			if(Objects.nonNull(con))
				con.close();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(),e);
		}
	}
	
	public static void close(Statement st , ResultSet rs){

		if(Objects.nonNull(st)){
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
		if(Objects.nonNull(rs)){
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error(e.getMessage(),e);
			}
		}
		
	}
}

