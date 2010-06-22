package org.sbelli.gecomp.console.gare.delegates;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.console.gare.bridges.GaraBridge;
import org.sbelli.gecomp.console.gare.controllers.GaraController;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.CategoriaGara;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class GaraDelegate extends GenericDelegate {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private GaraController controller = new GaraController();
	private GaraBridge bridge = new GaraBridge();
	
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
	
	public void save(Gara element, List<Long> categorie) throws GeCompException {
		
		Gara gara = (Gara) retrieve(element);
		logger.debug("Customized Gara = " + gara);
		
		if (Eval.isNull(gara.getIdGara())) {
			gara = (Gara) bridge.insert(gara);
			if (Eval.isNotNull(categorie)) {
				for (Long cat : categorie) {
					Categoria categoria = DbManagerFactory.getInstance().getCategoriaDao().get(cat);
					CategoriaGara categoriaGara = new CategoriaGara(categoria, gara);
					DbManagerFactory.getInstance().getCategoriaGaraDao().insert(categoriaGara);
				}
			}
		} else {
			//TODO: si tratta di un update!!!!!!!!!!
		}
		
	}

	public Gara get(Long idGara) throws GeCompException {
		return bridge.get(idGara);
	}
}
