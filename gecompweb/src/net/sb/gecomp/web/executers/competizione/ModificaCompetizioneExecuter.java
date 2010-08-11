package net.sb.gecomp.web.executers.competizione;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.exceptions.MessageSeverity;
import net.sb.gecomp.web.bridges.view.CompetizioneView;
import net.sb.gecomp.web.bridges.view.SocietaView;
import net.sb.gecomp.web.controllers.competizione.CompetizioneController;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.user.GeCompUserSessionHandler;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;
import net.sb.gecomp.web.utils.guimessages.GuiMessageHandler;


public class ModificaCompetizioneExecuter extends CompetizioneExecuter {

	public String modifica () {
		logger.info("Modifica di una competizione...");
		return update ();

	}

	private String update () {
		String result = "listaCompetizioni";
		try {
			logger.info("Modifing Competizione...");

			final CompetizioneView tmpCompetizione = delegate.retrieve(getCompetizione());
			logger.debug("Customized Competizione = " + tmpCompetizione);

			CompetizioneController competizioneController = new CompetizioneController(); 
			competizioneController.checks(tmpCompetizione);

			delegate.save(tmpCompetizione);

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
			GeCompUserSessionHandler.getGeCompUserSession().setCompetizione(delegate.retrieve(getCompetizione()));
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

			CompetizioneView comp = delegate.get(idCompetizione);
			GeCompUserSessionHandler.getGeCompUserSession().setCompetizione(comp);
			GeCompUserSessionHandler.getGeCompUserSession().setGara(null);
			
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezionata.ko");
		}

		GuiMessageHandler.addGUIMessage(MessageSeverity.info, "message.competizione.selezionata.ok", "message.competizione.selezionata.ok.descrizione");
		return GeCompOutcomes.NULL;

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
			competizione = delegate.get(idCompetizione);
			List<SocietaView> tmpSocieta = socDelegate.list();
			int pos = 0;
			listaSocieta = new SelectItem[tmpSocieta.size()];
			for (SocietaView soc : tmpSocieta) {
				listaSocieta[pos] = new SelectItem(soc.getId(), soc.getDenominazione());
				pos++;
			}
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.competizione.caricamento.ko");
		}
	}

}
