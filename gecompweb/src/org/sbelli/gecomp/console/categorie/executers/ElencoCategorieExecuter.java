package org.sbelli.gecomp.console.categorie.executers;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.console.bridges.view.CategoriaView;

/**
 * @author sbelli
 */
public class ElencoCategorieExecuter extends CategoriaExecuter {

	private List<CategoriaView> categorie;
	public List<CategoriaView> getCategorie() { return categorie; }
	public void setCategorie(List<CategoriaView> atleti) { this.categorie = atleti; }	
	
	public ElencoCategorieExecuter() {
		try {
			setCategorie(delegate.list());
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
		}
	}
	
}
