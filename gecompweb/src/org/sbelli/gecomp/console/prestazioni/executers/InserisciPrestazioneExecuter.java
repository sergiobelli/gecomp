package org.sbelli.gecomp.console.prestazioni.executers;

import javax.faces.model.SelectItem;

import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Iscrizione;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.model.TipoMisura;
import org.sbelli.gecomp.orm.model.TipoPrestazione;

public class InserisciPrestazioneExecuter extends PrestazioneExecuter {
	
	private SelectItem[] listaIscrittiItem;
	public SelectItem[] getListaIscrittiItem() {return listaIscrittiItem;}
	public void setListaIscrittiItem(SelectItem[] listaIscrittiItem) {this.listaIscrittiItem = listaIscrittiItem;}
	
	public InserisciPrestazioneExecuter () {
		Gara garaSelezionata = new Gara();
		TipoMisura tipoMisura = new TipoMisura();
		try {
			garaSelezionata = getSelectedGara();
			tipoMisura = garaSelezionata.getTipoMisura();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezione.ko");
		} finally {
			setPrestazione(
					new Prestazione(
							new Iscrizione(new Atleta(), garaSelezionata),
							new TipoPrestazione(),
							tipoMisura,
							null));
			setListaIscrittiItem(getHelper().getListaIscrittiItem(garaSelezionata));
		}
	}
	
	public String salva() {
		try {
			logger.info("Saving new Prestazione...");
			
			delegate.save(this.getPrestazione());

			logger.info("Saved new Prestazione...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.prestazione.salvataggio.ko");
			return "null";
		}

		return "listaPrestazioni";
	}
	
}


