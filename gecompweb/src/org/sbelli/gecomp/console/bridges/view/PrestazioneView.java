package org.sbelli.gecomp.console.bridges.view;

import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneView extends Prestazione {

	private Integer posizione;
	private IscrizioneView iscrizione;
	
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
	public IscrizioneView getIscrizione() {return iscrizione;}
	public void setIscrizione(IscrizioneView iscrizione) {this.iscrizione = iscrizione;}
	
	public CategoriaView getCategoria() {
		CategoriaView result = new CategoriaView();
		result.setNomeCategoria("n.d.");
		String annoNascita = this.getIscrizione().getAtleta().getAnnoNascita();
		if (Eval.isNotEmpty(this.getIscrizione().getGara().getCategorie())) {
			for (Categoria categoria : this.getIscrizione().getGara().getCategorie()) {
				if (categoria.getAnniAppartenenza().contains(annoNascita)) {
					result = new CategoriaView(categoria);
				}
			}
		}
		return result;
	}
	//getter/setter
	
	
}
