package net.sb.gecomp.model;

import java.util.Date;


public class Competizione extends GecompModelObject {

    private Long idCompetizione;
    private Date dataInizio;
    private Date dataFine;
    private String nome;
    private String descrizione;
    private Societa societaOrganizzatrice;
	
    public Date getDataFine() {
		return dataFine;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public Long getIdCompetizione() {
		return idCompetizione;
	}
	public String getNome() {
		return nome;
	}
	public Societa getSocietaOrganizzatrice() {
		return societaOrganizzatrice;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public void setIdCompetizione(Long idCompetizione) {
		this.idCompetizione = idCompetizione;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSocietaOrganizzatrice(Societa societaOrganizzatrice) {
		this.societaOrganizzatrice = societaOrganizzatrice;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competizione other = (Competizione) obj;
		if (dataFine == null) {
			if (other.dataFine != null)
				return false;
		} else if (!dataFine.equals(other.dataFine))
			return false;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (idCompetizione == null) {
			if (other.idCompetizione != null)
				return false;
		} else if (!idCompetizione.equals(other.idCompetizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (societaOrganizzatrice == null) {
			if (other.societaOrganizzatrice != null)
				return false;
		} else if (!societaOrganizzatrice.equals(other.societaOrganizzatrice))
			return false;
		return true;
	}
	
	
}
