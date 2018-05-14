package com.homedepot.pmum.UT.api.Services;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.homedepot.pmum.UT.api.dao.BasePacManTest;
import com.homedepot.pmum.api.Services.PacManMaintenanceService;
import com.homedepot.pmum.api.dao.PCMaintenanceDAO;

public class PCMaintenanceManagerTest extends BasePacManTest {
	
	PacManMaintenanceService pcMaintenance;

	@Before
	public void setUp(){
		pcMaintenance=new PacManMaintenanceService(new PCMaintenanceDAO());
	}
	@Test
	public void testGetOnlineApplicationMaintenanceScheduleList() throws Exception {		

		Boolean result = pcMaintenance.getOnlineApplicationMaintenanceScheduleList();
		assertNotNull(result);
	}

}
