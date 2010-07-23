package org.sbelli.gecomp.console.competizione.executers;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.exceptions.MessageSeverity;

import org.sbelli.gecomp.console.competizione.controllers.CompetizioneController;
import org.sbelli.gecomp.console.menu.GeCompOutcomes;
import org.sbelli.gecomp.console.user.GeCompUserSessionHandler;
import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.console.utils.guimessages.GuiMessageHandler;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Societa;

public class ModificaCompetizioneExecuter extends CompetizioneExecuter {

	public String modifica () {
		logger.info("Modifica di una competizione...");
		return update ();

	}

	private String update () {
		String result = "listaCompetizioni";
		try {
			logger.info("Modifing Competizione...");

			final Competizione tmpCompetizione = (Competizione)delegate.retrieve(getCompetizione());
			logger.debug("Customized Competizione = " + tmpCompetizione);

			CompetizioneController competizioneController = new CompetizioneController(); 
			competizioneController.checks(tmpCompetizione);

			DbManagerFactory.getInstance().getCompetizioneDao().update(tmpCompetizione);

			logger.info("Modified Competizione...");

			GuiMessageHandler.addGUIMessage(
					MessageSeverity.info, 
					"message.competizione.modificata.ok", 
					"message.competizione.modificata.ok.descrizione");

		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.competizione.modificata.ko");
			result = "null";
		}


		return result;
	}

	public String modificaESeleziona () {

		String outcome = update ();

		try {
			GeCompUserSessionHandler.getGeCompUserSession().setCompetizione((Competizione)delegate.retrieve(getCompetizione()));
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.modificata.selezionata.ko");
		}

		GuiMessageHandler.addGUIMessage(
				MessageSeverity.info, 
				"message.competizione.modificata.selezionata.ok", 
				"message.competizione.modificata.selezionata.ok.descrizione");

		return outcome;
	}
	public String selezionaCompetizione () {

		try {

			Competizione comp = DbManagerFactory.getInstance().getCompetizioneDao().get(idCompetizione);
			GeCompUserSessionHandler.getGeCompUserSession().setCompetizione(comp);
			GeCompUserSessionHandler.getGeCompUserSession().setGara(null);
			
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezionata.ko");
		}

		GuiMessageHandler.addGUIMessage(MessageSeverity.info, "message.competizione.selezionata.ok", "message.competizione.selezionata.ok.descrizione");
		return "null";

	}

	public String modificaCompetizione () {
		return GeCompOutcomes.MODIFICA_COMPETIZIONE;
	}

	public void load (ActionEvent event) {

		idCompetizione = (Long) event.getComponent().getAttributes().get("idCompetizione");

		init ();

	}

	private void init () {
		try {
			competizione = DbManagerFactory.getInstance().getCompetizioneDao().get(idCompetizione);
			List<Societa> tmpSocieta = DbManagerFactory.getInstance().getSocietaDao().list();
			int pos = 0;
			listaSocieta = new SelectItem[tmpSocieta.size()];
			for (Societa soc : tmpSocieta) {
				listaSocieta[pos] = new SelectItem(soc.getId(), soc.getDenominazione());
				pos++;
			}
		} catch (GeCompOrmException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.competizione.caricamento.ko");
		}
	}

}
