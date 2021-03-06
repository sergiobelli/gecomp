package net.sb.gecomp.commons.utils.misure;

import org.apache.log4j.Logger;

public class TipoMisuraTempoHelper {

	protected static Logger logger = Logger.getLogger(TipoMisuraTempoHelper.class.getName());
	
	public static final String parse(Long valoreMisura) {
//		TODO:capire bene come funziona il formatter di yoda time per il tempo
//		DateTimeFormatter fmt = DateTimeFormat.forPattern("hh:mm:ss.SSS");
//		String cazzo = fmt.print(valoreMisura);
		
		
		String ore = "00";
		String minuti = "00";
		String secondi = "00";
		String millisecondi = "000";//TODO:introdurre gestione dei millesimi
		
		millisecondi = Integer.toString((int)(valoreMisura % 1000d));
		long time = valoreMisura.longValue() / 1000; 
		secondi = Integer.toString((int)(time % 60));
		minuti = Integer.toString((int)((time % 3600) / 60));
		ore = Integer.toString((int)(time / 3600));
		for (int i = 0; i < 2; i++) {
			if (secondi.length() < 2) {
				secondi = "0" + secondi;
			}
			if (minuti.length() < 2) {
				minuti = "0" + minuti;
			}
			if (ore.length() < 2) {
				ore = "0" + ore;
			}
		}
		
		String valoreMisuraFormattato = ore + ":" + minuti + ":" + secondi + "." + millisecondi;
		logger.info("Valore misura formattato = "+ valoreMisuraFormattato);
		return valoreMisuraFormattato;
	}
}
