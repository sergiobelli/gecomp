package net.sb.gecomp.web.executers.prestazioni;

import javax.faces.model.SelectItem;

import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.web.delegates.prestazioni.PrestazioneDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class PrestazioneExecuter extends GenericExecuter {

	protected PrestazioneDelegate delegate = new PrestazioneDelegate();
	
	protected Long idPrestazione;
	private Prestazione prestazione;
	public Prestazione getPrestazione() {return prestazione;}
	public void setPrestazione(Prestazione prestazione) {this.prestazione = prestazione;}
	
	private SelectItem[] listaIscrittiItem;
	public SelectItem[] getListaIscrittiItem() {return listaIscrittiItem;}
	public void setListaIscrittiItem(SelectItem[] listaIscrittiItem) {this.listaIscrittiItem = listaIscrittiItem;}
	
	
	public String salva() {
		try {
			logger.info("Saving/Modifing Prestazione...");
			delegate.save(this.getPrestazione());
			logger.info("Saved/Modified Prestazione...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.prestazione.salvataggio.ko");
			return "null";
		}
		return "listaPrestazioni";
	}
	
}
