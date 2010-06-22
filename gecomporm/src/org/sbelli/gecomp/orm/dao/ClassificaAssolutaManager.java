package org.sbelli.gecomp.orm.dao;

import java.util.ArrayList;
import java.util.List;

import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.presentation.classifiche.PrestazioneInCompetizione;

public class ClassificaAssolutaManager {
	
	/**
	 * 
	 * @param gara
	 * @param prestazioni
	 * @return
	 */
	public List<Prestazione> getClassificaAssoluta(Gara gara, List<Prestazione> prestazioni) {
		List<Prestazione> prestazioniGara = new ArrayList<Prestazione>();
		for (Prestazione p : prestazioni) {
			if (p.getIscrizione().getGara().equals(gara)) {
				prestazioniGara.add(p);
			}
		}
//		return ordina(prestazioniGara);
		return prestazioniGara;
	}
	
	/**
	 * 
	 * @param competizione
	 * @param prestazioni
	 * @return
	 */
	public List<PrestazioneInCompetizione> getClassificaAssoluta(List<Atleta> atleti, Competizione competizione, List<Prestazione> prestazioni) {
		
		List<PrestazioneInCompetizione> prestazioniAssolute = new ArrayList<PrestazioneInCompetizione>();
		
		for (Atleta atleta : atleti) {
			PrestazioneInCompetizione prestazioneAtleta = new PrestazioneInCompetizione();
			prestazioneAtleta.setAtleta(atleta);
			prestazioneAtleta.setCompetizione(competizione);
			
			List<Gara> gareSostenute = new ArrayList<Gara>();
			for (Prestazione ogniPrestazione : prestazioni) {
				if (ogniPrestazione.getIscrizione().getAtleta().equals(atleta)) {
					
					long valoreMisura = prestazioneAtleta.getValoreMisuraTotale();
					prestazioneAtleta.setValoreMisuraTotale(valoreMisura + ogniPrestazione.getValoreMisura());
					
					if (ogniPrestazione.getValoreMisura() == 0) {
						prestazioneAtleta.setRitirato(true);
					} else {
						gareSostenute.add(ogniPrestazione.getIscrizione().getGara());
					}
				}
				
				
				
			}
			prestazioneAtleta.setGareSostenute(gareSostenute);
			prestazioneAtleta.setNote("");
			prestazioneAtleta.setSqualificato(false);

			
			prestazioniAssolute.add(prestazioneAtleta);
		}
		
//		return ordinaCompetizione(prestazioniAssolute);
		return prestazioniAssolute;
	}
}
