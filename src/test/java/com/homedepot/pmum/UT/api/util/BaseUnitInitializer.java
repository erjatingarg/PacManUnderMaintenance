package com.homedepot.pmum.UT.api.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.homedepot.pmum.UT.api.util.H2DBInitializer;
import com.homedepot.pmum.api.config.DataSourceCache;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ DataSourceCache.class })
public class BaseUnitInitializer {

	public static enum DBType {
		DB2("DB2"), ORACLE("Oracle"), MYSQL("MySQL"), DERBY("Derby"), HSQLDB(
				"HSQLDB");

		private String value;

		private DBType(final String value) {
			this.value = value;
		}

		public String value() {
			return value;
		}
	}

	@BeforeClass
	public static void initialize() throws Exception {

		initializeH2();
	}

	public static Connection getConnection(String dbType) {
		String H2_URL = "jdbc:h2:mem:test{0};DB_CLOSE_DELAY=-1;MODE={1}";
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(MessageFormat.format(H2_URL,
					dbType, dbType));

			return conn;
		} catch (Exception e) {
			throw new IllegalStateException(
					"Error creating H2 Driver class for service " + dbType, e);
		}
	}

	public static String getDefaultHost() {
		return "http://localhost:8888";
	}

	private static void initializeH2() {
		List<H2DBInitializer> dbInitializers = new ArrayList<>();
		dbInitializers.add(new H2DBInitializer(DBType.DB2.value(),
				new String[] { "Application_Schema.sql" },
				new String[] { "Application_SQL.sql" }));

		H2MemDB.getInstance().initializeH2Instance(dbInitializers);
	}

	@Test
	public void sampleTest() {
	}
}
