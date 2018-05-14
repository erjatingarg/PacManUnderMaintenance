package com.homedepot.IT.api;

public class QueryBuilder {
	private  static final String tablenName = "ONLN_APPL_MNT_SCH";
	private  static final String currentDate="CURRENT_TIMESTAMP";
	private  static final String methodPrefix="TO_CHAR(";
	private  static final String methodSuffix=")";
	private  static final String timeFormat="'hh24:mi:ss'";
	

	public static String getQuery(String id,String startTimeInterval, String endTimeInterval, String startDateInterval, String endDateInterval, String type,String active) {
		String str1="DATEADD('HOUR',"+startTimeInterval+","+currentDate+methodSuffix;
		String str2="DATEADD('HOUR',"+endTimeInterval+","+currentDate+methodSuffix;
		
		
		String insertSql = "INSERT INTO " + tablenName
				+ "( ONLN_APPL_MNT_SCH_ID,LAST_UPD_SYSUSR_ID,LAST_UPD_TS,MMD_APPL_ID,ONLN_APMNT_PRCSS_TYP_CD,MNT_BGN_DT,MNT_BGN_TM,MNT_END_DT,MNT_END_TM,ONLN_APPL_MNT_FREQ_CD,ACTV_FLG )";

		String startTime=methodPrefix+str1+","+timeFormat+methodSuffix;
		String endTime=methodPrefix+str2+","+timeFormat+methodSuffix;
		
		String startDate="DATEADD('DAY',"+startDateInterval+","+currentDate+methodSuffix;
		String endDate="DATEADD('DAY',"+endDateInterval+","+currentDate+methodSuffix;
		
		String values = "	VALUES ( "+id+",'itestuser'," + currentDate + ", 1, 3, " + startDate + ", " + startTime + ","
				+ endDate + ", " + endTime + ","+type +", '" + active + "' )";		
		return insertSql.concat(values);

	}
}
