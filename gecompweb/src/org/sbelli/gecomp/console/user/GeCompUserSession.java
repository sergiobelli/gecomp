package org.sbelli.gecomp.console.user;

import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.User;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaCompetizione;

/**
 * @author S.BELLI
 */
public class GeCompUserSession {

	private User loggedUser;
	public User getLoggedUser() { return loggedUser; }
	public void setLoggedUser(User loggedUser) { this.loggedUser = loggedUser; }

	private Competizione competizione;
	public Competizione getCompetizione() { return competizione; }
	public void setCompetizione(Competizione competizione) { this.competizione = competizione; }

	private Gara gara;
	public Gara getGara() {return gara;}
	public void setGara(Gara gara) {this.gara = gara;}

	private ClassificaCompetizione classificaCompetizione;
	public ClassificaCompetizione getClassificaCompetizione() { return classificaCompetizione; }
	public void setClassificaCompetizione(ClassificaCompetizione classificaCompetizione) { this.classificaCompetizione = classificaCompetizione; }

}
