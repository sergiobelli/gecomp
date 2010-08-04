package org.sbelli.gecomp.console.atleti.executers;

import org.sbelli.gecomp.console.bridges.view.AtletaView;

/**
 * 
 * @author S.BELLI
 *
 */
public class InserisciAtletaExecuter extends AtletaExecuter {

	public InserisciAtletaExecuter () {
		setAtleta(new AtletaView());
	}

	public String salva() {
		logger.info("Salvataggio di un nuovo atleta in corso...");
		return super.salva();
	}

}
