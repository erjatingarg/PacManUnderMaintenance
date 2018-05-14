package com.homedepot.pmum.UT.api.util;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.homedepot.pmum.api.util.DateFunctionsUtil;

public class TestDateFunctionsUtil {

	DateFunctionsUtil dateUtil;
	LocalDate currentDateYearlyMaintenance;
	LocalDate currentDateMonthlyMaintenance;
	LocalDate currentDateDailyMaintenance;
	LocalTime currentTimeDailyMaintenance;
	

	@Before
	public void setUp() throws Exception {

		dateUtil = spy(DateFunctionsUtil.class);
		

		currentDateMonthlyMaintenance = Timestamp.valueOf("2017-03-10 10:10:10.0")
				.toLocalDateTime().toLocalDate();
		

		currentDateYearlyMaintenance = Timestamp.valueOf("2017-11-23 10:10:10.0")
				.toLocalDateTime().toLocalDate();
		
		currentDateDailyMaintenance = Timestamp.valueOf("2017-03-10 10:30:00.0")
				.toLocalDateTime().toLocalDate();
		currentTimeDailyMaintenance = Timestamp.valueOf("2017-03-10 10:30:00.0")
				.toLocalDateTime().toLocalTime();

	}

	@Test
	public void testIsYearlyMaintenance() {
		// when the current date is b/n start and end date: Expect True
		Timestamp startTime = Timestamp.valueOf("2017-03-23 10:10:10.0");
		Timestamp endTime = Timestamp.valueOf("2017-12-23 10:10:10.0");
		when(dateUtil.getCurrentSystemDate()).thenReturn(currentDateYearlyMaintenance);
		assertTrue(dateUtil.isYearlyMaintenance(startTime, endTime));

		// when the current date is out of start and end date: Expect False

		currentDateYearlyMaintenance = Timestamp.valueOf("2017-01-23 10:10:10.0")
				.toLocalDateTime().toLocalDate();
		when(dateUtil.getCurrentSystemDate()).thenReturn(currentDateYearlyMaintenance);
		assertTrue(!dateUtil.isYearlyMaintenance(startTime, endTime));
	}

	@Test
	public void testIsMonthlyMaintenance() {
		// when the current date is b/n start and end date: Expect True
		Timestamp startTime = Timestamp.valueOf("2017-03-02 10:10:10.0");
		Timestamp endTime = Timestamp.valueOf("2017-03-23 10:10:10.0");
		when(dateUtil.getCurrentSystemDate()).thenReturn(currentDateMonthlyMaintenance);
		assertTrue(dateUtil.isMonthlyMaintenance(startTime, endTime));

		// when the current date is out of start and end date: Expect False

		currentDateMonthlyMaintenance = Timestamp
				.valueOf("2017-03-30 10:10:10.0").toLocalDateTime()
				.toLocalDate();
		when(dateUtil.getCurrentSystemDate()).thenReturn(
				currentDateMonthlyMaintenance);
		assertTrue(!dateUtil.isMonthlyMaintenance(startTime, endTime));
		
	}
	 
	@Test
	public void testIsDailyMaintenance() {
		// when the current Time is b/n start and end date: Expect True
		Timestamp startTime = Timestamp.valueOf("2017-03-02 10:00:00.0");
		Timestamp endTime = Timestamp.valueOf("2017-03-23 11:00:00.0");
		when(dateUtil.getCurrentSystemDate()).thenReturn(
				currentDateDailyMaintenance);
		when(dateUtil.getCurrentSystemTime()).thenReturn(
				currentTimeDailyMaintenance);
		assertTrue(dateUtil.isDailyMaintenance(startTime, endTime));

		// when the current Time is out of start and end date: Expect False

		currentTimeDailyMaintenance = Timestamp.valueOf("2017-03-10 11:30:00.0")
				.toLocalDateTime().toLocalTime();
		when(dateUtil.getCurrentSystemTime()).thenReturn(
				currentTimeDailyMaintenance);
		assertTrue(!dateUtil.isDailyMaintenance(startTime, endTime));
	}

}
