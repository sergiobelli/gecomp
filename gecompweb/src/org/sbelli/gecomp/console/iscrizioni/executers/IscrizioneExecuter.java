package org.sbelli.gecomp.console.iscrizioni.executers;

import java.util.List;

import javax.faces.model.SelectItem;

import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.iscrizioni.delegates.IscrizioneDelegate;
import org.sbelli.gecomp.console.menu.GeCompOutcomes;
import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Iscrizione;

public abstract class IscrizioneExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	protected IscrizioneDelegate delegate = new IscrizioneDelegate();
	
	protected Long idIscrizione;
	
	protected Iscrizione iscrizione;
	public Iscrizione getIscrizione() { return iscrizione; }
	public void setIscrizione(Iscrizione iscrizione) { this.iscrizione = iscrizione; }
	
	private List<Iscrizione> iscrizioni;
	public List<Iscrizione> getIscrizioni() {return iscrizioni;}
	public void setIscrizioni(List<Iscrizione> iscrizioni) {this.iscrizioni = iscrizioni;}

	private SelectItem[] listaGareItem;
	public SelectItem[] getListaGareItem() {return listaGareItem;}
	public void setListaGareItem(SelectItem[] listaGare) {this.listaGareItem = listaGare;}

	protected Iscrizione retrieve() throws GeCompOrmException {
		Iscrizione tmpIscrizione = getIscrizione();
		tmpIscrizione.setAtleta(DbManagerFactory.getInstance().getAtletaDao().get(tmpIscrizione.getAtleta().getIdAtleta()));
		return tmpIscrizione;
	}
	
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
