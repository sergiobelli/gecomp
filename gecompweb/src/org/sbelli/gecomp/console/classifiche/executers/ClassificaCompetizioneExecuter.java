package org.sbelli.gecomp.console.classifiche.executers;

import org.sbelli.gecomp.orm.dao.ClassificaManager;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaCompetizione;

public class ClassificaCompetizioneExecuter {

	public ClassificaCompetizioneExecuter () {
		try {
			classificaCompetizione = ClassificaManager.getInstance().getClassificaCompetizione(DbManagerFactory.getInstance().getCompetizioneDao().list().iterator().next());
		} catch (GeCompOrmException e) {
			e.printStackTrace();
		}
	}
	
	private ClassificaCompetizione classificaCompetizione;
	public ClassificaCompetizione getClassificaCompetizione() {return classificaCompetizione;}
	public void setClassificaCompetizione(ClassificaCompetizione classificaCompetizione) {this.classificaCompetizione = classificaCompetizione;}
	
}
