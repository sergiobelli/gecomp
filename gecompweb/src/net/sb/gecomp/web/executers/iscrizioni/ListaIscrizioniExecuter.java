package net.sb.gecomp.web.executers.iscrizioni;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

public class ListaIscrizioniExecuter extends IscrizioneExecuter {
	
	public ListaIscrizioniExecuter() {
		try {
			checks4SelectedCompetizione();
			if (Eval.isNotNull(getSelectedGara())) {
				setIscrizioni(delegate.list(getSelectedGara()));
			} else {
				setIscrizioni(delegate.list(getSelectedCompetizione()));
			}
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "net.sb.gecomp.console.iscrizioni.executers.generic_error");
		}
	}
	
}
