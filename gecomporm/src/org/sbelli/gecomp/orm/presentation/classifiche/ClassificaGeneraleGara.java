package org.sbelli.gecomp.orm.presentation.classifiche;

import java.util.List;

import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;

public class ClassificaGeneraleGara implements IClassifica {

	private static final long serialVersionUID = 6957995475811788051L;

	public ClassificaGeneraleGara (Gara gara, List<Prestazione> classificaGara) {
		setGara(gara);
		setClassificaGeneraleGara(classificaGara);
	}
	
	private Gara gara;
	public Gara getGara() { return gara; }
	public void setGara(Gara gara) { this.gara = gara; }
	
	private List<Prestazione> classificaGeneraleGara;
	public List<Prestazione> getClassificaGeneraleGara() { return classificaGeneraleGara; }
	public void setClassificaGeneraleGara(List<Prestazione> classifica) { classificaGeneraleGara = classifica; }

}
