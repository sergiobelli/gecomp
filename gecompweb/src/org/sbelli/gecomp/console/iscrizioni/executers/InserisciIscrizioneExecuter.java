package org.sbelli.gecomp.console.iscrizioni.executers;

import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Iscrizione;

public class InserisciIscrizioneExecuter extends IscrizioneExecuter {

	public InserisciIscrizioneExecuter () {
		try {
			Gara gara = new Gara();
			if (isSelectedGara()) {
				gara = getSelectedGara();
			}
			this.setIscrizione(new Iscrizione(new Atleta(), gara));
			setListaGareItem(getHelper().getListaGareItem(getSelectedCompetizione()));
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "");
		}
		
	}

	public String salva() {

		try {
			logger.info("Saving new Iscrizione...");

			Iscrizione tmpIscrizione = retrieve();
			logger.debug("Customized Iscrizione = " + tmpIscrizione);

//			GaraController garaController = new GaraController(tmpIscrizione); 
//			garaController.checks();
			//TODO:Aggiunger controlli!!!!!!!!!
			DbManagerFactory.getInstance().getIscrizioneDao().insert(tmpIscrizione);

			logger.info("Saved new Iscrizione...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.salvataggio.ko");
			return "null";
		}

		return "listaIscrizioni";
	}
}
