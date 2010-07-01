package org.sbelli.gecomp.console.bridges.view;

import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneView extends Prestazione {

	private Integer posizione;
	
	public PrestazioneView() { }
	public PrestazioneView(Prestazione prestazione) {
		ViewUtils.copyProperties(this, prestazione);
	}
	public PrestazioneView(Prestazione prestazione, Integer posizione) {
		this(prestazione);
		setPosizione(posizione);
	}

	//getter/setter
	
	public Integer getPosizione() {return posizione;}
	public void setPosizione(Integer posizione) {this.posizione = posizione;}
	
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
