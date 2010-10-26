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
import net.sb.gecomp.web.bridges.GenericBridge;


public class CategoriaGaraBridge extends GenericBridge {

	public ICategoriaGaraService getService() { return (ICategoriaGaraService) super.getService(); }
	public void setService(ICategoriaGaraService service) { super.setService(service); }
	
	public void delete(GecompModelObject element) throws GeCompException {
		getService().delete(((CategoriaGara)element).getIdCategoriaGara());
	}

	public CategoriaGaraView insert(GecompModelObject element) throws GeCompException {
		return new CategoriaGaraView((CategoriaGara)getService().save((CategoriaGara)element));	
	}

	public void update(GecompModelObject element) throws GeCompException {
		getService().save((CategoriaGara)element);
	}

	public CategoriaGaraView get(Long id) throws GeCompException {
		return new CategoriaGaraView((CategoriaGara)getService().get(id));
	}

	public List<CategoriaGaraView> list(Gara gara) throws GeCompException {
		List<CategoriaGaraView> result = null;
		List<CategoriaGara> categorie = ((ICategoriaGaraService)getService()).list4Gara(gara);
		if (Eval.isNotEmpty(categorie)) {
			result = new ArrayList<CategoriaGaraView>();
			for (CategoriaGara c : categorie) {
				CategoriaGaraView pw = new CategoriaGaraView(c);
				result.add(pw);
			}
		}
		return result;
	}
	
	public List<CategoriaGaraView> list() throws GeCompException {
		List<CategoriaGaraView> result = null;
		List<CategoriaGara> lista = getService().list();
		if (Eval.isNotEmpty(lista)) {
			result = new ArrayList<CategoriaGaraView>();
			for (CategoriaGara categoriaGara : lista) {
				result.add(new CategoriaGaraView(categoriaGara));
			}
		}
		return result;
	}

}
