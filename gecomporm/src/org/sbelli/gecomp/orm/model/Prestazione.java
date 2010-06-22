package org.sbelli.gecomp.orm.model;


/**
 * @author sbelli
 */
public class Prestazione extends GecompModelObject implements Comparable<Prestazione> {

	private static final long serialVersionUID = 1L;
	
	public Prestazione() {}
	public Prestazione(Iscrizione iscrizione, TipoPrestazione tipoPrestazione, TipoMisura tipoMisura, Long valoreMisura) {
		setIscrizione(iscrizione);
		setTipoPrestazione(tipoPrestazione);
		setTipoMisura(tipoMisura);
		setValoreMisura(valoreMisura);
	}
	
    private Long idPrestazione;
	public Long getIdPrestazione() {return idPrestazione;}
	public void setIdPrestazione(Long idPrestazione) {this.idPrestazione = idPrestazione;}
	
    private Iscrizione iscrizione;
    public Iscrizione getIscrizione() {return iscrizione;}
	public void setIscrizione(Iscrizione iscrizione) {this.iscrizione = iscrizione;}

	private TipoPrestazione tipoPrestazione;
	public TipoPrestazione getTipoPrestazione() { return tipoPrestazione; }
	public void setTipoPrestazione(TipoPrestazione tipoPrestazione) { this.tipoPrestazione = tipoPrestazione; }

	private TipoMisura tipoMisura;
	public TipoMisura getTipoMisura() { return tipoMisura; }
	public void setTipoMisura(TipoMisura tipoMisura) { this.tipoMisura = tipoMisura; }

	private Long valoreMisura;
	public Long getValoreMisura() {return this.valoreMisura;}
	public void setValoreMisura(Long valoreMisura) { this.valoreMisura = valoreMisura; }
	public String getValoreMisuraFormatted() {
		return this.getTipoMisura().getValoreMisuraFormatted(this.getValoreMisura());
	}
	
	private Integer posizione;
	public Integer getPosizione() {return posizione;}
	public void setPosizione(Integer posizione) {this.posizione = posizione;}
	
	public int compareTo(Prestazione other) {
		if (isTheSameGara(other) && isTheSameCompetizione(other)) {
			
			//Entrambe sono VALIDE
			if (TipoPrestazione.VALIDA.equals(this.getTipoPrestazione().getIdTipoPrestazione())
					&& TipoPrestazione.VALIDA.equals(other.getTipoPrestazione().getIdTipoPrestazione())) {
				if (TipoMisura.MISURAZIONE_ASCENDENTE.equals(this.getTipoMisura().getModalitaComparazione())) {
					if (this.getValoreMisura() < other.getValoreMisura()) {
						return -1;
					} else if (this.getValoreMisura().equals(other.getValoreMisura())) {
						return 0;
					} else {
						return 1;
					}	
				} else {
					if (this.getValoreMisura() < other.getValoreMisura()) {
						return 1;
					} else if (this.getValoreMisura().equals(other.getValoreMisura())) {
						return 0;
					} else {
						return -1;
					}
				}
			}
			
			//Si confrontano le tipologie di prestazione
			else {
				return this.getTipoPrestazione().compareTo(other.getTipoPrestazione());
			}
			
		}
		return -2;
	}
	private boolean isTheSameGara(Prestazione prestazione) {
		return this.getIscrizione().getGara().equals(prestazione.getIscrizione().getGara());
    }
    private boolean isTheSameCompetizione(Prestazione prestazione) {
    	return this.getIscrizione().getGara().getCompetizione().equals(prestazione.getIscrizione().getGara().getCompetizione());
    }
}
