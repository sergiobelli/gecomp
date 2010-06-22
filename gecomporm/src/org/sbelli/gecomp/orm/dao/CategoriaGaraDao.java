package org.sbelli.gecomp.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.CategoriaGara;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;

public class CategoriaGaraDao extends DbManager implements IGeCompDao<CategoriaGara> {
	protected static final GeCompLogger logger = GeCompLogger.getGeCompLogger(CategoriaGaraDao.class);


	private final String GET_CATEGORIA_GARA = "CategoriaGara.selectCategoriaGara";
	private final String LIST_CATEGORIA_GARA = "CategoriaGara.listCategoriaGara";
	private final String INSERT_CATEGORIA_GARA = "CategoriaGara.insertCategoriaGara";
	private final String UPDATE_CATEGORIA_GARA = "CategoriaGara.updateCategoriaGara";
	private final String DELETE_CATEGORIA_GARA = "CategoriaGara.deleteCategoriaGara";

	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_CATEGORIA_GARA, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public CategoriaGara get (Long id) throws GeCompOrmException {
		try {
			return (CategoriaGara) getDataBaseDao().queryForObject(GET_CATEGORIA_GARA, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public CategoriaGara insert (CategoriaGara categoriaGara) throws GeCompOrmException {
		try {
			return (CategoriaGara) getDataBaseDao().insert(INSERT_CATEGORIA_GARA, categoriaGara);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<CategoriaGara> list () throws GeCompOrmException {
		try {
			return (List<CategoriaGara>) getDataBaseDao().queryForList(LIST_CATEGORIA_GARA);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (CategoriaGara categoriaGara) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_CATEGORIA_GARA, categoriaGara);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
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
			GeCompExceptionManager.manageException(logger, e);
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
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		return categorie;
	}	
}
