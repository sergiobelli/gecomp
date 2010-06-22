package org.sbelli.gecomp.console.categorie.executers;

import java.util.List;

import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;

import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;

/**
 * @author sbelli
 */
public class ElencoCategorieExecuter extends CategoriaExecuter {

	private List<Categoria> categorie;
	public List<Categoria> getCategorie() { return categorie; }
	public void setCategorie(List<Categoria> atleti) { this.categorie = atleti; }	
	
	public ElencoCategorieExecuter() {
		try {
			setCategorie(DbManagerFactory.getInstance().getCategoriaDao().list());
		} catch (GeCompOrmException e) {
			GeCompExceptionManager.manageException(logger, e);
		}
	}
	
}
