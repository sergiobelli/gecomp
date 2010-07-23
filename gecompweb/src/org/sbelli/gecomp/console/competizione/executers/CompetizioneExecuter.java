package org.sbelli.gecomp.console.competizione.executers;

import java.util.List;

import javax.faces.model.SelectItem;

import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.competizione.delegates.CompetizioneDelegate;
import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Societa;

public class CompetizioneExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	protected CompetizioneDelegate delegate = new CompetizioneDelegate();
	
	public CompetizioneExecuter () {

		competizione = new Competizione();
		competizione.setSocietaOrganizzatrice(new Societa());
		
		loadSocietaList();
	}

	protected Long idCompetizione;
	protected Competizione competizione;
	public Competizione getCompetizione() { return competizione; }
	public void setCompetizione(Competizione competizione) { this.competizione = competizione; }

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
			GeCompExceptionManager.manageException(logger, ex);
		}
	}

}
