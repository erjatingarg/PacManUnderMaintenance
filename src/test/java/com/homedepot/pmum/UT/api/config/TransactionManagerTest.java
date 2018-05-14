package com.homedepot.pmum.UT.api.config;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.homedepot.pmum.UT.api.dao.BasePacManTest;
import com.homedepot.pmum.api.config.TransactionManager;

/**
 * The class <code>TransactionManagerTest</code> contains tests for the class
 * {@link <code>TransactionManager</code>}
 *
 * @pattern JUnit Test Case
 *
 *
 * @author JXG8934
 *
 * @version $Revision$
 */

public class TransactionManagerTest extends BasePacManTest {

	@Test
	public void testGetOraConnection() throws SQLException {
		Connection con = null;
		con = TransactionManager.getOraConnection();
		assertNotNull(con);
	}
}
