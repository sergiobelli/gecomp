package org.sbelli.gecomp.console.iscrizioni.executers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;

public class ListaIscrizioniExecuter extends IscrizioneExecuter {
	
	public ListaIscrizioniExecuter() {
		try {
			checks4SelectedCompetizione();
			if (Eval.isNotNull(getSelectedGara())) {
				setIscrizioni(DbManagerFactory.getInstance().getIscrizioneDao().list(getSelectedGara()));
			} else {
				setIscrizioni(DbManagerFactory.getInstance().getIscrizioneDao().list(getSelectedCompetizione()));	
			}
		} catch (GeCompException e) {
			GeCompExceptionManager.manageException(logger, e);
		}
	}
	
}
