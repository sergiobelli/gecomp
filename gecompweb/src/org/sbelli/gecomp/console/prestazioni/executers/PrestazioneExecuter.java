package org.sbelli.gecomp.console.prestazioni.executers;

import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.prestazioni.delegates.PrestazioneDelegate;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	protected PrestazioneDelegate delegate = new PrestazioneDelegate();
	
	private Prestazione prestazione;
	public Prestazione getPrestazione() {return prestazione;}
	public void setPrestazione(Prestazione prestazione) {this.prestazione = prestazione;}
	
}
