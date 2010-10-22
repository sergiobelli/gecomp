package net.sb.gecomp.web.delegates.gare;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CategoriaGaraView;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.categorie.CategoriaBridge;
import net.sb.gecomp.web.bridges.categorie.CategoriaGaraBridge;
import net.sb.gecomp.web.bridges.gare.GaraBridge;
import net.sb.gecomp.web.controllers.gare.GaraController;
import net.sb.gecomp.web.delegates.GenericDelegate;


public class GaraDelegate extends GenericDelegate {
	
	public GaraBridge getBridge() {return (GaraBridge)super.getBridge();}
	public void setBridge(GaraBridge bridge) {super.setBridge(bridge);}

	private GaraController controller;
	public GaraController getController() {return controller;}
	public void setController(GaraController controller) {this.controller = controller;}

	private CategoriaBridge categoriaBridge;
	public CategoriaBridge getCategoriaBridge() {return categoriaBridge;}
	public void setCategoriaBridge(CategoriaBridge categoriaBridge) {this.categoriaBridge = categoriaBridge;}

	private CategoriaGaraBridge categoriaGaraBridge;
	public CategoriaGaraBridge getCategoriaGaraBridge() {return categoriaGaraBridge;}
	public void setCategoriaGaraBridge(CategoriaGaraBridge categoriaGaraBridge) {this.categoriaGaraBridge = categoriaGaraBridge;}

	public void delete(GecompModelObject element) throws GeCompException {
		getBridge().delete((GaraView)element);
	}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		GaraView gara = (GaraView)element;
		getController().checks(element);
		return gara;
	}

	public void save(GecompModelObject element) throws GeCompException {
		GaraView gara = (GaraView) retrieve(element);
		logger.debug("Customized Gara = " + gara);
		if (Eval.isNull(gara.getIdGara())) {
			gara = getBridge().insert(gara);
		} else {
			getBridge().update(gara);
		}
	}
	
	//TODO: FS#78 - GaraDelegate : spostare codice salvataggio su lato server 
	public void save(GaraView element, List<Long> categorieId) throws GeCompException {//TODO:tutto il codice seguente dovrebbe essere messo in transazione lato server!!!!
		
		GaraView gara = (GaraView) retrieve(element);
		logger.debug("Customized Gara = " + gara);
		
		List<Categoria> categorie = new ArrayList<Categoria>();
		for (Long catId : categorieId) {
			categorie.add(getCategoriaBridge().get(catId));
		}
		gara.setCategorie(categorie);
		
		if (Eval.isNull(gara.getIdGara())) {
			gara = getBridge().insert(gara);
			if (Eval.isNotEmpty(gara.getCategorie())) {
				for (Categoria cat : gara.getCategorie()) {
					CategoriaGaraView catGara = new CategoriaGaraView();
					catGara.setCategoria(cat);
					catGara.setGara(gara);
					getCategoriaGaraBridge().insert(catGara);
				}
			}
		} else {
			
			//cancello le vecchie categorie associate alla gara
			List<CategoriaGaraView> oldCategorieGara = getCategoriaGaraBridge().list(gara);
			if (Eval.isNotEmpty(oldCategorieGara)) {
				for (CategoriaGaraView oldCategoriaGara : oldCategorieGara) {
					getCategoriaGaraBridge().delete(oldCategoriaGara);
				}
			}
			
			getBridge().update(gara);//update
			if (Eval.isNotEmpty(gara.getCategorie())) {//inserisco nuove categorie
				for (Categoria cat : gara.getCategorie()) {
					CategoriaGaraView catGara = new CategoriaGaraView();
					catGara.setCategoria(cat);
					catGara.setGara(gara);
					getCategoriaGaraBridge().insert(catGara);
				}
			}
		}
	}
	//TODO: FS#78 - GaraDelegate : spostare codice salvataggio su lato server 
	
	public GaraView get(Long idGara) throws GeCompException {
		return getBridge().get(idGara);
	}
	
	public List<GaraView> list() throws GeCompException {
		return getBridge().list();
	}
	
	public List<GaraView> list(CompetizioneView competizione) throws GeCompException {
		return getBridge().list(competizione);
	}
}
