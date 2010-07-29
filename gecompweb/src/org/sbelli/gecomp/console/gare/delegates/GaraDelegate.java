package org.sbelli.gecomp.console.gare.delegates;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.bridges.view.CategoriaGaraView;
import org.sbelli.gecomp.console.bridges.view.GaraView;
import org.sbelli.gecomp.console.categorie.bridges.CategoriaBridge;
import org.sbelli.gecomp.console.categorie.bridges.CategoriaGaraBridge;
import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.console.gare.bridges.GaraBridge;
import org.sbelli.gecomp.console.gare.controllers.GaraController;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.CategoriaGara;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class GaraDelegate extends GenericDelegate {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private GaraController controller = new GaraController();
	private GaraBridge bridge = new GaraBridge();
	private CategoriaBridge categoriaBridge = new CategoriaBridge();
	private CategoriaGaraBridge categoriaGaraBridge = new CategoriaGaraBridge();
	
	public void delete(GecompModelObject element) throws GeCompException {
		bridge.delete((Gara)element);
	}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Gara gara = (Gara)element;
		controller.checks(element);
		return gara;
	}

	public void save(GecompModelObject element) throws GeCompException {
		Gara gara = (Gara) retrieve(element);
		logger.debug("Customized Gara = " + gara);
		if (Eval.isNull(gara.getIdGara())) {
			gara = (Gara)bridge.insert(gara);
		} else {
			bridge.update(gara);
		}
	}
	
	public void save(Gara element, List<Long> categorieId) throws GeCompException {//TODO:tutto il codice seguente dovrebbe essere messo in transazione lato server!!!!
		
		Gara gara = (Gara) retrieve(element);
		logger.debug("Customized Gara = " + gara);
		
		List<Categoria> categorie = new ArrayList<Categoria>();
		for (Long catId : categorieId) {
			categorie.add(categoriaBridge.get(catId));
		}
		gara.setCategorie(categorie);
		
		if (Eval.isNull(gara.getIdGara())) {
			gara = (Gara) bridge.insert(gara);
			if (Eval.isNotEmpty(gara.getCategorie())) {
				for (Categoria cat : gara.getCategorie()) {
					CategoriaGara catGara = new CategoriaGara();
					catGara.setCategoria(cat);
					catGara.setGara(gara);
					categoriaGaraBridge.insert(catGara);
				}
			}
		} else {
			
			//cancello le vecchie categorie associate alla gara
			List<CategoriaGaraView> oldCategorieGara = categoriaGaraBridge.list(gara);
			if (Eval.isNotEmpty(oldCategorieGara)) {
				for (CategoriaGara oldCategoriaGara : oldCategorieGara) {
					categoriaGaraBridge.delete(oldCategoriaGara);
				}
			}
			
			bridge.update(gara);//update
			if (Eval.isNotEmpty(gara.getCategorie())) {//inserisco nuove categorie
				for (Categoria cat : gara.getCategorie()) {
					CategoriaGara catGara = new CategoriaGara();
					catGara.setCategoria(cat);
					catGara.setGara(gara);
					categoriaGaraBridge.insert(catGara);
				}
			}
		}
		
	}
//	if (Eval.isNull(gara.getIdGara())) {
//		gara = (Gara) bridge.insert(gara);
//		if (Eval.isNotNull(categorieId)) {
//			for (Long cat : categorieId) {
//				Categoria categoria = DbManagerFactory.getInstance().getCategoriaDao().get(cat);
//				CategoriaGara categoriaGara = new CategoriaGara(categoria, gara);
//				DbManagerFactory.getInstance().getCategoriaGaraDao().insert(categoriaGara);
//			}
//		}
//	} else {
//		//TODO: si tratta di un update!!!!!!!!!!
//	}
	public GaraView get(Long idGara) throws GeCompException {
		return bridge.get(idGara);
	}
}
