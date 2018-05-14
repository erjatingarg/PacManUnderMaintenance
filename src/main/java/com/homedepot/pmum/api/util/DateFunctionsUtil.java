package com.homedepot.pmum.api.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.homedepot.pmum.api.constants.Constants;

@Component
public class DateFunctionsUtil {

	private static final Logger logger = Logger
			.getLogger(DateFunctionsUtil.class);
	private LocalDate currentDate=null;
	private boolean underMaintenance=false;
	private String logCurrentDate="Current Date : ";

	
	
	
	public LocalTime getCurrentSystemTime() {

		String currentTimeStr=LocalTime.now(ZoneId.of(Constants.TIME_ZONE)).format(DateTimeFormatter.ofPattern(Constants.TIME_FORMAT));
		LocalTime currentTime=LocalTime.parse(currentTimeStr);
		return currentTime;
	}


	public LocalDate getCurrentSystemDate() {
		return LocalDate.now(ZoneId.of(Constants.TIME_ZONE));
	}


	public boolean isYearlyMaintenance(Timestamp startTime, Timestamp endTime) {

		underMaintenance = false;
		currentDate = getCurrentSystemDate();
		LocalDate startDate = startTime.toLocalDateTime().toLocalDate();
		LocalDate endDate = endTime.toLocalDateTime().toLocalDate();

		logger.info(logCurrentDate + currentDate);

		if ((startDate.isBefore(currentDate) && endDate.isAfter(currentDate))
				|| startDate.equals(currentDate) || endDate.equals(currentDate)) {
			underMaintenance = true;
		}

		return underMaintenance;
	}

	public boolean isMonthlyMaintenance(Timestamp startTime, Timestamp endTime) {
		underMaintenance = false;
		currentDate = getCurrentSystemDate();
		LocalDate startDate = startTime.toLocalDateTime().toLocalDate();
		LocalDate endDate = endTime.toLocalDateTime().toLocalDate();

		logger.info(logCurrentDate + currentDate);

		if ((startDate.isBefore(currentDate) && endDate.isAfter(currentDate))
				|| startDate.equals(currentDate) || endDate.equals(currentDate)) {
			underMaintenance = true;
		}

		return underMaintenance;
	}

	public boolean isDailyMaintenance(Timestamp startTime, Timestamp endTime) {

		underMaintenance = false;
		
		currentDate = getCurrentSystemDate();
		LocalDate startDate = startTime.toLocalDateTime().toLocalDate();
		LocalDate endDate = endTime.toLocalDateTime().toLocalDate();

		logger.info(logCurrentDate + currentDate);
		logger.info("Current Time : " + getCurrentSystemTime());

		if ((startDate.isBefore(currentDate) && endDate.isAfter(currentDate))
				|| startDate.equals(currentDate) || endDate.equals(currentDate)) {
			
			LocalTime currentTime = getCurrentSystemTime();
			LocalTime extractedStartTime = startTime.toLocalDateTime().toLocalTime();
			LocalTime extractedEndTime = endTime.toLocalDateTime().toLocalTime();

			logger.debug("Current Time : " + currentTime);

			if ((extractedStartTime.isBefore(currentTime) && extractedEndTime
					.isAfter(currentTime))
					|| extractedStartTime.equals(currentTime)
					|| extractedEndTime.equals(currentTime))
				underMaintenance = true;
		}
		return underMaintenance;
	}
}
