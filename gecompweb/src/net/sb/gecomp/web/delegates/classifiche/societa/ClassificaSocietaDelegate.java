package net.sb.gecomp.web.delegates.classifiche.societa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.sb.gecomp.model.Gara;
import net.sb.gecomp.model.Societa;
import net.sb.gecomp.model.TipoPrestazione;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.view.ClassificaSocietaView;
import net.sb.gecomp.web.bridges.view.PrestazioneView;
import net.sb.gecomp.web.delegates.classifiche.ClassificaDelegate;


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
