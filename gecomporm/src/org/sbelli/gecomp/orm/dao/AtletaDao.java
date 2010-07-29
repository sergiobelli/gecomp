package org.sbelli.gecomp.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Prestazione;

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
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public Atleta get (Long id) throws GeCompOrmException {
		try {
			return (Atleta) getDataBaseDao().queryForObject(GET_ATLETA, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Atleta insert (Atleta atleta) throws GeCompOrmException {
		try {
			return (Atleta) getDataBaseDao().insert(INSERT_ATLETA, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Atleta> list () throws GeCompOrmException {
		try {
			return (List<Atleta>) getDataBaseDao().queryForList(LIST_ATLETA);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (Atleta atleta) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_ATLETA, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
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
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return atletiIscritti;
	}
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
}
