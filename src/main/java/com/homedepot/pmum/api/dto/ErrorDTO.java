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

/**
 * Data Transfer object to represent an error.
 * @author 
 */
public class ErrorDTO {

    /** The error code. */
    private Integer errorCode;
    
    /** The error message. */
    private String errorMessage;

    /**
     * Instantiates a new error dto.
     * @param errorMessage the error message
     */
    public ErrorDTO(String errorMessage) {

        this(null, errorMessage);
    }

    /**
     * Instantiates a new error dto.
     * @param errorCode the error code
     * @param errorMessage the error message
     */
    public ErrorDTO(Integer errorCode, String errorMessage) {

        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Gets the error code.
     * @return the error code
     */
    public Integer getErrorCode() {

        return errorCode;
    }

    /**
     * Sets the error code.
     * @param errorCode the new error code
     */
    public void setErrorCode(Integer errorCode) {

        this.errorCode = errorCode;
    }

    /**
     * Gets the error message.
     * @return the error message
     */
    public String getErrorMessage() {

        return errorMessage;
    }

    /**
     * Sets the error message.
     * @param errorMessage the new error message
     */
    public void setErrorMessage(String errorMessage) {

        this.errorMessage = errorMessage;
    }

}
