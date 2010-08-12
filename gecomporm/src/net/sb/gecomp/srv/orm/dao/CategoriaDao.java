package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManager;

import org.apache.log4j.Logger;


public class CategoriaDao extends DbManager implements IGeCompDao<Categoria> {
	
	protected static final String GET_CATEGORIA = "Categoria.selectCategoria";
	protected static final String LIST_CATEGORIA = "Categoria.listCategoria";
	protected static final String INSERT_CATEGORIA = "Categoria.insertCategoria";
	protected static final String UPDATE_CATEGORIA = "Categoria.updateCategoria";
	protected static final String DELETE_CATEGORIA = "Categoria.deleteCategoria";
	
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_CATEGORIA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());

		}
	}
	
	public Categoria get (Long id) throws GeCompOrmException {
		try {
			return (Categoria) getDataBaseDao().queryForObject(GET_CATEGORIA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Categoria insert (Categoria categoria) throws GeCompOrmException {
		try {
			return (Categoria) getDataBaseDao().insert(INSERT_CATEGORIA, categoria);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Categoria> list () throws GeCompOrmException {
		try {
			return (List<Categoria>) getDataBaseDao().queryForList(LIST_CATEGORIA);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (Categoria categoria) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_CATEGORIA, categoria);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Categoria> getCategorieCompetizione (Competizione competizione) {
		List<Categoria> c = null;
		
		return c;
	}
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
}
