package org.sbelli.gecomp.console.bridges.view;

import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneView extends Prestazione {

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
		result.setNomeCategoria("n.d.");
		Integer annoNascita = Integer.valueOf(this.getIscrizione().getAtleta().getAnnoNascita());
		if (Eval.isNotEmpty(this.getIscrizione().getGara().getCategorie())) {
			for (Categoria categoria : this.getIscrizione().getGara().getCategorie()) {
				if (categoria.getAnniAppartenenza().contains(annoNascita)
						&& categoria.getSesso().equals(this.getIscrizione().getAtleta().getSesso())) {
					result = new CategoriaView(categoria);
					break;
				}
			}
		}
		return result;
	}
	//getter/setter
	
	
}
