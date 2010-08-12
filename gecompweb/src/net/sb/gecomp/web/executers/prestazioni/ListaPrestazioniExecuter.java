package net.sb.gecomp.web.executers.prestazioni;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;


public class ListaPrestazioniExecuter extends PrestazioneExecuter {

	private List<Prestazione> prestazioni;
	public List<Prestazione> getPrestazioni() {return prestazioni;}
	public void setPrestazioni(List<Prestazione> prestazioni) {this.prestazioni = prestazioni;}
	
	public ListaPrestazioniExecuter() {
		try {
			checks4SelectedCompetizione();
			if (Eval.isNotNull(getSelectedGara())) {
				setPrestazioni(new ArrayList<Prestazione>(delegate.list(getSelectedGara())));
			} else {
				setPrestazioni(new ArrayList<Prestazione>(delegate.list(getSelectedCompetizione())));	
			}
		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
		}
	}
	
}
