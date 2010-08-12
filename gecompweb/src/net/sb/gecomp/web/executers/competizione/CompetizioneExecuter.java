package net.sb.gecomp.web.executers.competizione;

import java.util.List;

import javax.faces.model.SelectItem;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;
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

	protected List<Competizione> competizioni;
	public List<Competizione> getCompetizioni() { return competizioni; }
	public void setCompetizioni(List<Competizione> competizioni) { this.competizioni = competizioni; }

	protected SelectItem[] listaSocieta;
	public SelectItem[] getListaSocieta() { return listaSocieta; }
	public void setListaSocieta(SelectItem[] societa) { this.listaSocieta = societa; }

	protected void loadSocietaList () {
		try {
			List<Societa> tmpSocieta = DbManagerFactory.getInstance().getSocietaDao().list();

			int pos = 0;
			listaSocieta = new SelectItem[tmpSocieta.size()];
			for (Societa soc : tmpSocieta) {
				listaSocieta[pos] = new SelectItem(soc.getId(), soc.getDenominazione());
				pos++;
			}

		} catch (GeCompOrmException ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
	}

}
