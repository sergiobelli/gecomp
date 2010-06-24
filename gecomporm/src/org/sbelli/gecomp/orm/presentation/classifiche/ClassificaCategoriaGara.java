package org.sbelli.gecomp.orm.presentation.classifiche;

import java.util.List;

import org.sbelli.gecomp.orm.dao.ClassificaManager;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;

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
		classificaGara = ClassificaManager.ordina(classifica);
	}	

}
