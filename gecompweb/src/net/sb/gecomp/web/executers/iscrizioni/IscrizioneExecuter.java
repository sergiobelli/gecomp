package net.sb.gecomp.web.executers.iscrizioni;

import java.util.List;

import javax.faces.model.SelectItem;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.IscrizioneView;
import net.sb.gecomp.web.delegates.iscrizioni.IscrizioneDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public abstract class IscrizioneExecuter extends GenericExecuter {

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
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
			return GeCompOutcomes.FAIL;
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.modifica.salvataggio.ko.descrizione");
			return GeCompOutcomes.FAIL;
		}
		return GeCompOutcomes.LISTA_ISCRIZIONI;
	}
}
