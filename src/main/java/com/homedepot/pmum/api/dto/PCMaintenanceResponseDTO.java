/*
* This program is proprietary to The Home Depot and is not to be
* reproduced, used, or disclosed without permission of:
*
*  The Home Depot
*  2455 Paces Ferry Road, N.W.
*  Atlanta, GA 30339-4053
*
*
*/
package com.homedepot.pmum.api.dto;

import java.io.Serializable;

/**
 * This class is used to hold attributes and their values of various business
 * data objects.
 *
 * @author 
 */
public class PCMaintenanceResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isUnderMaintenance;
	private String message;
	private int code;
	public boolean isUnderMaintenance() {
		return isUnderMaintenance;
	}
	public void setUnderMaintenance(boolean isUnderMaintenance) {
		this.isUnderMaintenance = isUnderMaintenance;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
