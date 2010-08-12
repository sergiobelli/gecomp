package net.sb.gecomp.srv.orm.ibatis;

import java.net.URL;

import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * 
 * @author 
 * @deprecated
 */
public class IBatisSessionHandler {
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private static SqlMapClient sqlMapClient;
	private static IBatisSessionHandler instance;
	public static IBatisSessionHandler getInstance () {
		if (instance == null) {
			instance = new IBatisSessionHandler();
		}
		return instance;
	}
	
	private static final String SQL_MAP_CONFIG = "net/sb/gecomp/srv/orm/ibatis/SqlMapConfig.xml";
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
