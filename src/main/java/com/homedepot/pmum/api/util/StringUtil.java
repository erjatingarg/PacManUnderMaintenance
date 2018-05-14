/*
 * This program is proprietary to The Home Depot and is not to be
 * reproduced, used, or disclosed without permission of:
 *
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 *
 */
package com.homedepot.pmum.api.util;

import java.util.List;

/**
 * The Class StringUtil.
 * 
 * @author TCS
 */
public final class StringUtil {

	/**
	 * Checks if is null or empty.
	 * 
	 * @param input
	 *            the input
	 * @return true, if is null or empty
	 */
	private StringUtil(){
		
	}
	public static boolean isNullOrEmpty(List<?> input) {

		return input == null || input.isEmpty();
	}

}
