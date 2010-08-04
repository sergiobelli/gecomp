package org.sbelli.gecomp.console.gare.executers;

import java.util.List;

import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.console.bridges.view.GaraView;
import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.gare.delegates.GaraDelegate;

public abstract class GaraExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	protected GaraDelegate delegate = new GaraDelegate();
	
	protected Long idGara;
	protected GaraView gara;
	public GaraView getGara() { return gara; }
	public void setGara(GaraView gara) { this.gara = gara; }

	private List<Long> categorie;
	public List<Long> getCategorie() {return categorie;}
	public void setCategorie(List<Long> categorie) {this.categorie = categorie;}
	
	public String salva() {
		try {
			logger.info("Insert/Updating Gara...");
			delegate.save(getGara(), getCategorie());
			logger.info("Insert/Updating new Gara...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.gara.modifica.salvataggio.ko");
			return GeCompOutcomes.NULL;
		}
		return GeCompOutcomes.LISTA_GARE;
	}
	
}
