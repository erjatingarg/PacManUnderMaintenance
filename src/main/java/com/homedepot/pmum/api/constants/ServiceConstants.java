/*
 * This program is proprietary to The Home Depot and is not to be
 * reproduced, used, or disclosed without permission of:
 *
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 */
package com.homedepot.pmum.api.constants;


/**
 * The Class ServiceConstants.
 */
public class ServiceConstants {

	
    // Produces Constants
    /** The Constant MIME_TYPE_APP_XML. */
    public static final String MIME_TYPE_APP_XML = "application/xml";
    
    /** The Constant MIME_TYPE_TEXT_PLAIN. */
    public static final String MIME_TYPE_TEXT_PLAIN = "text/html";
    
    /** The Constant MIME_TYPE_APP_JSON. */
    public static final String MIME_TYPE_APP_JSON = "application/json";
    
    /** The Constant PARAM_VERSION_NO. */
    public static final String PARAM_VERSION_NO = "versionNumber";
    
    /** The Constant PARAM_SUB_TYPE. */
    public static final String PARAM_SUB_TYPE = "subtype";
    
    /** The Constant PARAM_LANG_CODE. */
    public static final String PARAM_LANG_CODE = "langCode";
    
    /** The Constant PARAM_LANG_CODE. */
    public static final String PARAM_APP_ID = "applicationId";
    
    /** The Constant PARAM_LANG_CODE. */
    public static final String PARAM_TYPE_CODE = "typeCode";
    
    /** The Constant PARAM_JSON_DATA. */
    public static final String PARAM_JSON_DATA = "jsonData";
    
    /** The Constant PARAM_MODEL_NO. */
    public static final String PARAM_MODEL_NO = "modelNumber";
    
    /** The Constant PARAM_REQUEST_ID. */
    public static final String PARAM_REQUEST_ID = "requestID";

    /** The Constant DEFAULT_VERSION_NO. */
    public static final String DEFAULT_VERSION_NO = "1";
    
    /** The Constant DEFAULT_LANG_CODE. */
    public static final String DEFAULT_LANG_CODE = "en_US";
    
    //this explicit constructor force the user not to instantiate the class as recommended by sonarqube
  	private ServiceConstants(){
  		
  	}
 
	 }
