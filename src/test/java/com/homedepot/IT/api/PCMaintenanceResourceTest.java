package com.homedepot.IT.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.homedepot.pmum.PacManUnderMaintenanceApplication;
import com.homedepot.pmum.api.dto.PCMaintenanceResponseDTO;
import com.homedepot.pmum.api.util.JSONConverter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PacManUnderMaintenanceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PCMaintenanceResourceTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	private static final String URL = "/maintain/search";	
	private static final String tablenName = "ONLN_APPL_MNT_SCH";
	private	static final String active="Y";
	private static final String notActive="N";
	private	static final String daily="0";
	private	static final String monthly="2";
	private	static final String yearly="3";

	
	private static DatabaseHelper dbHelper;
	

	@BeforeClass
	public static void setUpBefore() throws SQLException {
		dbHelper = DatabaseHelper.getInstance();
	}

	@Before
	public void setUp() throws Exception {
		dbHelper.executeOra("delete from " + tablenName);
	}

	/*
	 * Test Case: 1.1 tests daily maintenance when it is active and the current
	 * date is between the start and end dates as well as the current time is
	 * between the hours expected output: under maintenance should be true
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceDaily_BtnDates_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-1", "+1", "-10", "+10", daily, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 1.2 tests daily maintenance when it is active and the current
	 * date equal to the start and end dates as well as the current time is
	 * between the boundary hours expected output: under maintenance should be
	 * true
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceDaily_CurrentDateEqualToBoundaryDate_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-1", "+1", "0", "0", daily, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 1.3 tests daily maintenance when it is active and the current
	 * date equal to the both start and end dates as well as between the hours
	 * expected output: under maintenance should be false
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceDaily_CurrentDateEqualToOutofBoundaryDate_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-1", "+1", "+5", "+10", daily, active);
		dbHelper.executeOra(queryStr);
		queryStr = QueryBuilder.getQuery("2", "-1", "+1", "-10", "-5", daily, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertFalse(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 1.4 tests daily maintenance when it is active and the current
	 * date is in between the start and end dates but the time is out of the
	 * boundary times(hours) expected output: under maintenance should be false
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceDaily_CurrentTimeEqualToOutofBoundaryTime_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "-5", "+5", daily, active);
		dbHelper.executeOra(queryStr);
		queryStr = QueryBuilder.getQuery("2", "+1", "+3", "-5", "+5", daily, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertFalse(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 1.5 this test case test daily maintenance when it is not
	 * active regardless of the when the current time start and end dates as
	 * well as between the hours expected output: under maintenance should be
	 * false
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceDaily_NotActive() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-1", "+1", "-10", "+10", daily, notActive);

		dbHelper.executeOra(queryStr);
		queryStr = QueryBuilder.getQuery("2", "-3", "-2", "-10", "+10", daily, notActive);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("3", "0", "0", "-10", "+10", daily, notActive);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertFalse(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 2.1 tests monthly maintenance when it is active and the
	 * current date is in between the start and end dates. The API
	 * implementation doesn't compare time. So no need of comparing the time
	 * expected output: under maintenance should be true
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceMonthly_CurrentDateInBoundaryDates_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "-5", "+5", monthly, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 2.2 tests monthly maintenance when it is active and the
	 * current date is Equal to the start and end dates. The API implementation
	 * doesn't compare time. So no need of comparing the time expected output:
	 * under maintenance should be true
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceMonthly_CurrentDateEqualToBoundaryDates_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "0", "0", monthly, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 2.3 tests monthly maintenance when it is active and the
	 * current date is Equal to only the start dates. The API implementation
	 * doesn't compare time. So no need of comparing the time expected output:
	 * under maintenance should be true
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceMonthly_CurrentDateEqualStartDate_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "0", "+5", monthly, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 2.4 tests monthly maintenance when it is active and the
	 * current date is not in between the start and end dates. The API
	 * implementation doesn't compare time. So no need of comparing the time
	 * expected output: under maintenance should be False
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceMonthly_CurrentDateIsOutofBoundaryDates_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "-10", "-5", monthly, active);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("2", "-3", "-2", "+5", "+10", monthly, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertFalse(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 2.5 tests monthly maintenance when it is not active regardless
	 * when is the current date. The API implementation doesn't compare time. So
	 * no need of comparing the time expected output: under maintenance should
	 * be False
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceMonthly_NotActive() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "-10", "-5", monthly, notActive);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("2", "-3", "-2", "+5", "+10", monthly, notActive);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("3", "-3", "-2", "-5", "+5", monthly, notActive);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertFalse(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 3.1 tests yearly maintenance when it is active and the current
	 * date is in between the start and end dates. The API implementation
	 * doesn't compare time. So no need of comparing the time expected output:
	 * under maintenance should be true
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceYearly_CurrentDateInBoundaryDates_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "-5", "+5", yearly, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 3.2 tests yearly maintenance when it is active and the current
	 * date is Equal to the start and end dates. The API implementation doesn't
	 * compare time. So no need of comparing the time expected output: under
	 * maintenance should be true
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceYearly_CurrentDateEqualToBoundaryDates_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "0", "0", yearly, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 3.3 tests yearly maintenance when it is active and the current
	 * date is Equal to only the start dates. The API implementation doesn't
	 * compare time. So no need of comparing the time expected output: under
	 * maintenance should be true
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceYearly_CurrentDateEqualStartDate_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "0", "+5", yearly, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 3.4 tests yearly maintenance when it is active and the current
	 * date is not in between the start and end dates. The API implementation
	 * doesn't compare time. So no need of comparing the time expected output:
	 * under maintenance should be False
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceYearly_CurrentDateIsOutofBoundaryDates_Active() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "-10", "-5", yearly, active);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("2", "-3", "-2", "+5", "+10", yearly, active);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertFalse(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 3.5 tests yearly maintenance when it is not active regardless
	 * when is the current date. The API implementation doesn't compare time. So
	 * no need of comparing the time expected output: under maintenance should
	 * be False
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceYearly_NotActive() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "-10", "-5", yearly, notActive);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("2", "-3", "-2", "+5", "+10", yearly, notActive);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("3", "-3", "-2", "-5", "+5", yearly, notActive);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertFalse(pcmUMDTO.isUnderMaintenance());
	}

	/*
	 * Test Case: 4.1 tests all type of maintenance when they are not active
	 * even if they current. expected output: under maintenance should be False
	 * 
	 */
	@Test
	public void testPacManUnderMaintainanceAll_NotActive() throws Exception {
		String queryStr = QueryBuilder.getQuery("1", "-3", "-2", "-10", "-5", daily, notActive);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("2", "-3", "-2", "+5", "+10", monthly, notActive);
		dbHelper.executeOra(queryStr);

		queryStr = QueryBuilder.getQuery("3", "-3", "-2", "-5", "+5", yearly, notActive);
		dbHelper.executeOra(queryStr);
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL, String.class);

		PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(responseEntity.getBody().toString(),
				PCMaintenanceResponseDTO.class);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertFalse(pcmUMDTO.isUnderMaintenance());
	}

	@AfterClass
	public static void tearUpAfterClass() {
		dbHelper.closeConnection();
	}

}
