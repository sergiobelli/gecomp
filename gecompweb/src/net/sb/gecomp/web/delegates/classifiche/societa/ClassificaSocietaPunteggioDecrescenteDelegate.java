package net.sb.gecomp.web.delegates.classifiche.societa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.model.Societa;
import net.sb.gecomp.model.TipoPrestazione;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.view.ClassificaSocietaView;
import net.sb.gecomp.web.bridges.view.PrestazioneView;
import net.sb.gecomp.web.delegates.gare.GaraDelegate;
import net.sb.gecomp.web.delegates.prestazioni.PrestazioneDelegate;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ClassificaSocietaPunteggioDecrescenteDelegate extends
		ClassificaSocietaDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private PrestazioneDelegate prestazioneDelegate = new PrestazioneDelegate();
	
	public ClassificaSocietaView getClassifica(Gara gara) {
		ClassificaSocietaView result = new ClassificaSocietaView();
		try {
			List<PrestazioneView> prestazioni = prestazioneDelegate.list(gara);
			
			result.setClassificaSocietaIscritte(getClassificaSocietaIscritte(prestazioni));
			result.setClassificaSocietaClassificate(getClassificaSocietaClassificate(prestazioni));
			result.setClassificaSocietaPunteggio(getClassificaSocietaPunteggio(prestazioni));
			
		} catch (GeCompException e) {
			logger.error(e, "XXXXXXXXXXXXXXXXXXXXXX");
		}
		return result;
	}

	protected HashMap<Societa,Integer> getClassificaSocietaPunteggio(List<PrestazioneView> prestazioni) {
		HashMap<Societa,Integer> classificaSocietaPunti = new HashMap<Societa, Integer>();
		
		List<PrestazioneView> prestazioniValide = new ArrayList<PrestazioneView>();
		for (PrestazioneView prestazione : prestazioni) {
			if (TipoPrestazione.VALIDA.equals(prestazione.getTipoPrestazione().getIdTipoPrestazione())) {
				prestazioniValide.add(prestazione);
			}
		}
		
		int punteggio = prestazioniValide.size();
		for (PrestazioneView prestazioneValida : prestazioniValide) {
			prestazioneValida.setPunteggio(punteggio--);
			Societa societa = prestazioneValida.getIscrizione().getAtleta().getSocietaAppartenenza();
			if (TipoPrestazione.VALIDA.equals(prestazioneValida.getTipoPrestazione().getIdTipoPrestazione())) {
				if (!classificaSocietaPunti.containsKey(societa)) {
					classificaSocietaPunti.put(societa, prestazioneValida.getPunteggio());
				} else {
					Integer punteggioTmp = classificaSocietaPunti.get(societa);
					punteggioTmp+=prestazioneValida.getPunteggio();
					classificaSocietaPunti.remove(societa);
					classificaSocietaPunti.put(societa, punteggioTmp);
				}
			} else {
				logger.info("prestazione non valida ", "[", prestazioneValida.getIdPrestazione(), ",", prestazioneValida.getTipoPrestazione(), "]");
			}
		}
		return classificaSocietaPunti;
	}

	public static final void main(String[] args) throws GeCompException {
		ClassificaSocietaPunteggioDecrescenteDelegate c = new ClassificaSocietaPunteggioDecrescenteDelegate();
		ClassificaSocietaView classifica = c.getClassifica(new GaraDelegate().get(18l));
		System.out.print(ToStringBuilder.reflectionToString(classifica));
	}
}
