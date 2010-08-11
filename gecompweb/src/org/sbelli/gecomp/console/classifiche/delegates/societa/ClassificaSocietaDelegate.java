package org.sbelli.gecomp.console.classifiche.delegates.societa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.bridges.view.ClassificaSocietaView;
import org.sbelli.gecomp.console.bridges.view.PrestazioneView;
import org.sbelli.gecomp.console.classifiche.delegates.ClassificaDelegate;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Societa;
import org.sbelli.gecomp.orm.model.TipoPrestazione;

public abstract class ClassificaSocietaDelegate extends ClassificaDelegate {
	
	private final GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass());
	
	public abstract ClassificaSocietaView getClassifica(Gara gara);
	
	protected HashMap<Societa,Integer> getClassificaSocietaIscritte(List<PrestazioneView> prestazioni) {
		HashMap<Societa,Integer> classificaSocietaIscritte = new HashMap<Societa, Integer>();
		for (PrestazioneView prestazione : prestazioni) {
			Societa societa = prestazione.getIscrizione().getAtleta().getSocietaAppartenenza();
			if (!TipoPrestazione.NON_PARTECIPATO.equals(prestazione.getTipoPrestazione().getIdTipoPrestazione())) {
				logger.debug("prestazione valida ", prestazione.getTipoPrestazione());
				if (!classificaSocietaIscritte.containsKey(societa)) {
					classificaSocietaIscritte.put(societa, Integer.valueOf(1));
				} else {
					Integer numero = classificaSocietaIscritte.get(societa);
					numero++;
					classificaSocietaIscritte.remove(societa);
					classificaSocietaIscritte.put(societa, numero);
				}
			} else {
				logger.info("prestazione non valida ", "[", prestazione.getIdPrestazione(), ",", prestazione.getTipoPrestazione(), "]");
			}
		}
		return classificaSocietaIscritte;
	}
	
	protected HashMap<Societa,Integer> getClassificaSocietaClassificate(List<PrestazioneView> prestazioni) {
		HashMap<Societa,Integer> classificaSocietaClassificate = new HashMap<Societa, Integer>();
		for (PrestazioneView prestazione : prestazioni) {
			Societa societa = prestazione.getIscrizione().getAtleta().getSocietaAppartenenza();
			if (TipoPrestazione.VALIDA.equals(prestazione.getTipoPrestazione().getIdTipoPrestazione())) {
				logger.debug("prestazione valida ", prestazione.getTipoPrestazione());
				if (!classificaSocietaClassificate.containsKey(societa)) {
					classificaSocietaClassificate.put(societa, Integer.valueOf(1));
				} else {
					Integer numero = classificaSocietaClassificate.get(societa);
					numero++;
					classificaSocietaClassificate.remove(societa);
					classificaSocietaClassificate.put(societa, numero);
				}
			} else {
				logger.info("prestazione non valida ", "[", prestazione.getIdPrestazione(), ",", prestazione.getTipoPrestazione(), "]");
			}
		}
		return classificaSocietaClassificate;
	}
}

class ClassificaSocietaIscritteComparator implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
	
}
