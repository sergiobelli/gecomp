package net.sb.gecomp.web.delegates.competizione;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.competizione.CompetizioneBridge;
import net.sb.gecomp.web.bridges.societa.SocietaBridge;
import net.sb.gecomp.web.controllers.competizione.CompetizioneController;
import net.sb.gecomp.web.delegates.GenericDelegate;
import net.sb.gecomp.web.utils.context.GecompContextFactory;


public class CompetizioneDelegate extends GenericDelegate {

	private CompetizioneController controller = new CompetizioneController();
	
	private CompetizioneBridge bridge;
	public CompetizioneBridge getBridge() {return (CompetizioneBridge)super.getBridge();}
	public void setBridge(CompetizioneBridge bridge) { this.bridge = bridge; }
	
	private SocietaBridge societaBridge;
	public SocietaBridge getSocietaBridge() {
		if (Eval.isNull(societaBridge)) {
			setSocietaBridge((SocietaBridge)GecompContextFactory.getContext().getBean("societaBridge"));
		}
		return societaBridge;
	}
	public void setSocietaBridge(SocietaBridge societaBridge) {this.societaBridge = societaBridge;}
	
	public void delete(GecompModelObject element) throws GeCompException {
		Competizione competizione = (Competizione) element;
		getBridge().delete(competizione);
	}

	public CompetizioneView retrieve(GecompModelObject element) throws GeCompException {
		CompetizioneView competizione = (CompetizioneView) element;
		controller.checks(competizione);
		competizione.setSocietaOrganizzatrice(getSocietaBridge().get(competizione.getSocietaOrganizzatrice().getId()));
		return competizione;
	}

	public void save(GecompModelObject element) throws GeCompException {
		Competizione competizione = (Competizione) element;
		
		retrieve(competizione);
		logger.debug("Customized Competizione = " + competizione);

		if (Eval.isNull(competizione.getIdCompetizione())) {
			getBridge().insert(competizione);
		} else {
			getBridge().update(competizione);
		}
	}

	public CompetizioneView get(Long id) throws GeCompException {
		return getBridge().get(id);
	}
	
	public List<CompetizioneView> list() throws GeCompException {
		return getBridge().list();
	}

}
