package net.sb.gecomp.srv.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManager;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

import org.apache.log4j.Logger;


public class AtletaDao extends DbManager implements IGeCompDao<Atleta> {

	private final String GET_ATLETA = "Atleta.selectAtleta";
	private final String LIST_ATLETA = "Atleta.listAtleta";
	private final String INSERT_ATLETA = "Atleta.insertAtleta";
	private final String UPDATE_ATLETA = "Atleta.updateAtleta";
	private final String DELETE_ATLETA = "Atleta.deleteAtleta";


    
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_ATLETA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public Atleta get (Long id) throws GeCompOrmException {
		try {
			return (Atleta) getDataBaseDao().queryForObject(GET_ATLETA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Atleta insert (Atleta atleta) throws GeCompOrmException {
		try {
			return (Atleta) getDataBaseDao().insert(INSERT_ATLETA, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Atleta> list () throws GeCompOrmException {
		try {
			return (List<Atleta>) getDataBaseDao().queryForList(LIST_ATLETA);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (Atleta atleta) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_ATLETA, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public List<Atleta> list(Competizione competizione) throws GeCompOrmException {
		
		List<Atleta> atletiIscritti = new ArrayList<Atleta>();
		try {
		
			List<Prestazione> tmpPrestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(competizione);
			for (Prestazione p : tmpPrestazioni) {
				if (!atletiIscritti.contains(p.getIscrizione().getAtleta())) { // FIXME : TIRA SU L'ATLETA TANTE VOLTE... il contains non funziona un cazzo !!!
					atletiIscritti.add(p.getIscrizione().getAtleta());
				}
			}
			
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return atletiIscritti;
	}
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
}