package net.sb.gecomp.web.executers.prestazioni;

import net.sb.gecomp.model.Atleta;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.model.Iscrizione;
import net.sb.gecomp.model.Prestazione;
import net.sb.gecomp.model.TipoMisura;
import net.sb.gecomp.model.TipoPrestazione;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class InserisciPrestazioneExecuter extends PrestazioneExecuter {
	
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
		logger.info("Sto salvando una nuova prestazione");
		return super.salva();
	}
}


