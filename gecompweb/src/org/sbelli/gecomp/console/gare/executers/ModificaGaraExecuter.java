package org.sbelli.gecomp.console.gare.executers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.MessageSeverity;

import org.sbelli.gecomp.console.user.GeCompUserSessionHandler;
import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.console.utils.guimessages.GuiMessageHandler;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;

public class ModificaGaraExecuter extends GaraExecuter {

	public String modificaGara () {
		return "modificaGara";
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
			return "null";
		}
		return "null";
	}

	public String selezionaGara () {
		try {
			GeCompUserSessionHandler.getGeCompUserSession().setGara(delegate.get(idGara));
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.gara.selezionata.ko");
		}
		GuiMessageHandler.addGUIMessage(MessageSeverity.info, "message.gara.selezionata.ok", "message.gara.selezionata.ok.descrizione");
		return "null";
	}
	
}
