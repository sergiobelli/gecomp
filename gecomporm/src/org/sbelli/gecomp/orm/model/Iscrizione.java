package org.sbelli.gecomp.orm.model;


public class Iscrizione extends GecompModelObject {
	
	private static final long serialVersionUID = 2390550056411675120L;
	
	public Iscrizione() {}
	public Iscrizione(Atleta atleta, Gara gara) {
		setAtleta(atleta);
		setGara(gara);
	}
	
	private Long idIscrizione;
	public Long getIdIscrizione() { return idIscrizione; }
	public void setIdIscrizione(Long idIscrizione) { this.idIscrizione = idIscrizione; }
	
	private Gara gara;
	public Gara getGara() { return gara; }
	public void setGara(Gara gara) { this.gara = gara; }
	
	private Atleta atleta;
	public Atleta getAtleta() { return atleta; }
	public void setAtleta(Atleta atleta) { this.atleta = atleta; }
	
	private Long numeroPettorale;
	public Long getNumeroPettorale() {return numeroPettorale;}
	public void setNumeroPettorale(Long numeroPettorale) {this.numeroPettorale = numeroPettorale;}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Iscrizione other = (Iscrizione) obj;
		if (atleta == null) {
			if (other.atleta != null)
				return false;
		} else if (!atleta.equals(other.atleta))
			return false;
		if (gara == null) {
			if (other.gara != null)
				return false;
		} else if (!gara.equals(other.gara))
			return false;
		if (idIscrizione == null) {
			if (other.idIscrizione != null)
				return false;
		} else if (!idIscrizione.equals(other.idIscrizione))
			return false;
		if (numeroPettorale == null) {
			if (other.numeroPettorale != null)
				return false;
		} else if (!numeroPettorale.equals(other.numeroPettorale))
			return false;
		return true;
	}
	
	
	
	
}
