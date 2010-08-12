package net.sb.gecomp.web.executers.classifiche;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.srv.orm.dao.ClassificaCompetizioneManager;
import net.sb.gecomp.srv.orm.presentation.classifiche.ClassificaCompetizione;
import net.sb.gecomp.web.delegates.competizione.CompetizioneDelegate;


public class ClassificaCompetizioneExecuter {

	protected CompetizioneDelegate delegate = new CompetizioneDelegate();
	
	public ClassificaCompetizioneExecuter () {
		try {
			classificaCompetizione = ClassificaCompetizioneManager.getInstance().getClassificaCompetizione(delegate.list().iterator().next());
		} catch (GeCompException e) {
			e.printStackTrace();
		}
	}
	
	private ClassificaCompetizione classificaCompetizione;
	public ClassificaCompetizione getClassificaCompetizione() {return classificaCompetizione;}
	public void setClassificaCompetizione(ClassificaCompetizione classificaCompetizione) {this.classificaCompetizione = classificaCompetizione;}
	
}
