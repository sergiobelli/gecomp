package org.sbelli.gecomp.console.competizione.delegates;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.competizione.bridges.CompetizioneBridge;
import org.sbelli.gecomp.console.competizione.controllers.CompetizioneController;
import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class CompetizioneDelegate extends GenericDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private CompetizioneController controller = new CompetizioneController();
	private CompetizioneBridge bridge = new CompetizioneBridge();
	
	public void delete(GecompModelObject element) throws GeCompException {
		Competizione competizione = (Competizione) element;
		bridge.delete(competizione);
	}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Competizione competizione = (Competizione) element;
		controller.checks(competizione);
		competizione.setSocietaOrganizzatrice(DbManagerFactory.getInstance().getSocietaDao().get(competizione.getSocietaOrganizzatrice().getId()));
		return competizione;
	}

	public void save(GecompModelObject element) throws GeCompException {
		Competizione competizione = (Competizione) element;
		
		retrieve(competizione);
		logger.debug("Customized Competizione = " + competizione);

		if (Eval.isNull(competizione.getIdCompetizione())) {
			bridge.insert(competizione);
		} else {
			bridge.update(competizione);
		}
	}

	public Competizione get(Long id) throws GeCompException {
		return bridge.get(id);
	}

}
