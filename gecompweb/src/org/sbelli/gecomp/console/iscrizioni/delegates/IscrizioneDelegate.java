package org.sbelli.gecomp.console.iscrizioni.delegates;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.bridges.view.IscrizioneView;
import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.console.iscrizioni.bridges.IscrizioneBridge;
import org.sbelli.gecomp.console.iscrizioni.controllers.IscrizioneController;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Iscrizione;

public class IscrizioneDelegate extends GenericDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private IscrizioneController controller = new IscrizioneController();
	private IscrizioneBridge bridge = new IscrizioneBridge();

	public void delete(GecompModelObject element) throws GeCompException {
		try {
			bridge.delete((Iscrizione)element);
		} catch (Exception ex) {
			logger.error(ex, "Errore in fase di cancellazione di un'iscrizione");
			throw new GeCompException("error.iscrizione.eliminazione.ko");
		}
	}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Iscrizione iscrizione = (Iscrizione)element;
		controller.checks(element);
		return iscrizione;
	}

	public void save(GecompModelObject element) throws GeCompException {
		try {
			Iscrizione iscrizione = (Iscrizione) retrieve(element);
			logger.debug("Customized Iscrizione = " + iscrizione);
			if (Eval.isNull(iscrizione.getIdIscrizione())) {
				iscrizione = (Iscrizione)bridge.insert(iscrizione);
			} else {
				bridge.update(iscrizione);
			}
		} catch (GeCompOrmException ex) {
			logger.error(ex, "Errore in fase di modifica/savataggio dell'iscrizione");
			throw new GeCompException("error.iscrizione.modifica.salvataggio.ko");
		}
	}

	public IscrizioneView get(Long id) throws GeCompException {
		return bridge.get(id);
	}

	public List<IscrizioneView> list(Gara gara) throws GeCompException {
		try {
			return bridge.list(gara);
		} catch (GeCompOrmException ex) {
			logger.error(ex, "Non ci sono iscrizioni per la gara specificata ", gara);
			throw new GeCompException("c.c.c.c.c.c.c.c");
		}
	}
}
