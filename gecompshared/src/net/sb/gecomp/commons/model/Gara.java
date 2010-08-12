package net.sb.gecomp.commons.model;

import java.util.Date;
import java.util.List;


public class Gara extends GecompModelObject {

	private static final long serialVersionUID = -6744287453361045725L;

	private Long idGara;
	private Competizione competizione;
	private String nome;
	private String descrizione;
	private Date data;
	private Float distanza;
	private TipoMisura tipoMisura;
	private List<Categoria> categorie;
	private Integer numeroAssolutiMaschile;
	private Integer numeroAssolutiFemminile;
	
	public Gara() {}
	public Gara(Date data) {
		setData(data);
	}
	
	public Gara(Competizione competizione, String nome, String descrizione,
			Date data, Float distanza, TipoMisura tipoMisura) {
		super();
		this.competizione = competizione;
		this.nome = nome;
		this.descrizione = descrizione;
		this.data = data;
		this.distanza = distanza;
		this.tipoMisura = tipoMisura;
	}
	public Long getIdGara() {
		return idGara;
	}
	public void setIdGara(Long idGara) {
		this.idGara = idGara;
	}
	public Competizione getCompetizione() {
		return competizione;
	}
	public void setCompetizione(Competizione competizione) {
		this.competizione = competizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Float getDistanza() {
		return distanza;
	}
	public void setDistanza(Float distanza) {
		this.distanza = distanza;
	}
	
	public TipoMisura getTipoMisura() {return tipoMisura;}
	public void setTipoMisura(TipoMisura tipoMisura) {this.tipoMisura = tipoMisura;}
	
	
	public List<Categoria> getCategorie() {return categorie;}
	public void setCategorie(List<Categoria> categorie) {this.categorie = categorie;}
	
	
	public Integer getNumeroAssolutiMaschile() {
		return numeroAssolutiMaschile;
	}
	public void setNumeroAssolutiMaschile(Integer numeroAssolutiMaschile) {
		this.numeroAssolutiMaschile = numeroAssolutiMaschile;
	}
	public Integer getNumeroAssolutiFemminile() {
		return numeroAssolutiFemminile;
	}
	public void setNumeroAssolutiFemminile(Integer numeroAssolutiFemminile) {
		this.numeroAssolutiFemminile = numeroAssolutiFemminile;
	}
	
	public Integer getNumeroAssoluti(Categoria categoria) {
		if (categoria.getSesso().equals("M")) {
			return this.getNumeroAssolutiMaschile();
		} else {
			return this.getNumeroAssolutiFemminile();
		}
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gara other = (Gara) obj;
		if (competizione == null) {
			if (other.competizione != null)
				return false;
		} else if (!competizione.equals(other.competizione))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (distanza == null) {
			if (other.distanza != null)
				return false;
		} else if (!distanza.equals(other.distanza))
			return false;
		if (idGara == null) {
			if (other.idGara != null)
				return false;
		} else if (!idGara.equals(other.idGara))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoMisura == null) {
			if (other.tipoMisura != null)
				return false;
		} else if (!tipoMisura.equals(other.tipoMisura))
			return false;
		return true;
	}
	
}
