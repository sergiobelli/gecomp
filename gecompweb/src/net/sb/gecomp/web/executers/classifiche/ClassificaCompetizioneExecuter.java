package net.sb.gecomp.web.executers.classifiche;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.orm.dao.ClassificaCompetizioneManager;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.orm.presentation.classifiche.ClassificaCompetizione;


public class ClassificaCompetizioneExecuter {

	public ClassificaCompetizioneExecuter () {
		try {
			classificaCompetizione = ClassificaCompetizioneManager.getInstance().getClassificaCompetizione(DbManagerFactory.getInstance().getCompetizioneDao().list().iterator().next());
		} catch (GeCompOrmException e) {
			e.printStackTrace();
		}
	}
	
	private ClassificaCompetizione classificaCompetizione;
	public ClassificaCompetizione getClassificaCompetizione() {return classificaCompetizione;}
	public void setClassificaCompetizione(ClassificaCompetizione classificaCompetizione) {this.classificaCompetizione = classificaCompetizione;}
	
}
