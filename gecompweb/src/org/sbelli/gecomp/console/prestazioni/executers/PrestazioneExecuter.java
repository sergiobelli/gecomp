package org.sbelli.gecomp.console.prestazioni.executers;

import javax.faces.model.SelectItem;

import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.prestazioni.delegates.PrestazioneDelegate;
import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
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
