/*
 * This program is proprietary to The Home Depot and is not to be
 * reproduced, used, or disclosed without permission of:
 *
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053 *
 * 
 */
package com.homedepot.pmum.api.constants;

/**
 * The Class BusinessMessageConstants.
 */
public class BusinessMessageConstants {
	
	    
    /** The Constant SUCCMSG_PC_MAINT_SCH_UNDER_MNT. */
    public static final String SUCCMSG_PC_IS_UNDER_MAINT = "Online Application Process is under maintenance";
    
    /** The Constant SUCCMSG_PC_MAINT_SCH_NOT_UNDER_MNT. */
    public static final String SUCCMSG_PC_IS_NOT_IN_MAINT = "Online Application Process is available";    
   
	public static final int SUCCESS_CODE = 0;
	
	/*
	 * As per sonarQube recommendation this constructor forces the user not to instantiate the class
	 * directly and instead use the static methods by using the class name
	 */	
	private BusinessMessageConstants(){
		
	}

    
}
