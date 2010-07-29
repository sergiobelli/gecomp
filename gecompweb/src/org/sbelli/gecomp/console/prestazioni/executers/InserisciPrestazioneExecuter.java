package org.sbelli.gecomp.console.prestazioni.executers;

import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Iscrizione;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.model.TipoMisura;
import org.sbelli.gecomp.orm.model.TipoPrestazione;

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


