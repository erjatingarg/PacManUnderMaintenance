package com.homedepot.pmum.UT.api.util;

public class H2DBInitializer {

	private String dbType;

	private String[] schemaFileList;

	private String[] sqlFileList;

	public H2DBInitializer(String dbType, String[] schemaFileList,
			String[] sqlFileList) {
		super();
		this.dbType = dbType;
		this.schemaFileList = schemaFileList;
		this.sqlFileList = sqlFileList;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String[] getSchemaFileList() {
		return schemaFileList;
	}

	public void setSchemaFileList(String[] schemaFileList) {
		this.schemaFileList = schemaFileList;
	}

	public String[] getSqlFileList() {
		return sqlFileList;
	}

	public void setSqlFileList(String[] sqlFileList) {
		this.sqlFileList = sqlFileList;
	}
}
