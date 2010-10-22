package net.sb.gecomp.srv.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;


public class CategoriaGaraDao extends GenericDao implements IGeCompDao<CategoriaGara> {

	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_CATEGORIA_GARA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public CategoriaGara get (Long id) throws GeCompOrmException {
		try {
			return (CategoriaGara) getDataBaseDao().queryForObject(GET_CATEGORIA_GARA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public CategoriaGara insert (CategoriaGara categoriaGara) throws GeCompOrmException {
		try {
			return (CategoriaGara) getDataBaseDao().insert(INSERT_CATEGORIA_GARA, categoriaGara);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<CategoriaGara> list () throws GeCompOrmException {
		try {
			return (List<CategoriaGara>) getDataBaseDao().queryForList(LIST_CATEGORIA_GARA);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public List<CategoriaGara> list(Gara gara) throws GeCompOrmException {
		List<CategoriaGara> categorieGara = null;
		try {
			categorieGara = (List<CategoriaGara>) getDataBaseDao().queryForList(LIST_CATEGORIA_GARA_4_GARA, gara);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		return categorieGara;
	}
	
	public void update (CategoriaGara categoriaGara) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_CATEGORIA_GARA, categoriaGara);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public List<Categoria> listCategorie(Competizione competizione) throws GeCompOrmException {
		List<Categoria> categorie = new ArrayList<Categoria>();
		try {
			List<Gara> gare = DbManagerFactory.getInstance().getGaraDao().list(competizione);
			for (Gara gara : gare) {
				categorie.addAll(listCategorie(gara));
			}
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		return categorie;
	}
	public List<Categoria> listCategorie(Gara gara) throws GeCompOrmException {
		List<Categoria> categorie = null;
		try {
			List<CategoriaGara> categorieGara = (List<CategoriaGara>) getDataBaseDao().queryForList(LIST_CATEGORIA_GARA, gara);
			categorie = new ArrayList<Categoria>();
			for (CategoriaGara categoriaGara : categorieGara) {
				categorie.add(categoriaGara.getCategoria());
			}
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		return categorie;
	}
	
}
