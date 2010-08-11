package net.sb.gecomp.model;



public class Societa extends GecompModelObject {

	private Long 	id;
	private String 	codiceFidal;
	private String 	denominazione;
	private String	telefonoSede;
	private String 	localitaSede;
	private String 	fax;
	private String 	email;
	private String 	sito;
	
	public Societa() { }
	public Societa(String codiceFidal, String denominazione,
			String telefonoSede, String localitaSede, String fax, String email,
			String sito) {
		super();
		this.codiceFidal = codiceFidal;
		this.denominazione = denominazione;
		this.telefonoSede = telefonoSede;
		this.localitaSede = localitaSede;
		this.fax = fax;
		this.email = email;
		this.sito = sito;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodiceFidal() {
		return codiceFidal;
	}
	public void setCodiceFidal(String codiceFidal) {
		this.codiceFidal = codiceFidal;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getTelefonoSede() {
		return telefonoSede;
	}
	public void setTelefonoSede(String telefonoSede) {
		this.telefonoSede = telefonoSede;
	}
	public String getLocalitaSede() {
		return localitaSede;
	}
	public void setLocalitaSede(String localitaSede) {
		this.localitaSede = localitaSede;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSito() {
		return sito;
	}
	public void setSito(String sito) {
		this.sito = sito;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Societa other = (Societa) obj;
		if (codiceFidal == null) {
			if (other.codiceFidal != null)
				return false;
		} else if (!codiceFidal.equals(other.codiceFidal))
			return false;
		if (denominazione == null) {
			if (other.denominazione != null)
				return false;
		} else if (!denominazione.equals(other.denominazione))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localitaSede == null) {
			if (other.localitaSede != null)
				return false;
		} else if (!localitaSede.equals(other.localitaSede))
			return false;
		if (sito == null) {
			if (other.sito != null)
				return false;
		} else if (!sito.equals(other.sito))
			return false;
		if (telefonoSede == null) {
			if (other.telefonoSede != null)
				return false;
		} else if (!telefonoSede.equals(other.telefonoSede))
			return false;
		return true;
	}
	
	

}
