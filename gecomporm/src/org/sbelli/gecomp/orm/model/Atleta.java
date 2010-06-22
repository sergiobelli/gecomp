package org.sbelli.gecomp.orm.model;


public class Atleta extends GecompModelObject {

	private static final long serialVersionUID = 6931924606164868803L;
	private Long idAtleta;
	private String cognome;
	private String nome;
	private String sesso;
	private String annoNascita;
	private Societa societaAppartenenza;
	
	public Atleta() {
		this(new Societa());
	}
	public Atleta(Societa societaAppartenenza) {
		setSocietaAppartenenza(societaAppartenenza);
	}
	
	public Long getIdAtleta() {return idAtleta;}
	public void setIdAtleta(Long idAtleta) {this.idAtleta = idAtleta;}

	public String getCognome() {return cognome;}
	public void setCognome(String cognome) {this.cognome = cognome;}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getSesso() {return sesso;}
	public void setSesso(String sesso) {this.sesso = sesso;}

	public String getAnnoNascita() {return annoNascita;}
	public void setAnnoNascita(String annoNascita) {this.annoNascita = annoNascita;}

	public Societa getSocietaAppartenenza() {return societaAppartenenza;}
	public void setSocietaAppartenenza(Societa societaAppartenenza) {this.societaAppartenenza = societaAppartenenza;}

	public String getNominativo() {
		return this.getCognome() + " " + this.getNome();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		if (annoNascita == null) {
			if (other.annoNascita != null)
				return false;
		} else if (!annoNascita.equals(other.annoNascita))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (idAtleta == null) {
			if (other.idAtleta != null)
				return false;
		} else if (!idAtleta.equals(other.idAtleta))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		if (societaAppartenenza == null) {
			if (other.societaAppartenenza != null)
				return false;
		} else if (!societaAppartenenza.equals(other.societaAppartenenza))
			return false;
		return true;
	}
	
	public String toReportString() {
		StringBuffer buf = new StringBuffer();
		

		buf.append(getCognome()).append(" ").append(getNome()).append("\n");
		buf.append(getSocietaAppartenenza());
				
		return buf.toString();
	}
}
