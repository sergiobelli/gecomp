package net.sb.gecomp.web.executers.atleti;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.model.Atleta;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;


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
