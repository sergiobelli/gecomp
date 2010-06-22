package org.sbelli.gecomp.orm.dao;

import java.util.List;

import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;

public class GaraDao extends DbManager implements IGeCompDao<Gara> {
	
	protected static final String GET_GARA = "Gara.selectGara";
	protected static final String LIST_GARA = "Gara.listGara";
	protected static final String LIST_GARA_COMPETIZIONE = "Gara.listGaraCompetizione";
	protected static final String INSERT_GARA = "Gara.insertGara";
	protected static final String UPDATE_GARA = "Gara.updateGara";
	protected static final String DELETE_GARA = "Gara.deleteGara";
	
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_GARA, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());

		}
	}
	
	public Gara get (Long id) throws GeCompOrmException {
		try {
			return (Gara) getDataBaseDao().queryForObject(GET_GARA, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Gara insert (Gara gara) throws GeCompOrmException {
		try {
			Long id = (Long) getDataBaseDao().insert(INSERT_GARA, gara);
			return gara;
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Gara> list () throws GeCompOrmException {
		try {
			return (List<Gara>) getDataBaseDao().queryForList(LIST_GARA);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public List<Gara> list (Competizione competizione) throws GeCompOrmException {
		List<Gara> listaGareCompetizione = null;
		try {
//			List<Gara> listaGare = (List<Gara>) getDataBaseDao().queryForList(LIST_GARA);
//			listaGareCompetizione = new ArrayList<Gara>();
//			
//			for (Gara gara : listaGare) {
//				if (gara.getCompetizione().getIdCompetizione() == competizione.getIdCompetizione()) {
//					listaGareCompetizione.add(gara);
//				}
//			}

			listaGareCompetizione = (List<Gara>) getDataBaseDao().queryForList(LIST_GARA_COMPETIZIONE, competizione);
			
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return listaGareCompetizione;
	}
	public void update (Gara gara) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_GARA, gara);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
}
