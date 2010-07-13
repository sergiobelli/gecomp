package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.Societa;

public class SocietaPunteggioView implements Comparable {

	private Societa societa;
	private Integer punteggio;
	
	public SocietaPunteggioView() {}
	public SocietaPunteggioView(Societa societa, Integer punteggio) {
		setSocieta(societa);
		setPunteggio(punteggio);
	}
	
	public Societa getSocieta() {
		return societa;
	}
	public void setSocieta(Societa societa) {
		this.societa = societa;
	}
	public Integer getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}
	
	public int compareTo(Object o) {
		int result = -1;
		if (o instanceof SocietaPunteggioView) {
			SocietaPunteggioView other = (SocietaPunteggioView)o;
			result = other.getPunteggio().compareTo(this.getPunteggio());
			if (result == 0) {
				result = this.getSocieta().getDenominazione().compareTo(other.getSocieta().getDenominazione());
			}
		} else {
			return result;
		}
		return result;
	}
	
	
	
}
