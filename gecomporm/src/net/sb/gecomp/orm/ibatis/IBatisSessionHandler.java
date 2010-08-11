package net.sb.gecomp.orm.ibatis;

import java.net.URL;

import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 
 * @author sbelli
 * @deprecated
 */
public class IBatisSessionHandler {
	protected static final GeCompLogger logger = GeCompLogger.getGeCompLogger(IBatisSessionHandler.class.getName());
	
	private static SqlMapClient sqlMapClient;
	private static IBatisSessionHandler instance;
	public static IBatisSessionHandler getInstance () {
		if (instance == null) {
			instance = new IBatisSessionHandler();
		}
		return instance;
	}
	
	private static final String SQL_MAP_CONFIG = "org/sbelli/gecomp/orm/ibatis/SqlMapConfig.xml";
	private IBatisSessionHandler() {
		
		logger.info("Trying to get IBatis configuration...");
		try {
			if (sqlMapClient == null) {
				
				URL url = ClassLoader.getSystemResource(SQL_MAP_CONFIG);
				logger.debug("url = " + url);
				if (Eval.isNull(url)) { throw new Exception("Unable to retrieve sql configuration!"); }
				
				sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(url.openStream());
			}
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
		logger.info("Trying to get IBatis configuration = DONE");
		
	}
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	
}
