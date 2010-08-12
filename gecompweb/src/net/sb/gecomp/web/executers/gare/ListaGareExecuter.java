package net.sb.gecomp.web.executers.gare;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;


public class ListaGareExecuter extends GaraExecuter {

	private Atleta atleta;
	public Atleta getAtleta() {return atleta;}
	public void setAtleta(Atleta atleta) {this.atleta = atleta;}
	public void setAtleti(List<GaraView> gare) {this.gare = gare;}
	
	private List<GaraView> gare;
	public List<GaraView> getGare() {return gare;}

	public ListaGareExecuter() {
		try {
			checks4SelectedCompetizione();
			CompetizioneView competizione = getSelectedCompetizione();
			gare = delegate.list(competizione);
		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
		}
	}

}
