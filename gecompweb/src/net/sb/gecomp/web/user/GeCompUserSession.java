package net.sb.gecomp.web.user;

import net.sb.gecomp.commons.model.User;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.srv.orm.presentation.classifiche.ClassificaCompetizione;


/**
 * @author S.BELLI
 */
public class GeCompUserSession {

	private User loggedUser;
	public User getLoggedUser() { return loggedUser; }
	public void setLoggedUser(User loggedUser) { this.loggedUser = loggedUser; }

	private CompetizioneView competizione;
	public CompetizioneView getCompetizione() { return competizione; }
	public void setCompetizione(CompetizioneView competizione) { this.competizione = competizione; }

	private GaraView gara;
	public GaraView getGara() {return gara;}
	public void setGara(GaraView gara) {this.gara = gara;}

	private ClassificaCompetizione classificaCompetizione;
	public ClassificaCompetizione getClassificaCompetizione() { return classificaCompetizione; }
	public void setClassificaCompetizione(ClassificaCompetizione classificaCompetizione) { this.classificaCompetizione = classificaCompetizione; }

}
