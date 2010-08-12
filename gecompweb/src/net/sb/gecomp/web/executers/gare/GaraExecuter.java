package net.sb.gecomp.web.executers.gare;

import java.util.List;

import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.web.delegates.gare.GaraDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public abstract class GaraExecuter extends GenericExecuter {

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
			return GeCompOutcomes.FAIL;
		}
		return GeCompOutcomes.LISTA_GARE;
	}
	
}
