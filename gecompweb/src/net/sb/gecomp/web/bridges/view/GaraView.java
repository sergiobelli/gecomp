package net.sb.gecomp.web.bridges.view;

import java.util.ArrayList;
import java.util.Date;

import net.sb.gecomp.model.Categoria;
import net.sb.gecomp.model.Competizione;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.model.TipoMisura;
import net.sb.gecomp.utils.Eval;


public class GaraView extends Gara {
	
//	private CompetizioneView competizione;
//	private List<CategoriaView> categorie;
	
	public GaraView() { }
	public GaraView(Date data) {
		super(data);
	}
	
	public GaraView(Competizione competizione, String nome, String descrizione,
			Date data, Float distanza, TipoMisura tipoMisura) {
		super(competizione, nome, descrizione, data, distanza, tipoMisura);
	}

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
