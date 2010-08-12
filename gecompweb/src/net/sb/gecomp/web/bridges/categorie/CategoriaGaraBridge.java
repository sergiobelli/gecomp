package net.sb.gecomp.web.bridges.categorie;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CategoriaGaraView;
import net.sb.gecomp.commons.services.ICategoriaGaraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.services.categorie.CategoriaGaraService;
import net.sb.gecomp.web.bridges.GenericBridge;


public class CategoriaGaraBridge extends GenericBridge {

	private final ICategoriaGaraService service = new CategoriaGaraService();
	
	public void delete(GecompModelObject element) throws GeCompException {
		service.delete(((CategoriaGara)element).getIdCategoriaGara());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompException {
		return service.save((CategoriaGara)element);	
	}

	public void update(GecompModelObject element) throws GeCompException {
		service.save((CategoriaGara)element);
	}

	public CategoriaGaraView get(Long id) throws GeCompException {
		return new CategoriaGaraView(service.get(id));
	}

	public List<CategoriaGaraView> list(Gara gara) throws GeCompException {
		List<CategoriaGaraView> result = null;
		List<CategoriaGara> categorie = service.list(gara);
		if (Eval.isNotEmpty(categorie)) {
			result = new ArrayList<CategoriaGaraView>();
			for (CategoriaGara c : categorie) {
				CategoriaGaraView pw = new CategoriaGaraView(c);
				result.add(pw);
			}
		}
		return result;
	}
}
