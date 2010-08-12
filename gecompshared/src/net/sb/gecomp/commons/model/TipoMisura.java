package net.sb.gecomp.commons.model;

import net.sb.gecomp.commons.utils.Eval;

import org.apache.log4j.Logger;

public class TipoMisura extends GecompModelObject {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	public static final Long TIPO_MISURA_TEMPO 			= 1l;
	public static final Long TIPO_MISURA_LANCIO 		= 2l;
	public static final Long TIPO_MISURA_SALTO 			= 3l;
	public static final Long TIPO_MISURA_POSIZIONE 		= 4l;
	
	public TipoMisura(){}
	public TipoMisura(String descrizione, String unitaMisura, Integer modalitaComparazione) { 
		setDescrizione(descrizione);
		setUnitaMisura(unitaMisura);
		setModalitaComparazione(modalitaComparazione);
	}
	
	private Long idTipoMisura;
	public Long getIdTipoMisura() {return idTipoMisura;}
	public void setIdTipoMisura(Long idTipoMisura) {this.idTipoMisura = idTipoMisura;}

	private String descrizione;
	public String getDescrizione() {return descrizione;}
	public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

	private String unitaMisura;
	public String getUnitaMisura() {return unitaMisura;}
	public void setUnitaMisura(String unitaMisura) {this.unitaMisura = unitaMisura;}

	public static Integer MISURAZIONE_ASCENDENTE 	= 0;
	public static Integer MISURAZIONE_DISCENDENTE 	= 1;
	private Integer modalitaComparazione;
	public Integer getModalitaComparazione() {return modalitaComparazione;}
	public void setModalitaComparazione(Integer modalitaComparazione) {this.modalitaComparazione = modalitaComparazione;}
	
	public String getValoreMisuraFormatted(Long valoreMisura) {
		logger.info("Valore misura da formattare = " + valoreMisura);
		if (Eval.isNotNull(valoreMisura)) {
			return valoreMisura.toString();
		} else {
			return "n.d.";
		}
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoMisura other = (TipoMisura) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (idTipoMisura == null) {
			if (other.idTipoMisura != null)
				return false;
		} else if (!idTipoMisura.equals(other.idTipoMisura))
			return false;
		if (modalitaComparazione == null) {
			if (other.modalitaComparazione != null)
				return false;
		} else if (!modalitaComparazione.equals(other.modalitaComparazione))
			return false;
		if (unitaMisura == null) {
			if (other.unitaMisura != null)
				return false;
		} else if (!unitaMisura.equals(other.unitaMisura))
			return false;
		return true;
	}
}
