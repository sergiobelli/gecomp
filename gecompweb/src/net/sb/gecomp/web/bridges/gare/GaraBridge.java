package net.sb.gecomp.web.bridges.gare;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.GaraView;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class GaraBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompOrmException {
		GaraView gara = (GaraView) element;
		DbManagerFactory.getInstance().getGaraDao().delete(gara.getIdGara());
	}

	public GaraView insert(GecompModelObject element) throws GeCompOrmException {
		return new GaraView(DbManagerFactory.getInstance().getGaraDao().insert((Gara) element));
	}

	public void update(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getGaraDao().update((Gara) element);
	}

	public GaraView get(Long idGara) throws GeCompOrmException {
		GaraView gara = new GaraView(DbManagerFactory.getInstance().getGaraDao().get(idGara));
		List<Categoria> categorie = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(gara);
		gara.setCategorie(categorie);
		return gara;
	}

}
