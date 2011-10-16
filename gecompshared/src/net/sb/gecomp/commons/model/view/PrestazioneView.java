package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.utils.Eval;

import org.apache.log4j.Logger;


public class PrestazioneView extends Prestazione {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private Integer posizione;
	private Integer punteggio;
	
	public PrestazioneView() { }
	public PrestazioneView(Prestazione prestazione) {
		ViewUtils.copyProperties(this, prestazione);
	}
	public PrestazioneView(Prestazione prestazione, Integer posizione) {
		this(prestazione);
		setPosizione(posizione);
	}
	public PrestazioneView(Prestazione prestazione, Integer posizione, Integer punteggio) {
		this(prestazione);
		setPosizione(posizione);
		setPunteggio(punteggio);
	}
	
	//getter/setter
	public Integer getPosizione() {return posizione;}
	public void setPosizione(Integer posizione) {this.posizione = posizione;}
	
	
	public Integer getPunteggio() {return punteggio;}
	public void setPunteggio(Integer punteggio) {this.punteggio = punteggio;}
	
	public CategoriaView getCategoria() {
		CategoriaView result = new CategoriaView();
		try {		
			result.setNomeCategoria("n.d.");
			
			logger.debug("prestazione = " + this);
			logger.debug("prestazione.iscrizione = " + this.getIscrizione());
			logger.debug("prestazione.iscrizione.atleta = " + this.getIscrizione().getAtleta());
			logger.debug("prestazione.iscrizione.atleta.annoNascita = " + this.getIscrizione().getAtleta().getAnnoNascita());
			
			Integer annoNascita = Integer.valueOf(this.getIscrizione().getAtleta().getAnnoNascita());
			logger.debug("annoNascita = " + annoNascita);
			
			if (Eval.isNotEmpty(this.getIscrizione().getGara().getCategorie())) {
				for (Categoria categoria : this.getIscrizione().getGara().getCategorie()) {
					if (categoria.getAnniAppartenenza().contains(annoNascita)
							&& categoria.getSesso().equals(this.getIscrizione().getAtleta().getSesso())) {
						result = new CategoriaView(categoria);
						break;
					}
				}
			}
		} catch (Exception ex) {
			logger.error("Errore nel reperimento della categoria per la seguente prestazione " + this, ex);
		}
		
		return result;
	}
	//getter/setter
	
	
}
