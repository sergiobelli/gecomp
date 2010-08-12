package net.sb.gecomp.web.executers.atleti;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Atleta;


public class ElencoAtletiExecuter extends AtletaExecuter {

	public ElencoAtletiExecuter() {}
	
	public String salva() {		
		Atleta tmpAtleta = getAtleta();
		
		try {
			delegate.save(tmpAtleta);
		} catch (GeCompException e) {
			e.printStackTrace();
		}		
		return "";
	}
	
}
