package net.sb.gecomp.web.executers.gare;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.commons.utils.exceptions.MessageSeverity;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.user.GeCompUserSessionHandler;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;
import net.sb.gecomp.web.utils.guimessages.GuiMessageHandler;


public class ModificaGaraExecuter extends GaraExecuter {

	public String modificaGara () {
		return GeCompOutcomes.MODIFICA_GARA;
	}

	public void load (ActionEvent event) {
		idGara = (Long) event.getComponent().getAttributes().get("idGara");
		init ();

	}

	private void init () {
		try {
			setGara(delegate.get(idGara));
			List<Long> categorie = new ArrayList<Long>();
			if (Eval.isNotEmpty(getGara().getCategorie())) {
				for (Categoria cat : getGara().getCategorie()) {
					categorie.add(cat.getIdCategoria());
				}
			}
			setCategorie(categorie);
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.competizione.caricamento.ko");
		}
	}

	public String salva() {
		logger.info("Modifica di una gara in corso...");
		return super.salva();
	}

	public String elimina () {
		try {
			logger.info("Deleting Gara...");
			delegate.delete(getGara());
			logger.info("Deleted Gara...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.gara.eliminazione.ko");
			return GeCompOutcomes.FAIL;
		}
		return GeCompOutcomes.FAIL;
	}

	public String selezionaGara () {
		try {
			GeCompUserSessionHandler.getGeCompUserSession().setGara(delegate.get(idGara));
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.gara.selezionata.ko");
		}
		GuiMessageHandler.addGUIMessage(MessageSeverity.info, "message.gara.selezionata.ok", "message.gara.selezionata.ok.descrizione");
		return GeCompOutcomes.NULL;
	}
	
}
