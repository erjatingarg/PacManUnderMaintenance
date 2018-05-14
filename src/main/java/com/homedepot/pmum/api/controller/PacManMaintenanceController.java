package com.homedepot.pmum.api.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homedepot.pmum.api.Services.PacManMaintenanceService;
import com.homedepot.pmum.api.constants.BusinessMessageConstants;
import com.homedepot.pmum.api.constants.ServiceConstants;
import com.homedepot.pmum.api.dto.PCMaintenanceResponseDTO;
import com.homedepot.pmum.api.util.JSONConverter;



/**
 * This resource class is used to retrieve Price Change - Request Types.
 * 
 * @author TCS
 */
@RestController
@RequestMapping("/maintain")
public class PacManMaintenanceController {

	/** Instance of Log4J for the class. */
	private Logger logger = Logger.getLogger(PacManMaintenanceController.class);
	
	
	PacManMaintenanceService pacManUMService; 
	
	@Autowired
	public PacManMaintenanceController(PacManMaintenanceService pacManUMService){
		this.pacManUMService=pacManUMService;
	}
	 @RequestMapping(value = "/search", method = RequestMethod.GET, produces = {ServiceConstants.MIME_TYPE_APP_XML,ServiceConstants.MIME_TYPE_APP_JSON})
	public ResponseEntity<String> checkProcessUnderMaintenance () {
		
		  	long startTime = 0;
		  	if (logger.isDebugEnabled()) {
		        logger.debug("start checkProcessUnderMaintenance(int,String)");
		        
		        startTime = System.currentTimeMillis();
		    }

		    PCMaintenanceResponseDTO searchResponse = null;
		    String output = null;
		
		    try {
		    	Boolean underMaintenance=pacManUMService.getOnlineApplicationMaintenanceScheduleList();
		       
		
		        if(underMaintenance)
		        {
		        	searchResponse = new PCMaintenanceResponseDTO();
		        	searchResponse.setUnderMaintenance(true);
		        	searchResponse.setCode(BusinessMessageConstants.SUCCESS_CODE);
		        	searchResponse.setMessage(BusinessMessageConstants.SUCCMSG_PC_IS_UNDER_MAINT);
		        }else
		        {
		        	searchResponse = new PCMaintenanceResponseDTO();
		    		searchResponse.setUnderMaintenance(false);
		    		searchResponse.setCode(BusinessMessageConstants.SUCCESS_CODE);
		    		searchResponse.setMessage(BusinessMessageConstants.SUCCMSG_PC_IS_NOT_IN_MAINT);
		        }
		
		        // Convert Java Object to JSON String (output)
		        output = JSONConverter.toJson(searchResponse);
		
		    } catch (Exception ex) {
		    	logger.error("Exception occurred - checkProcessUnderMaintenance() : ",
						ex);
		    	
		    	
		    }
		
		    if (logger.isDebugEnabled()) {
		        logger.debug("checkProcessUnderMaintenance() - Output : " + output);
		        logger.debug("finish checkProcessUnderMaintenance(): "
		                + (System.currentTimeMillis() - startTime));
		    }
		    return ResponseEntity.ok().cacheControl(CacheControl.noCache()).contentType(MediaType.APPLICATION_JSON).body(output);
		}			
	}
