package com.homedepot.pmum.UT.api.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.homedepot.pmum.api.Services.PacManMaintenanceService;
import com.homedepot.pmum.api.controller.PacManMaintenanceController;
import com.homedepot.pmum.api.dto.PCMaintenanceResponseDTO;
import com.homedepot.pmum.api.util.JSONConverter;

@RunWith(MockitoJUnitRunner.class)
public class TestPacManMaintenanceControllerUT {
	@Mock
	PacManMaintenanceService pacManUMService; 
	
	@InjectMocks
	PacManMaintenanceController pacManController;
		

	@Before
	public void setUp() throws Exception {
	}

	

	@Test
	public void testCheckProcessUnderMaintenance_isUndermaintainance() throws Exception  {
		when(pacManUMService.getOnlineApplicationMaintenanceScheduleList()).thenReturn(true);
		ResponseEntity<String> result=pacManController.checkProcessUnderMaintenance();
        PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(result.getBody().toString(),PCMaintenanceResponseDTO.class);
        assertTrue(pcmUMDTO.isUnderMaintenance());
		
	}
	@Test
	public void testCheckProcessUnderMaintenance_isNotUndermaintainance() throws Exception {
		
		when(pacManUMService.getOnlineApplicationMaintenanceScheduleList()).thenReturn(false);
		ResponseEntity<String> result=pacManController.checkProcessUnderMaintenance();
        PCMaintenanceResponseDTO pcmUMDTO = JSONConverter.createObject(result.getBody().toString(),PCMaintenanceResponseDTO.class);
        assertFalse(pcmUMDTO.isUnderMaintenance());
	}

}
