package org.sbelli.gecomp.console.gare.bridges;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.console.bridges.view.GaraView;
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
