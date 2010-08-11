package net.sb.gecomp.orm.ibatis;

import java.sql.SQLException;

import net.sb.gecomp.utils.Eval;

import org.apache.log4j.Logger;
import net.sb.gecomp.orm.ibatis.DataBaseDao;

public class DbManager {
	private static final Logger logger = Logger.getLogger(DbManager.class);
	
	private DataBaseDao dataBaseDao;
	public DataBaseDao getDataBaseDao() {return dataBaseDao;}
	public void setDataBaseDao(DataBaseDao dataBaseDao) {this.dataBaseDao = dataBaseDao;}
	
	public void ping() throws Exception {
		try {
			String message = "DataBase not reachable ! ";
			if (Eval.isNull(getDataBaseDao().getSqlMapClient())) {
				throw new Exception(message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("Database not reachable !!! ",ex);
			throw ex;
		}
	}
	
	protected void startTransaction() throws SQLException {
		getDataBaseDao().getSqlMapClient().startTransaction();
	}
	protected void commitTransaction() throws SQLException {
		getDataBaseDao().getSqlMapClient().commitTransaction();
	}
	protected void endTransaction() {
		try {
			getDataBaseDao().getSqlMapClient().endTransaction();
			getDataBaseDao().getDataSource().getConnection().close();
		} catch (SQLException e) {
			logger.warn("Connection not properly closed or just closed connection ! ", e);
		} catch (Exception e) {
			logger.error("System error in closing connection ! ", e);
		}
	}
	
}
