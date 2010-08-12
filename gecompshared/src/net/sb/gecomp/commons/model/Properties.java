package net.sb.gecomp.commons.model;

import net.sb.gecomp.commons.utils.Eval;

public class Properties extends GecompModelObject {

	public static final String SESSION_OFFSET = "gecomp.session.offset";
	
	private Long id;
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	private String chiave;
	public String getChiave() {return chiave;}
	public void setChiave(String chiave) {this.chiave = chiave;}
	
	private String valore;
	public String getValore() {return valore;}
	public void setValore(String valore) {this.valore = valore;}
	
	public boolean equals(Object obj) {
		if (Eval.isNull(obj)) { return false; }
		if (!(obj instanceof Properties)) { return false; }
		
		Properties tmpProperty = (Properties) obj;
		if (getId() != tmpProperty.getId()) { return false; }
		if (!getChiave().equals(tmpProperty.getChiave())) { return false; }
		if (!getValore().equals(tmpProperty.getValore())) { return false; }
		
		return true;
	}
}
