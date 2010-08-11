package net.sb.gecomp.web.delegates.competizione;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.competizione.CompetizioneBridge;
import net.sb.gecomp.web.bridges.societa.SocietaBridge;
import net.sb.gecomp.web.bridges.view.CompetizioneView;
import net.sb.gecomp.web.controllers.competizione.CompetizioneController;
import net.sb.gecomp.web.delegates.GenericDelegate;

import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class CompetizioneDelegate extends GenericDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private CompetizioneController controller = new CompetizioneController();
	
	private CompetizioneBridge bridge = new CompetizioneBridge();
	private SocietaBridge socBridge = new SocietaBridge();
	
	public void delete(GecompModelObject element) throws GeCompException {
		Competizione competizione = (Competizione) element;
		bridge.delete(competizione);
	}

	public CompetizioneView retrieve(GecompModelObject element) throws GeCompException {
		CompetizioneView competizione = (CompetizioneView) element;
		controller.checks(competizione);
		competizione.setSocietaOrganizzatrice(socBridge.get(competizione.getSocietaOrganizzatrice().getId()));
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

	public CompetizioneView get(Long id) throws GeCompException {
		return bridge.get(id);
	}

}
