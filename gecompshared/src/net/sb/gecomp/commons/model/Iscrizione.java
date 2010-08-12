package net.sb.gecomp.commons.model;

import net.sb.gecomp.commons.utils.Eval;


public class Iscrizione extends GecompModelObject implements Comparable<Iscrizione> {
	
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
	
	private String numeroPettorale;
	public String getNumeroPettorale() {return numeroPettorale;}
	public void setNumeroPettorale(String numeroPettorale) {this.numeroPettorale = numeroPettorale;}
	
	private Boolean competitivo;
	public Boolean getCompetitivo() {return competitivo;}
	public void setCompetitivo(Boolean competitivo) {this.competitivo = competitivo;}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atleta == null) ? 0 : atleta.hashCode());
		result = prime * result
				+ ((competitivo == null) ? 0 : competitivo.hashCode());
		result = prime * result + ((gara == null) ? 0 : gara.hashCode());
		result = prime * result
				+ ((idIscrizione == null) ? 0 : idIscrizione.hashCode());
		result = prime * result
				+ ((numeroPettorale == null) ? 0 : numeroPettorale.hashCode());
		return result;
	}
	
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
		if (competitivo == null) {
			if (other.competitivo != null)
				return false;
		} else if (!competitivo.equals(other.competitivo))
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
	
	
	public int compareTo(Iscrizione other) {
		try {
			if (isTheSameGara(other) && isTheSameCompetizione(other)) {
				if (Eval.equalsIgnoreCase(this.getNumeroPettorale(), other.getNumeroPettorale())) {
					if (Eval.equals(this.getCompetitivo(), other.getCompetitivo())) {
						if (Eval.equals(this.getAtleta().getCognome(), other.getAtleta().getCognome())) {
							if (Eval.equals(this.getAtleta().getNome(), other.getAtleta().getNome())) {
								if (Eval.equals(this.getAtleta().getSesso(), other.getAtleta().getSesso())) {

									//Se ancora non basta proseguire......
									return this.getAtleta().getAnnoNascita().compareTo( other.getAtleta().getAnnoNascita());

								} else {
									return this.getAtleta().getSesso().compareTo( other.getAtleta().getSesso());
								}
							} else {
								return this.getAtleta().getNome().compareTo( other.getAtleta().getNome());
							}
						} else {
							return this.getAtleta().getCognome().compareTo( other.getAtleta().getCognome());	
						}
					} else {
						return this.getCompetitivo().compareTo(other.getCompetitivo());	
					}
				} else {
					if (Eval.isEmpty(this.getNumeroPettorale())) {
						return 1;
					} else if (Eval.isEmpty(other.getNumeroPettorale())) {
						return -1;
					} else {
						return this.getNumeroPettorale().compareTo(other.getNumeroPettorale());	
					}				
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -2;
	}
	private boolean isTheSameGara(Iscrizione altra) {
		return this.getGara().equals(altra.getGara());
    }
    private boolean isTheSameCompetizione(Iscrizione altra) {
    	return this.getGara().getCompetizione().equals(altra.getGara().getCompetizione());
    }
    
}
