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

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



/**
 * The Class AppUtil.
 * 
 * @author TCS
 */
public class AppUtil {
	
	
	private AppUtil(){
		
	}
		
	
	/**
	 * Convert to timestamp.
	 * 
	 * @param input
	 *            the input
	 * @return the timestamp
	 */
	public static Timestamp convertToTimestamp(String input) {
		

		DateFormat inputDateFormatter = new SimpleDateFormat(
				"MM/dd/yyyy HH:mm:ss");
		Timestamp timestamp = null;

		try {
			java.util.Date utilDate = inputDateFormatter.parse(input);
			java.sql.Date sqltDate = new java.sql.Date(utilDate.getTime());

			timestamp = new Timestamp(sqltDate.getTime());
		} catch (ParseException ex) {
			timestamp = null;
		}

		return timestamp;
	}	
	public static String convertStringToDate(String input, String format) {
		DateFormat inputDateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = null;

		try {
			java.util.Date utilDate = inputDateFormatter.parse(input);
			DateFormat df = new SimpleDateFormat(format);
			date = df.format(new Timestamp(utilDate.getTime()));
		} catch (ParseException ex) {
			date = null;
		}
		return date;
	}
	
	public static Timestamp convertStringToTimestamp(String date, String time)
	{		
		return convertToTimestamp(convertStringToDate(date,"MM/dd/yyyy") + " " + time);		
		 	
	}



	
}
