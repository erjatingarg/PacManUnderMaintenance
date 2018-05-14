package com.homedepot.pmum.UT.api.dto;

import org.junit.*;

import com.homedepot.pmum.api.dto.PCMaintenanceResponseDTO;

import static org.junit.Assert.*;

/**
 * The class <code>PCMaintenanceResponseDTOTest</code> contains tests for the class <code>{@link PCMaintenanceResponseDTO}</code>.
 *
 * @version $Revision: 1.0 $
 */
public class PCMaintenanceResponseDTOTest {
    /**
     * Run the PCMaintenanceResponseDTO() constructor test.
     *
     */
    @Test
    public void testPCMaintenanceResponseDTO_1()
        throws Exception {
        PCMaintenanceResponseDTO result = new PCMaintenanceResponseDTO();
        assertNotNull(result);
        // add additional test code here
    }

    /**
     * Run the int getCode() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetCode_1()
        throws Exception {
        PCMaintenanceResponseDTO fixture = new PCMaintenanceResponseDTO();
        fixture.setUnderMaintenance(true);
        fixture.setMessage("");
        fixture.setCode(1);

        int result = fixture.getCode();

        // add additional test code here
        assertEquals(1, result);
    }

    /**
     * Run the String getMessage() method test.
     *
     * @throws Exception
     */
    @Test
    public void testGetMessage_1()
        throws Exception {
        PCMaintenanceResponseDTO fixture = new PCMaintenanceResponseDTO();
        fixture.setUnderMaintenance(true);
        fixture.setMessage("");
        fixture.setCode(1);

        String result = fixture.getMessage();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the long getSerialversionuid() method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetSerialversionuid_1()
        throws Exception {

        long result = PCMaintenanceResponseDTO.getSerialversionuid();

        // add additional test code here
        assertEquals(1L, result);
    }

    /**
     * Run the boolean isUnderMaintenance() method test.
     *
     * @throws Exception
     *
      */
    @Test
    public void testIsUnderMaintenance_1()
        throws Exception {
        PCMaintenanceResponseDTO fixture = new PCMaintenanceResponseDTO();
        fixture.setUnderMaintenance(true);
        fixture.setMessage("");
        fixture.setCode(1);

        boolean result = fixture.isUnderMaintenance();

        // add additional test code here
        assertTrue(result);
    }

    /**
     * Run the boolean isUnderMaintenance() method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testIsUnderMaintenance_2()
        throws Exception {
        PCMaintenanceResponseDTO fixture = new PCMaintenanceResponseDTO();
        fixture.setUnderMaintenance(false);
        fixture.setMessage("");
        fixture.setCode(1);

        boolean result = fixture.isUnderMaintenance();

        // add additional test code here
        assertFalse(result);
    }

    /**
     * Run the void setCode(int) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testSetCode_1()
        throws Exception {
        PCMaintenanceResponseDTO fixture = new PCMaintenanceResponseDTO();
        fixture.setUnderMaintenance(true);
        fixture.setMessage("");
        fixture.setCode(1);
        int code = 1;

        fixture.setCode(code);

        // add additional test code here
    }

    /**
     * Run the void setMessage(String) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testSetMessage_1()
        throws Exception {
        PCMaintenanceResponseDTO fixture = new PCMaintenanceResponseDTO();
        fixture.setUnderMaintenance(true);
        fixture.setMessage("");
        fixture.setCode(1);
        String message = "";

        fixture.setMessage(message);

        // add additional test code here
    }

    /**
     * Run the void setUnderMaintenance(boolean) method test.
     *
     * @throws Exception
     *
     * 
     */
    @Test
    public void testSetUnderMaintenance_1()
        throws Exception {
        PCMaintenanceResponseDTO fixture = new PCMaintenanceResponseDTO();
        fixture.setUnderMaintenance(true);
        fixture.setMessage("");
        fixture.setCode(1);
        boolean isUnderMaintenance = true;

        fixture.setUnderMaintenance(isUnderMaintenance);

        // add additional test code here
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
        new org.junit.runner.JUnitCore().run(PCMaintenanceResponseDTOTest.class);
    }
}