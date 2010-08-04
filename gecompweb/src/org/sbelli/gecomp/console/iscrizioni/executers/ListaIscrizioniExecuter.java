package org.sbelli.gecomp.console.iscrizioni.executers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;

public class ListaIscrizioniExecuter extends IscrizioneExecuter {
	
	public ListaIscrizioniExecuter() {
		try {
			checks4SelectedCompetizione();
			if (Eval.isNotNull(getSelectedGara())) {
				setIscrizioni(delegate.list(getSelectedGara()));
			} else {
				setIscrizioni(delegate.list(getSelectedCompetizione()));
			}
		} catch (GeCompException e) {
			GeCompExceptionManager.manageException(logger, e);
		}
	}
	
}
