package org.sbelli.gecomp.orm.model;

public class TipoPrestazione extends GecompModelObject implements Comparable<TipoPrestazione> {

	public static final Long VALIDA 			= 1l;
	public static final Long RITIRO 			= 2l;
	public static final Long SQUALIFICA 		= 3l;
	public static final Long NON_CLASSIFICATO 	= 4l;
	public static final Long NON_PARTECIPATO	= 5l;
	
	private Long idTipoPrestazione;
	private String descrizione;
	
	public TipoPrestazione(){}
	public TipoPrestazione(Long idTipoPrestazione, String descrizione){
		setIdTipoPrestazione(idTipoPrestazione);
		setDescrizione(descrizione);
	}
	
	public Long getIdTipoPrestazione() { return idTipoPrestazione; }
	public void setIdTipoPrestazione(Long idTipoPrestazione) { this.idTipoPrestazione = idTipoPrestazione; }
	
	public String getDescrizione() { return descrizione; }
	public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

	public int compareTo(TipoPrestazione other) {

		//Solo this e' VALIDA
		if (TipoPrestazione.VALIDA.equals(this.getIdTipoPrestazione())
				&& !TipoPrestazione.VALIDA.equals(other.getIdTipoPrestazione())) {
			return -1;
		}

		//Solo other e' VALIDA
		else if (!TipoPrestazione.VALIDA.equals(this.getIdTipoPrestazione())
				&& TipoPrestazione.VALIDA.equals(other.getIdTipoPrestazione())) {
			return 1;
		}

		//Entrambe non sono VALIDE
		else {
			return this.getIdTipoPrestazione().compareTo(other.getIdTipoPrestazione());
		}

	}
	
}
