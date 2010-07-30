package org.sbelli.gecomp.console.bridges.view;

import java.util.HashMap;
import java.util.List;

public class ClassificaGaraView extends ClassificaView {

	private GaraView gara;
	public GaraView getGara() { return gara; }
	public void setGara(GaraView gara) { this.gara = gara; }
	
	private List<CategoriaView> categorie;
	public List<CategoriaView> getCategorie() { return categorie; }
	public void setCategorie(List<CategoriaView> categorie) { this.categorie = categorie; }

	private List<IscrizioneView> iscritti;
	public List<IscrizioneView> getIscritti() {return iscritti;}
	public void setIscritti(List<IscrizioneView> iscritti) {this.iscritti = iscritti;}

	private List<PrestazioneView> classificaGenerale;
	public List<PrestazioneView> getClassificaGenerale() { return classificaGenerale; }
	public void setClassificaGenerale(List<PrestazioneView> classifica) { classificaGenerale = classifica; }

	private HashMap<CategoriaView, List<PrestazioneView>> classificheCategorie;
	public HashMap<CategoriaView, List<PrestazioneView>> getClassificheCategorie() {return classificheCategorie;}
	public void setClassificheCategorie(HashMap<CategoriaView, List<PrestazioneView>> classificheCategorie) {this.classificheCategorie = classificheCategorie;}
		
	private ClassificaSocietaView classificaSocieta;
	public ClassificaSocietaView getClassificaSocieta() {return classificaSocieta;}
	public void setClassificaSocieta(ClassificaSocietaView classificaSocieta) {this.classificaSocieta = classificaSocieta;}
	
}
