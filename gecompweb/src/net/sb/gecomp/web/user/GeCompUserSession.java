package net.sb.gecomp.web.user;

import org.sbelli.gecomp.console.bridges.view.GaraView;
import org.sbelli.gecomp.orm.model.Competizione;
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

	private GaraView gara;
	public GaraView getGara() {return gara;}
	public void setGara(GaraView gara) {this.gara = gara;}

	private ClassificaCompetizione classificaCompetizione;
	public ClassificaCompetizione getClassificaCompetizione() { return classificaCompetizione; }
	public void setClassificaCompetizione(ClassificaCompetizione classificaCompetizione) { this.classificaCompetizione = classificaCompetizione; }

}
