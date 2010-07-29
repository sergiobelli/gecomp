package org.sbelli.gecomp.console.atleti.executers;

import net.sb.gecomp.exceptions.GeCompOrmException;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;

public class ElencoAtletiExecuter extends AtletaExecuter {

	public ElencoAtletiExecuter() {}
	
	public String salva() {		
		Atleta tmpAtleta = getAtleta();
		
		try {
			DbManagerFactory.getInstance().getAtletaDao().insert(tmpAtleta);
		} catch (GeCompOrmException e) {
			e.printStackTrace();
		}		
		return "";
	}
	
}
