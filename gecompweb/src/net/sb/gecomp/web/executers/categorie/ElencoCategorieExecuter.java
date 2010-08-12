package net.sb.gecomp.web.executers.categorie;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


/**
 * @author 
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
