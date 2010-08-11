package net.sb.gecomp.web.executers.gare;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.model.Atleta;
import net.sb.gecomp.model.Competizione;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;


public class ListaGareExecuter extends GaraExecuter {

	private Atleta atleta;

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	private List<Gara> gare;

	public List<Gara> getGare() {
		return gare;
	}

	public void setAtleti(List<Gara> gare) {
		this.gare = gare;
	}

	public ListaGareExecuter() {

		try {

			checks4SelectedCompetizione();

			Competizione competizione = getSelectedCompetizione();

			gare = DbManagerFactory.getInstance().getGaraDao().list(
					competizione);

		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
		}

	}

	public String salva() {

		Atleta tmpAtleta = getAtleta();

		try {
			DbManagerFactory.getInstance().getAtletaDao().insert(tmpAtleta);
		} catch (GeCompOrmException e) {
			e.printStackTrace();
		}

		return "";
	}

}
