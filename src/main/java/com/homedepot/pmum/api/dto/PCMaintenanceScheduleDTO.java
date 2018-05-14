/*
* This program is proprietary to The Home Depot and is not to be
* reproduced, used, or disclosed without permission of:
*
*  The Home Depot
*  2455 Paces Ferry Road, N.W.
*  Atlanta, GA 30339-4053
*
*/
package com.homedepot.pmum.api.dto;

import java.io.Serializable;
import java.util.Comparator;

/**
 * This class is used to hold attributes and their values of various business
 * data objects.
 *
 * @author 
 */
public class PCMaintenanceScheduleDTO implements Comparator<PCMaintenanceScheduleDTO>,
Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer maintSchId;
	private String lastUpdUserId;
	private Integer mmdAppId;
	private short prcssTypCode;
	private String maintBeginDate;
	private String maintEndDate;
	private short freqCode;
	private Boolean activeFlag;
	private String maintBeginTime;
	private String maintEndTime;
	private String lastUpdateTs;
	private Integer id;
	private String appName;
	private String freqDesc;
	private String processDesc;
	private String activeCheckValue;
	
	
	/**
	 * @return the maintSchId
	 */
	public Integer getMaintSchId() {
		return maintSchId;
	}

	/**
	 * @param maintSchId the maintSchId to set
	 */
	public void setMaintSchId(Integer maintSchId) {
		this.maintSchId = maintSchId;
	}

	/**
	 * @return the lastUpdUserId
	 */
	public String getLastUpdUserId() {
		return lastUpdUserId;
	}

	/**
	 * @param lastUpdUserId the lastUpdUserId to set
	 */
	public void setLastUpdUserId(String lastUpdUserId) {
		this.lastUpdUserId = lastUpdUserId;
	}

	/**
	 * @return the mmdAppId
	 */
	public Integer getMmdAppId() {
		return mmdAppId;
	}

	/**
	 * @param mmdAppId the mmdAppId to set
	 */
	public void setMmdAppId(Integer mmdAppId) {
		this.mmdAppId = mmdAppId;
	}

	/**
	 * @return the prcssTypCode
	 */
	public short getPrcssTypCode() {
		return prcssTypCode;
	}

	/**
	 * @param prcssTypCode the prcssTypCode to set
	 */
	public void setPrcssTypCode(short prcssTypCode) {
		this.prcssTypCode = prcssTypCode;
	}

	/**
	 * @return the maintBeginDate
	 */
	public String getMaintBeginDate() {
		return maintBeginDate;
	}

	/**
	 * @param maintBeginDate the maintBeginDate to set
	 */
	public void setMaintBeginDate(String maintBeginDate) {
		this.maintBeginDate = maintBeginDate;
	}

	/**
	 * @return the maintEndDate
	 */
	public String getMaintEndDate() {
		return maintEndDate;
	}

	/**
	 * @param maintEndDate the maintEndDate to set
	 */
	public void setMaintEndDate(String maintEndDate) {
		this.maintEndDate = maintEndDate;
	}

	/**
	 * @return the freqCode
	 */
	public short getFreqCode() {
		return freqCode;
	}

	/**
	 * @param freqCode the freqCode to set
	 */
	public void setFreqCode(short freqCode) {
		this.freqCode = freqCode;
	}

	/**
	 * @return the activeFlag
	 */
	public Boolean getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * @return the maintBeginTime
	 */
	public String getMaintBeginTime() {
		return maintBeginTime;
	}

	/**
	 * @param maintBeginTime the maintBeginTime to set
	 */
	public void setMaintBeginTime(String maintBeginTime) {
		this.maintBeginTime = maintBeginTime;
	}

	/**
	 * @return the maintEndTime
	 */
	public String getMaintEndTime() {
		return maintEndTime;
	}

	/**
	 * @param maintEndTime the maintEndTime to set
	 */
	public void setMaintEndTime(String maintEndTime) {
		this.maintEndTime = maintEndTime;
	}

	/**
	 * @return the lastUpdateTs
	 */
	public String getLastUpdateTs() {
		return lastUpdateTs;
	}

	/**
	 * @param lastUpdateTs the lastUpdateTs to set
	 */
	public void setLastUpdateTs(String lastUpdateTs) {
		this.lastUpdateTs = lastUpdateTs;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @return the freqDesc
	 */
	public String getFreqDesc() {
		return freqDesc;
	}

	/**
	 * @param freqDesc the freqDesc to set
	 */
	public void setFreqDesc(String freqDesc) {
		this.freqDesc = freqDesc;
	}

	/**
	 * @return the processDesc
	 */
	public String getProcessDesc() {
		return processDesc;
	}

	/**
	 * @param processDesc the processDesc to set
	 */
	public void setProcessDesc(String processDesc) {
		this.processDesc = processDesc;
	}
	
	@Override
	public int compare(PCMaintenanceScheduleDTO object1, PCMaintenanceScheduleDTO object2) {

		if (null != object1 && null != object2 && null != object1.getMaintSchId()
				&& null != object2.getMaintSchId()) {

			return object2.getMaintSchId()
					- object1.getMaintSchId();
		}

		return 0;
	}

	/**
	 * @return the activeCheckValue
	 */
	public String getActiveCheckValue() {
		return activeCheckValue;
	}

	/**
	 * @param activeCheckValue the activeCheckValue to set
	 */
	public void setActiveCheckValue(String activeCheckValue) {
		this.activeCheckValue = activeCheckValue;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
