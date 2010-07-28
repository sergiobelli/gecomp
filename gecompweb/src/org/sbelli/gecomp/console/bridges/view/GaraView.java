package org.sbelli.gecomp.console.bridges.view;

import java.util.ArrayList;

import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;

public class GaraView extends Gara {
	
//	private CompetizioneView competizione;
//	private List<CategoriaView> categorie;
	
	public GaraView() { }
	public GaraView(Gara gara) {
		ViewUtils.copyProperties(this, gara);
		this.setCompetizione(new CompetizioneView(gara.getCompetizione()));
		if (Eval.isNotEmpty(gara.getCategorie())) {
			this.setCategorie(new ArrayList<Categoria>());
			for (Categoria cat : gara.getCategorie()) {
				this.getCategorie().add(new CategoriaView(cat));
			}
		}
	}
	
//	public CompetizioneView getCompetizione() {return competizione;}
//	public void setCompetizione(CompetizioneView competizione) {this.competizione = competizione;}
	
//	public List<CategoriaView> getCategorie() {return categorie;}
//	public void setCategorie(List<CategoriaView> categorie) {this.categorie = categorie;}
	
}
