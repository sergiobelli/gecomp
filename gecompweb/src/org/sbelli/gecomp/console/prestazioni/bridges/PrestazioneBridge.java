package org.sbelli.gecomp.console.prestazioni.bridges;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.console.bridges.view.PrestazioneView;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneBridge extends GenericBridge {

	public void delete(final GecompModelObject element) throws GeCompOrmException {
		throw new GeCompOrmException("NON IMPLEMENTATO!!!!");
	}

	public GecompModelObject get(final Long id) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getPrestazioneDao().get(id);
	}

	public GecompModelObject insert(final GecompModelObject element) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getPrestazioneDao().insert((Prestazione)element);	
	}

	public void update(final GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getPrestazioneDao().update((Prestazione) element);
	}

	public List<PrestazioneView> list(Gara gara) throws GeCompOrmException {
		List<PrestazioneView> result = null;
		List<Prestazione> prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(gara);
//		List<Categoria> categorie = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(gara);//FIXME:male,risolvere con FS#63
		if (Eval.isNotEmpty(prestazioni)) {
			result = new ArrayList<PrestazioneView>();
			int posizione = 1;
			for (Prestazione p : prestazioni) {
				PrestazioneView pw = new PrestazioneView(p, posizione++);
//				if (Eval.isEmpty(pw.getIscrizione().getGara().getCategorie())) {//FIXME:male,risolvere con FS#63
//					pw.getIscrizione().getGara().setCategorie(categorie);//FIXME:male,risolvere con FS#63
//				}//FIXME:male,risolvere con FS#63
				result.add(pw);
			}
		}
		return result;
	}

	public List<PrestazioneView> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompOrmException {
		List<PrestazioneView> result = null;
		List<Prestazione> prestazioni = null;
		if (conAssoluti) {
			prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(gara, categoria);	
		} else {
			prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().listSenzaAssoluti(gara, categoria);	
		}
		
		if (Eval.isNotEmpty(prestazioni)) {
			result = new ArrayList<PrestazioneView>();
			int posizione = 1;
			for (Prestazione p : prestazioni) {
				PrestazioneView pw = new PrestazioneView(p, posizione++);
				result.add(pw);
			}
		}
		return result;
	}

}
