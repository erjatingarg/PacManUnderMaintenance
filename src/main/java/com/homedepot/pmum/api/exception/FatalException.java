/*
* This program is proprietary to The Home Depot and is not to be
* reproduced, used, or disclosed without permission of:
*
*  The Home Depot
*  2455 Paces Ferry Road, N.W.
*  Atlanta, GA 30339-4053

*/
package com.homedepot.pmum.api.exception;

/**
 * The Class FatalException.
 *
 * @author TCS
 */
//@ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE, reason="Server encountered problem")
public class FatalException extends RuntimeException {

	/** Generated serialVersionUID. */
	private static final long serialVersionUID = 7908482282986478303L;

	/** HTTP Error code of the exception. */
	private static final int FATAL_ERROR_CODE = 500;

	/**
	 * Create a HTTP 500 (Server Error) exception.
	 */
	public FatalException() {
		super("Error code: "+FATAL_ERROR_CODE);
	}

	/**
	 * Create a HTTP 500 (Server Error) exception.
	 *
	 * @param e the e
	 */
	public FatalException(Exception e) {
		super("Error code: "+FATAL_ERROR_CODE+"/n"+e);
	}
	
	public FatalException(String msg,Exception e) {
		super(msg,e);
	}
}