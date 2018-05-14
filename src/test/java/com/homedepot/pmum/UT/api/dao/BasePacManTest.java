package com.homedepot.pmum.UT.api.dao;


import java.lang.reflect.Method;
import java.sql.Connection;

import org.apache.logging.log4j.Level;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.homedepot.pmum.UT.api.util.BaseUnitInitializer;
import com.homedepot.pmum.UT.api.util.BaseUnitInitializer.DBType;
import com.homedepot.pmum.api.config.DataSourceCache;
import com.homedepot.pmum.api.config.LogLevel;
import com.homedepot.pmum.api.config.TransactionManager;
import com.homedepot.pmum.api.constants.Queries;


@PowerMockIgnore("javax.management.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest({DataSourceCache.class,TransactionManager.class, Queries.class, Mockito.class})
public class BasePacManTest  {
	
	@BeforeClass
	public static void setup(){
		try {
			mock();
			BaseUnitInitializer.initialize();
			LogLevel.changeLogLevel(Level.ALL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection con(InvocationOnMock invocation){
		Connection con = null;
		Method  met = invocation.getMethod();
		if(met.getName().equals("getOraConnection")){
			con= BaseUnitInitializer.getConnection(DBType.DB2.value());
		}
		else{
			try {
				invocation.callRealMethod();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	

	private static void mock() throws Exception{
		try{
		PowerMockito.mockStatic(TransactionManager.class, Mockito.withSettings().verboseLogging().defaultAnswer(BasePacManTest::con));
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	
	@Test
	public void sampleTest(){
		
	}
}
