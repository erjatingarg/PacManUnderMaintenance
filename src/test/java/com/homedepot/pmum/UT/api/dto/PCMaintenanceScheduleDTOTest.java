package com.homedepot.pmum.UT.api.dto;

import org.junit.*;

import com.homedepot.pmum.api.dto.PCMaintenanceScheduleDTO;

import static org.junit.Assert.*;

/**
 * The class <code>PCMaintenanceScheduleDTOTest</code> contains tests for the class <code>{@link PCMaintenanceScheduleDTO}</code>.
 *
 * 
 * @author 382868
 * @version $Revision: 1.0 $
 */
public class PCMaintenanceScheduleDTOTest {
    /**
     * Run the PCMaintenanceScheduleDTO() constructor test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testPCMaintenanceScheduleDTO_1()
        throws Exception {

        PCMaintenanceScheduleDTO result = new PCMaintenanceScheduleDTO();
       
        assertNotNull(result);
    }

    /**
     * Run the int compare(PCMaintenanceScheduleDTO,PCMaintenanceScheduleDTO) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testCompare_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");
        PCMaintenanceScheduleDTO object1 = new PCMaintenanceScheduleDTO();
        PCMaintenanceScheduleDTO object2 = new PCMaintenanceScheduleDTO();

        int result = fixture.compare(object1, object2);

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the int compare(PCMaintenanceScheduleDTO,PCMaintenanceScheduleDTO) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testCompare_2()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");
        PCMaintenanceScheduleDTO object1 = null;
        PCMaintenanceScheduleDTO object2 = new PCMaintenanceScheduleDTO();

        int result = fixture.compare(object1, object2);

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the int compare(PCMaintenanceScheduleDTO,PCMaintenanceScheduleDTO) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testCompare_3()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");
        PCMaintenanceScheduleDTO object1 = new PCMaintenanceScheduleDTO();
        PCMaintenanceScheduleDTO object2 = null;

        int result = fixture.compare(object1, object2);

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the int compare(PCMaintenanceScheduleDTO,PCMaintenanceScheduleDTO) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testCompare_4()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId((Integer) null);
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");
        PCMaintenanceScheduleDTO object1 = new PCMaintenanceScheduleDTO();
        object1.setMaintSchId((Integer) 2);
        PCMaintenanceScheduleDTO object2 = new PCMaintenanceScheduleDTO();

        int result = fixture.compare(object1, object2);

        // add additional test code here
        assertEquals(0, result);
    }

    /**
     * Run the int compare(PCMaintenanceScheduleDTO,PCMaintenanceScheduleDTO) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testCompare_5()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId((Integer) null);
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");
        PCMaintenanceScheduleDTO object1 = new PCMaintenanceScheduleDTO();
        PCMaintenanceScheduleDTO object2 = new PCMaintenanceScheduleDTO();
        object2.setMaintSchId((Integer) 2);
        
        int result = fixture.compare(object1, object2);

        // add additional test code here
        assertEquals(0, result);
    }
    /**
     * Run the int compare(PCMaintenanceScheduleDTO,PCMaintenanceScheduleDTO) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testCompare_6()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId((Integer) null);
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");
        PCMaintenanceScheduleDTO object1 = new PCMaintenanceScheduleDTO();
        PCMaintenanceScheduleDTO object2 = new PCMaintenanceScheduleDTO();
        object1.setMaintSchId((Integer) 3);
        object2.setMaintSchId((Integer) 2);
        
        int result = fixture.compare(object1, object2);

        // add additional test code here
        assertEquals(-1, result);
    }
    /**
     * Run the int compare(PCMaintenanceScheduleDTO,PCMaintenanceScheduleDTO) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testCompare_7()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId((Integer) null);
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");
        PCMaintenanceScheduleDTO object1 = new PCMaintenanceScheduleDTO();
        PCMaintenanceScheduleDTO object2 = new PCMaintenanceScheduleDTO();
        object1.setMaintSchId((Integer) 2);
        object2.setMaintSchId((Integer) 3);
        
        int result = fixture.compare(object1, object2);

        // add additional test code here
        assertEquals(1, result);
    }
    /**
     * Run the String getActiveCheckValue() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetActiveCheckValue_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getActiveCheckValue();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the Boolean getActiveFlag() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetActiveFlag_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        Boolean result = fixture.getActiveFlag();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the String getAppName() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetAppName_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getAppName();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the short getFreqCode() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetFreqCode_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        short result = fixture.getFreqCode();

        // add additional test code here
        assertEquals((short) 1, result);
    }

    /**
     * Run the String getFreqDesc() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetFreqDesc_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getFreqDesc();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the Integer getId() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetId_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        Integer result = fixture.getId();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the String getLastUpdUserId() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetLastUpdUserId_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getLastUpdUserId();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the String getLastUpdateTs() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetLastUpdateTs_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getLastUpdateTs();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the String getMaintBeginDate() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetMaintBeginDate_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getMaintBeginDate();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the String getMaintBeginTime() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetMaintBeginTime_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getMaintBeginTime();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the String getMaintEndDate() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetMaintEndDate_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getMaintEndDate();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the String getMaintEndTime() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetMaintEndTime_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getMaintEndTime();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the Integer getMaintSchId() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetMaintSchId_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        Integer result = fixture.getMaintSchId();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the Integer getMmdAppId() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetMmdAppId_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        Integer result = fixture.getMmdAppId();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the short getPrcssTypCode() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetPrcssTypCode_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        short result = fixture.getPrcssTypCode();

        // add additional test code here
        assertEquals((short) 1, result);
    }

    /**
     * Run the String getProcessDesc() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetProcessDesc_1()
        throws Exception {
        PCMaintenanceScheduleDTO fixture = new PCMaintenanceScheduleDTO();
        fixture.setActiveCheckValue("");
        fixture.setAppName("");
        fixture.setId(new Integer(1));
        fixture.setFreqCode((short) 1);
        fixture.setLastUpdateTs("");
        fixture.setMaintEndTime("");
        fixture.setPrcssTypCode((short) 1);
        fixture.setMaintEndDate("");
        fixture.setMaintSchId(new Integer(1));
        fixture.setLastUpdUserId("");
        fixture.setActiveFlag(new Boolean(true));
        fixture.setMmdAppId(new Integer(1));
        fixture.setFreqDesc("");
        fixture.setMaintBeginDate("");
        fixture.setMaintBeginTime("");
        fixture.setProcessDesc("");

        String result = fixture.getProcessDesc();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the long getSerialversionuid() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testGetSerialversionuid_1()
        throws Exception {

        long result = PCMaintenanceScheduleDTO.getSerialversionuid();

        // add additional test code here
        assertEquals(1L, result);
    }

  

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *         if the initialization fails for some reason
     *
     * 
     */
    @Before
    public void setUp()
        throws Exception {
        // add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *         if the clean-up fails for some reason
     *
     * 
     */
    @After
    public void tearDown()
        throws Exception {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * 
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(PCMaintenanceScheduleDTOTest.class);
    }
}