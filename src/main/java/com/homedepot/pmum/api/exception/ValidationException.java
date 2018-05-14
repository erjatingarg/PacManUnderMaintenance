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
 * The Class ValidationException.
 * 
 * @author 
 */
//@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY, reason="Cannot proccess the request")
public class ValidationException extends RuntimeException {

	/** Generated serialVersionUID. */
	private static final long serialVersionUID = -1656830714099608806L;

	/** HTTP Error code of the exception. */
	private static final int VALIDATION_ERROR_CODE = 422;

	/**
	 * Create a HTTP 422 (Unprocessable Entity) exception.
	 */
	public ValidationException() {
		super("Error Code: "+VALIDATION_ERROR_CODE);
	}


	/**
	 * Instantiates a new validation exception.
	 *
	 * @param e the e
	 */
	public ValidationException(Exception e) {

		super("Error Code: "+VALIDATION_ERROR_CODE+"/n"+e);
	}


}
