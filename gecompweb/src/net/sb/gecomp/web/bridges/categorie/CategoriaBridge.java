package net.sb.gecomp.web.bridges.categorie;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.commons.services.ICategoriaGaraService;
import net.sb.gecomp.commons.services.ICategoriaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.services.categorie.CategoriaGaraService;
import net.sb.gecomp.srv.services.categorie.CategoriaService;
import net.sb.gecomp.web.bridges.GenericBridge;


public class CategoriaBridge extends GenericBridge {

	private final ICategoriaService service = new CategoriaService();
	private final ICategoriaGaraService categoriaGaraService = new CategoriaGaraService();
	
	public void delete(GecompModelObject element) throws GeCompException {
		service.delete(((Categoria)element).getIdCategoria());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompException {
		return service.save((Categoria)element);	
	}

	public void update(GecompModelObject element) throws GeCompException {
		service.save((Categoria)element);
	}

	public CategoriaView get(Long id) throws GeCompException {
		return new CategoriaView(service.get(id));
	}

	public List<CategoriaView> list() throws GeCompException {
		logger.info("start...");
		
		List<CategoriaView> result = new ArrayList<CategoriaView>();
		List<Categoria> categorie = service.list();
		logger.info("categorie = " + categorie);
		
		if (Eval.isNotEmpty(categorie)) {
			for (Categoria categoria : categorie) {
				result.add(new CategoriaView(categoria));
			}
		}
		logger.info("result = " + result);
		
		logger.info("end");
		return result;
	}
	public List<CategoriaView> list(Gara gara) throws GeCompException {
		logger.info("start...");
		
		List<CategoriaView> result = null;
		List<CategoriaGara> categorie = categoriaGaraService.list(gara);
		logger.info("categorie = " + categorie);
		
		if (Eval.isNotEmpty(categorie)) {
			result = new ArrayList<CategoriaView>();
			for (CategoriaGara c : categorie) {
				CategoriaView pw = new CategoriaView(c.getCategoria());
				result.add(pw);
			}
		}
		logger.info("result = " + result);

		logger.info("end");
		return result;
	}

}
