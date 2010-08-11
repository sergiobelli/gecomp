package net.sb.gecomp.web.executers.atleti;

import net.sb.gecomp.web.bridges.view.AtletaView;

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
