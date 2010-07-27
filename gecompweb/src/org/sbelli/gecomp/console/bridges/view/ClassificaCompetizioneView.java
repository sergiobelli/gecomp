package org.sbelli.gecomp.console.bridges.view;

import java.util.List;

public class ClassificaCompetizioneView {

	private CompetizioneView competizione;
	public CompetizioneView getCompetizione() {return competizione;}
	public void setCompetizione(CompetizioneView competizione) {this.competizione = competizione;}

	private List<CategoriaView> categorie;
	public List<CategoriaView> getCategorie() {return categorie;}
	public void setCategorie(List<CategoriaView> categorie) {this.categorie = categorie;}
		
	private List<PrestazioneView> classificaGenerale;
	public List<PrestazioneView> getClassificaGenerale() {return classificaGenerale;}
	public void setClassificaGenerale(List<PrestazioneView> classificaGenerale) {this.classificaGenerale = classificaGenerale;}
	
}
