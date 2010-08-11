package net.sb.gecomp.web.bridges.view;

import net.sb.gecomp.model.Societa;

public class SocietaPunteggioView extends SocietaView implements Comparable {

//	private Societa societa;
	private Integer punteggio;
	
	public SocietaPunteggioView() {}
	public SocietaPunteggioView(Societa societa, Integer punteggio) {
		super(societa);
		setPunteggio(punteggio);
	}
	
//	public Societa getSocieta() {
//		return societa;
//	}
//	public void setSocieta(Societa societa) {
//		this.societa = societa;
//	}
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
				result = this.getDenominazione().compareTo(other.getDenominazione());
			}
		} else {
			return result;
		}
		return result;
	}
	
	
	
}
