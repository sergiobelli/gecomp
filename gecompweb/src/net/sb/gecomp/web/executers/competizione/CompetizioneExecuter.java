package net.sb.gecomp.web.executers.competizione;

import java.util.List;

import javax.faces.model.SelectItem;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.SocietaView;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.web.delegates.competizione.CompetizioneDelegate;
import net.sb.gecomp.web.delegates.societa.SocietaDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;


public class CompetizioneExecuter extends GenericExecuter {

	protected CompetizioneDelegate delegate = new CompetizioneDelegate();
	protected SocietaDelegate socDelegate = new SocietaDelegate();
	
	public CompetizioneExecuter () {

		competizione = new CompetizioneView();
		competizione.setSocietaOrganizzatrice(new Societa());
		
		loadSocietaList();
	}

	protected Long idCompetizione;
	protected CompetizioneView competizione;
	public CompetizioneView getCompetizione() { return competizione; }
	public void setCompetizione(CompetizioneView competizione) { this.competizione = competizione; }

	protected List<CompetizioneView> competizioni;
	public List<CompetizioneView> getCompetizioni() { return competizioni; }
	public void setCompetizioni(List<CompetizioneView> competizioni) { this.competizioni = competizioni; }

	protected SelectItem[] listaSocieta;
	public SelectItem[] getListaSocieta() { return listaSocieta; }
	public void setListaSocieta(SelectItem[] societa) { this.listaSocieta = societa; }

	protected void loadSocietaList () {
		try {
			List<SocietaView> tmpSocieta = socDelegate.list();

			int pos = 0;
			listaSocieta = new SelectItem[tmpSocieta.size()];
			for (Societa soc : tmpSocieta) {
				listaSocieta[pos] = new SelectItem(soc.getId(), soc.getDenominazione());
				pos++;
			}

		} catch (GeCompException ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
	}

}
