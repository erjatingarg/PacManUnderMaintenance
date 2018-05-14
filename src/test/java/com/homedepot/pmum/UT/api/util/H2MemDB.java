package com.homedepot.pmum.UT.api.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class H2MemDB {

	private static H2MemDB instance;

	private boolean isDataBaseInitialized = false;

	List<H2DBInitializer> dbInitializers = null;

	private H2MemDB() {

	}

	public static synchronized H2MemDB getInstance() {
		if (instance == null) {
			instance = new H2MemDB();
		}

		return instance;
	}

	public synchronized void initializeH2Instance(
			List<H2DBInitializer> dbInitializers) {
		try {

			if (!this.isDataBaseInitialized) {
				this.dbInitializers = dbInitializers;
				createDatabase();
			}
			this.isDataBaseInitialized = true;
		} catch (Exception e) {
			throw new IllegalStateException("Error initializing H2 instance", e);
		}
	}

	private void createDatabase() throws ClassNotFoundException, SQLException,
			NamingException {

		Connection connection = null;
		Statement statement = null;
		for (H2DBInitializer dbInitializer : this.dbInitializers) {
			connection = BaseUnitInitializer.getConnection(dbInitializer
					.getDbType());
			statement = connection.createStatement();
			statement.execute("DROP ALL OBJECTS");
			processSchemaAndSQL(statement, dbInitializer);
		}
	}

	private void processSchemaAndSQL(Statement statement,
			H2DBInitializer dbInitializer) throws SQLException {
		processFileList(statement, dbInitializer.getSchemaFileList());
		processFileList(statement, dbInitializer.getSqlFileList());
	}

	private void processFileList(Statement statement, String[] fileList)
			throws SQLException {
		if (fileList != null && fileList.length > 0) {
			for (String file : fileList) {
				process(statement, file);
			}
		}
	}

	private void process(Statement statement, String fileName)
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
}
