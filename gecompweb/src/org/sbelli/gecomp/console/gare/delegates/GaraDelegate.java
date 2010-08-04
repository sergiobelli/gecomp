package org.sbelli.gecomp.console.gare.delegates;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.bridges.view.CategoriaGaraView;
import org.sbelli.gecomp.console.bridges.view.CategoriaView;
import org.sbelli.gecomp.console.bridges.view.GaraView;
import org.sbelli.gecomp.console.categorie.bridges.CategoriaBridge;
import org.sbelli.gecomp.console.categorie.bridges.CategoriaGaraBridge;
import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.console.gare.bridges.GaraBridge;
import org.sbelli.gecomp.console.gare.controllers.GaraController;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class GaraDelegate extends GenericDelegate {
	
	protected GeCompLogger 		logger 				= GeCompLogger.getGeCompLogger(this.getClass().getName());

	private GaraController 		controller 			= new GaraController();
	
	private GaraBridge 			garaBridge 			= new GaraBridge();
	private CategoriaBridge 	categoriaBridge 	= new CategoriaBridge();
	private CategoriaGaraBridge categoriaGaraBridge = new CategoriaGaraBridge();
	
	public void delete(GecompModelObject element) throws GeCompException {
		garaBridge.delete((GaraView)element);
	}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		GaraView gara = (GaraView)element;
		controller.checks(element);
		return gara;
	}

	public void save(GecompModelObject element) throws GeCompException {
		GaraView gara = (GaraView) retrieve(element);
		logger.debug("Customized Gara = " + gara);
		if (Eval.isNull(gara.getIdGara())) {
			gara = garaBridge.insert(gara);
		} else {
			garaBridge.update(gara);
		}
	}
	
	public void save(GaraView element, List<Long> categorieId) throws GeCompException {//TODO:tutto il codice seguente dovrebbe essere messo in transazione lato server!!!!
		
		GaraView gara = (GaraView) retrieve(element);
		logger.debug("Customized Gara = " + gara);
		
		List<Categoria> categorie = new ArrayList<Categoria>();
		for (Long catId : categorieId) {
			categorie.add(categoriaBridge.get(catId));
		}
		gara.setCategorie(categorie);
		
		if (Eval.isNull(gara.getIdGara())) {
			gara = garaBridge.insert(gara);
			if (Eval.isNotEmpty(gara.getCategorie())) {
				for (Categoria cat : gara.getCategorie()) {
					CategoriaGaraView catGara = new CategoriaGaraView();
					catGara.setCategoria(cat);
					catGara.setGara(gara);
					categoriaGaraBridge.insert(catGara);
				}
			}
		} else {
			
			//cancello le vecchie categorie associate alla gara
			List<CategoriaGaraView> oldCategorieGara = categoriaGaraBridge.list(gara);
			if (Eval.isNotEmpty(oldCategorieGara)) {
				for (CategoriaGaraView oldCategoriaGara : oldCategorieGara) {
					categoriaGaraBridge.delete(oldCategoriaGara);
				}
			}
			
			garaBridge.update(gara);//update
			if (Eval.isNotEmpty(gara.getCategorie())) {//inserisco nuove categorie
				for (Categoria cat : gara.getCategorie()) {
					CategoriaGaraView catGara = new CategoriaGaraView();
					catGara.setCategoria(cat);
					catGara.setGara(gara);
					categoriaGaraBridge.insert(catGara);
				}
			}
		}
		
	}

	public GaraView get(Long idGara) throws GeCompException {
		return garaBridge.get(idGara);
	}
}
