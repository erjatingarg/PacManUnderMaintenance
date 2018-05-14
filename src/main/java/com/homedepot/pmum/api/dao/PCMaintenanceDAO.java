/*
 * This program is proprietary to The Home Depot and is not to be
 * reproduced, used, or disclosed without permission of:
 *
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 *
 */
package com.homedepot.pmum.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.homedepot.pmum.api.config.DataSourceCache;
import com.homedepot.pmum.api.constants.Constants;
import com.homedepot.pmum.api.constants.DAOConstants;
import com.homedepot.pmum.api.dto.PCMaintenanceScheduleDTO;
import com.homedepot.pmum.api.util.AppUtil;
import com.homedepot.pmum.api.util.DateFunctionsUtil;
import com.homedepot.pmum.api.util.StringUtil;



/**
 * The Class PCMaintenanceDAO.
 */
@Repository
public class PCMaintenanceDAO {
	
    
    private static final Logger LOGGER = Logger.getLogger(PCMaintenanceDAO.class);
    DateFunctionsUtil dateUtil;
    
      
    public PCMaintenanceDAO(){
	   this.dateUtil=new DateFunctionsUtil();
   }
   
    
	
	
	public boolean getPacManMaintenanceSchedule() {
		List<Boolean> underMaintenanceList = new ArrayList<>();	

		StringBuilder sqlStatement = new StringBuilder("Select * FROM ONLN_APPL_MNT_SCH");
		
		underMaintenanceList = executeSKUPromoListBaseRetailChanges(sqlStatement.toString());
		
		
		if (!StringUtil.isNullOrEmpty(underMaintenanceList)) {
			return underMaintenanceList.get(0);
		} else {
			return false;
		}
	}
	
	
	
	/**
	 *
	 * @param sqlStatement
	 * @param params
	 * @return
	 */
	public List<Boolean> executeSKUPromoListBaseRetailChanges(String sqlStatement) {

		List<Boolean> underMaintenanceList = new ArrayList<>();
		long startTime = System.currentTimeMillis();

		// Jdbc connections
		
		
	/*	DataSource dataSource = jdbcOra.getDataSource();*/
		DataSource dataSource = DataSourceCache.getDataSource(Constants.ORACLE_SERVICE_NAME);
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		namedParameterJdbcTemplate.query(sqlStatement.toString(),new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						Timestamp startTime = null;
						boolean underMaintenance = false;
						Timestamp endTime = null;
						
						PCMaintenanceScheduleDTO maintenanceScheduleDTO = new PCMaintenanceScheduleDTO();	

						maintenanceScheduleDTO.setMaintSchId(rs.getInt(DAOConstants.ONLINE_APP_MAINT_SCHED_ID));

						maintenanceScheduleDTO.setLastUpdUserId(rs.getString(DAOConstants.LAST_UPDATE_SYS_USERID));

						maintenanceScheduleDTO.setLastUpdateTs(rs.getTimestamp("LAST_UPD_TS").toString());

						maintenanceScheduleDTO.setMmdAppId(rs.getInt(DAOConstants.MERCH_MASTER_DATA_APPID));

						maintenanceScheduleDTO.setPrcssTypCode(rs.getShort(DAOConstants.ONLINE_APP_MAINT_PRS_TYP_CD));

						maintenanceScheduleDTO.setMaintBeginDate(rs.getString(DAOConstants.MAINT_BGN_DATE));

						maintenanceScheduleDTO.setMaintBeginTime(rs.getString(DAOConstants.MAINT_BGN_TIME));

						maintenanceScheduleDTO.setMaintEndDate(rs.getString(DAOConstants.MAINT_END_DATE));

						maintenanceScheduleDTO.setMaintEndTime(rs.getString(DAOConstants.MAINT_END_TIME));

						maintenanceScheduleDTO.setFreqCode(rs.getShort(DAOConstants.ONLINE_APP_MAINT_FREQ_CD));

						String flag = rs.getString(DAOConstants.ACTIVE_FLAG);
						Boolean activeFlag = false;

						if ("Y".equals(flag)) {
							activeFlag = true;
						}

						maintenanceScheduleDTO.setActiveFlag(activeFlag);
						
						startTime = AppUtil.convertStringToTimestamp(
								maintenanceScheduleDTO.getMaintBeginDate(),
								maintenanceScheduleDTO.getMaintBeginTime());
						
						endTime = AppUtil.convertStringToTimestamp(
								maintenanceScheduleDTO.getMaintEndDate(),
								maintenanceScheduleDTO.getMaintEndTime());

						if (activeFlag == true) {
							// 3-yearly 2-monthly 1-no recurrence 0-daily
							if (maintenanceScheduleDTO.getFreqCode() == 3) {
								LOGGER.info(" Yearly Maintenance ========>Start Time : "
										+ startTime);
								LOGGER.info("Yearly Maintenance ========>End Time : "
										+ endTime);
								underMaintenance = dateUtil
										.isYearlyMaintenance(startTime, endTime);
							} else if (maintenanceScheduleDTO.getFreqCode() == 2) {
								LOGGER.info("Monthly Maintenance ========>Start Time : "
										+ startTime);
								LOGGER.info("Monthly Maintenance ========>End Time : "
										+ endTime);
								underMaintenance = dateUtil
										.isMonthlyMaintenance(startTime,
												endTime);
							} else if (maintenanceScheduleDTO.getFreqCode() == 0) {
								LOGGER.info("Daily Maintenance ========>Start Time : "
										+ startTime);
								LOGGER.info("daily Maintenance ========>End Time : "
										+ endTime);
								underMaintenance = dateUtil.isDailyMaintenance(
										startTime, endTime);
							}
						}

						if (underMaintenance) {
							underMaintenanceList.add(underMaintenance);
						//	break;
						}
					}
				});
		
		  LOGGER.debug( "Time Taken in ms= "  + (System.currentTimeMillis() - startTime));
		  
		return underMaintenanceList;
	}
	

}