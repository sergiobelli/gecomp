package net.sb.gecomp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author sbelli
 */
public class Categoria extends GecompModelObject implements Comparable {

	private Long idCategoria;
	public Long getIdCategoria() {return idCategoria;}
	public void setIdCategoria(Long idCategoria) {	this.idCategoria = idCategoria;}

	private String nomeCategoria;
	public String getNomeCategoria() {return nomeCategoria;}
	public void setNomeCategoria(String nomeCategoria) {this.nomeCategoria = nomeCategoria;}

	private String sesso;
	public String getSesso() {return sesso;}
	public void setSesso(String sesso) {this.sesso = sesso;}

	private String annoPartenza;
	public String getAnnoPartenza() {return annoPartenza;}
	public void setAnnoPartenza(String annoPartenza) {this.annoPartenza = annoPartenza;}

	private String annoFine;
	public String getAnnoFine() {return annoFine;}
	public void setAnnoFine(String annoFine) {this.annoFine = annoFine;}

	private Date inizio;
	public Date getInizio() {return inizio;}
	public void setInizio(Date inizio) {this.inizio = inizio;}
	
	private Date fine;
	public Date getFine() {return fine;}
	public void setFine(Date fine) {this.fine = fine;}
	
	public List<Integer> getAnniAppartenenza() {
		Integer annoPartenza = Integer.valueOf(getAnnoPartenza());
		Integer annoFine = Integer.valueOf(getAnnoFine());
		int offset = annoFine - annoPartenza;
		
		List<Integer> anni = new ArrayList<Integer>();
		for (int i = 0; i <= offset; i++) {
			anni.add(annoPartenza + i);
		}
		return anni;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		
		if (annoFine == null) {
			if (other.annoFine != null)
				return false;
		} else if (!annoFine.equals(other.annoFine))
			return false;
		
		if (annoPartenza == null) {
			if (other.annoPartenza != null)
				return false;
		} else if (!annoPartenza.equals(other.annoPartenza))
			return false;
		
		if (fine == null) {
			if (other.fine != null)
				return false;
		} else if (!fine.equals(other.fine))
			return false;
		
		if (inizio == null) {
			if (other.inizio != null)
				return false;
		} else if (!inizio.equals(other.inizio))
			return false;

		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		
		return true;
	}
	
	public int compareTo(Object o) {
		if (!(o instanceof Categoria)) {
			return 0;
		} else {
			Categoria cat = (Categoria)o;
			if (this.getSesso().equals(cat.getSesso())) {
				if (this.getNomeCategoria().equals(cat.getNomeCategoria())) {
					return this.getIdCategoria().compareTo(cat.getIdCategoria());
				} else {
					return this.getNomeCategoria().compareTo(cat.getNomeCategoria());
				}
			} else {
				return this.getSesso().compareTo(cat.getSesso());
			}
		}
	}

}
