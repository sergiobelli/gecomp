package net.sb.gecomp.srv.services;

import net.sb.gecomp.srv.orm.dao.GenericDao;

import org.apache.log4j.Logger;

public abstract class GenericService {
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	private GenericDao dao;
	public GenericDao getDao() {return dao;}
	public void setDao(GenericDao dao) {this.dao = dao;}
}
