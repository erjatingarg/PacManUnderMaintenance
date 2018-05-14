/*
 * This program is proprietary to The Home Depot and is not to be
 * reproduced, used, or disclosed without permission of:
 *
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 *
 * 
 */
package com.homedepot.pmum.api.Services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homedepot.pmum.api.dao.PCMaintenanceDAO;
import com.homedepot.pmum.api.exception.FatalException;
import com.homedepot.pmum.api.exception.ValidationException;
import com.homedepot.pmum.api.util.StringUtil;



/**
 * Service class which calls the DAO layer /
 * 
 * @author
 */
@Service
public class PacManMaintenanceService {

	/** Instance of Log4J for the class. */
	private static Logger logger = Logger.getLogger(PacManMaintenanceService.class);
	PCMaintenanceDAO pcMaintenanceDAO;

	
	@Autowired
	public PacManMaintenanceService(PCMaintenanceDAO pcMaintenanceDAO){
		this.pcMaintenanceDAO=pcMaintenanceDAO;
	}
	
    public Boolean getOnlineApplicationMaintenanceScheduleList ()  {

        long startTime = 0;

        if (logger.isDebugEnabled()) {
            logger.debug("start getOnlineApplicationMaintenanceScheduleList()");
            startTime = System.currentTimeMillis();
        }

        final List<Boolean> underMaintenanceList = new ArrayList<Boolean>();

        try { 
        		underMaintenanceList.add(pcMaintenanceDAO.getPacManMaintenanceSchedule());                     
                } catch (FatalException fex) {
            logger.error(
                    "Fatel Exception occurred - getOnlineApplicationMaintenanceScheduleList() : ", fex);
            throw  fex;
        } catch (ValidationException vex) {
            logger.error(
                    "Validation Exception occurred - getOnlineApplicationMaintenanceScheduleList() : ", vex);
            throw vex;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("finish getOnlineApplicationMaintenanceScheduleList(): "
                    + (System.currentTimeMillis() - startTime));
            logger.debug("getOnlineApplicationMaintenanceScheduleList() returning: "
                    + underMaintenanceList);
        }
        if(!StringUtil.isNullOrEmpty(underMaintenanceList))
        {
        	return underMaintenanceList.get(0);
        }else
        {
        	return false;
        }
    }	
}