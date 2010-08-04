package org.sbelli.gecomp.console.iscrizioni.executers;

import java.util.List;

import javax.faces.model.SelectItem;

import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.console.bridges.view.IscrizioneView;
import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.iscrizioni.delegates.IscrizioneDelegate;

public abstract class IscrizioneExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	protected IscrizioneDelegate delegate = new IscrizioneDelegate();

	protected Long idIscrizione;
	
	protected IscrizioneView iscrizione;
	public IscrizioneView getIscrizione() { return iscrizione; }
	public void setIscrizione(IscrizioneView iscrizione) { this.iscrizione = iscrizione; }
	
	private List<IscrizioneView> iscrizioni;
	public List<IscrizioneView> getIscrizioni() {return iscrizioni;}
	public void setIscrizioni(List<IscrizioneView> iscrizioni) {this.iscrizioni = iscrizioni;}

	private SelectItem[] listaGareItem;
	public SelectItem[] getListaGareItem() {return listaGareItem;}
	public void setListaGareItem(SelectItem[] listaGare) {this.listaGareItem = listaGare;}

	public String salva() {
		try {
			logger.info("Insert/Updating iscrizione...");
			delegate.save(getIscrizione());
			logger.info("Insert/Updating new iscrizione...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.modifica.salvataggio.ko.descrizione");
			return GeCompOutcomes.NULL;
		}
		return GeCompOutcomes.LISTA_ISCRIZIONI;
	}
}
