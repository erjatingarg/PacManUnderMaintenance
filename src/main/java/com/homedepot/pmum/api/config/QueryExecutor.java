package com.homedepot.pmum.api.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.homedepot.pmum.api.exception.FatalException;

public class QueryExecutor {

	private static final Logger LOGGER = LogManager.getLogger(QueryExecutor.class);

	private static final String TIME_TOOK = "time took to execute ##";
	private static final String MIILIS = "## millis";

	@FunctionalInterface
	public interface ResultSetCallBack<T> {
		public T results(ResultSet rs);
	}

	public <T> T executeOra(String sql, ResultSetCallBack<T> cb, Object... parms) {
		T result = null;
		Connection con = null;
		ResultSet rs = null;
		long startTime = 0;
		if (LOGGER.isWarnEnabled()) {
			startTime = System.currentTimeMillis();
		}
		PreparedStatement ps = null;
		try {
			con = TransactionManager.getOraConnection();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(" SQL #" + sql);
			}
			ps = con.prepareStatement(sql);
			if (Objects.nonNull(parms)) {
				int index = 0;
				for (Object obj : parms) {
					ps.setObject(++index, obj);
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("PARAMETERS #" + index + " = " + obj);
					}
				}
			}
			rs = ps.executeQuery();
			result = cb.results(rs);

		} catch (Exception exp) {
			throw new FatalException(QueryExecutor.buildQueryForLogging(sql, parms)+"\n",exp);
		} finally {

			TransactionManager.close(ps, rs);
			TransactionManager.close(con, null);
			if (LOGGER.isWarnEnabled()) {
				LOGGER.warn(TIME_TOOK + (System.currentTimeMillis() - startTime) + MIILIS
						+ QueryExecutor.buildQueryForLogging(sql, parms));
			}
		}
		return result;
	}

	private static String buildQueryForLogging(String sql, Object[] parms) {
		StringBuilder sb = new StringBuilder();

		sb.append("SQL#").append(sql);

		if (Objects.nonNull(parms)) {
			int index = 0;
			for (Object parm : parms) {
				sb.append("PARM[" + index + "]").append(parm);
				index++;
			}
		}

		return sb.toString();
	}

}
