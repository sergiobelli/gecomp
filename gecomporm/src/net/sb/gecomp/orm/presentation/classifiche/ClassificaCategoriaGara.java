package net.sb.gecomp.orm.presentation.classifiche;

import java.util.List;

import net.sb.gecomp.orm.presentation.classifiche.IClassifica;

import net.sb.gecomp.model.Categoria;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.model.Prestazione;
import net.sb.gecomp.orm.dao.ClassificaCompetizioneManager;


public class ClassificaCategoriaGara implements IClassifica {

	private static final long serialVersionUID = 6957995475811788051L;

	public ClassificaCategoriaGara (Gara gara, Categoria categoria, List<Prestazione> classificaGara) {
		setGara(gara);
		setCategoria(categoria);
		setClassificaGara(classificaGara);
	}
	
	private Categoria categoria;
	public Categoria getCategoria() { return categoria; }
	public void setCategoria(Categoria categoria) { this.categoria = categoria; }	
	
	private Gara gara;
	public Gara getGara() { return gara; }
	public void setGara(Gara gara) { this.gara = gara; }
	
	private List<Prestazione> classificaGara;
	public List<Prestazione> getClassificaGara() { return classificaGara; }
	public void setClassificaGara(List<Prestazione> classifica) {
		classificaGara = ClassificaCompetizioneManager.ordina(classifica);
	}	

}
