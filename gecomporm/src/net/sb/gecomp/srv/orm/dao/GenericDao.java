package net.sb.gecomp.srv.orm.dao;

import net.sb.gecomp.srv.orm.ibatis.DbManager;

import org.apache.log4j.Logger;

public abstract class GenericDao extends DbManager /*implements IGeCompDao<GecompModelObject> */{

	protected Logger logger = Logger.getLogger(this.getClass());
}
