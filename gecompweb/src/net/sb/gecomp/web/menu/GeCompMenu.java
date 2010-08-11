package net.sb.gecomp.web.menu;

import net.sb.gecomp.exceptions.GeCompException;

import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

/**
 * @author S.BELLI
 */
public class GeCompMenu extends GenericExecuter {

	public String inserisciCompetizione () {
		return GeCompOutcomes.INSERISCI_COMPETIZIONE;
	}
	public String listaCompetizioni () {
		return GeCompOutcomes.LISTA_COMPETIZIONI;
	}

	public String inserisciGara () {
		try {
			checks4SelectedCompetizione();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezione.ko");
			return goHome();
		}
		return GeCompOutcomes.INSERISCI_GARA;
	}
	public String listaGare () {
		try {
			checks4SelectedCompetizione();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezione.ko");
			return goHome();
		}
		return GeCompOutcomes.LISTA_GARE;
	}    

	public String inserisciCategoria () {
		return GeCompOutcomes.INSERISCI_CATEGORIA;
	}
	public String listaCategorie () {
		return GeCompOutcomes.LISTA_CATEGORIE;
	}    

	public String inserisciIscrizioni () {
		try {
			checks4SelectedCompetizione();
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezione.ko");
			return goHome();
		}
		try {
			checks4SelectedGara();
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.gara.selezione.ko");
			return goHome();
		}
		return GeCompOutcomes.INSERISCI_ISCRIZIONI;
	}
	public String listaIscrizioni () {
		try {
			checks4SelectedCompetizione();
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezione.ko");
			return goHome();
		}
		try {
			checks4SelectedGara();
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.gara.selezione.ko");
			return goHome();
		}
		return GeCompOutcomes.LISTA_ISCRIZIONI;
	}    

	public String inserisciPrestazioni () {
		try {
			checks4SelectedCompetizione();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezione.ko");
			return goHome();
		}
		try {
			checks4SelectedGara();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.gara.selezione.ko");
			return goHome();
		}
		try {
			checks4ExitentsIscrizioni();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.iscrizione.presenza.ko");
			return goHome();
		}
		return GeCompOutcomes.INSERISCI_PRESTAZIONI;
	}
	public String listaPrestazioni () {
		try {
			checks4SelectedCompetizione();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezione.ko");
			return goHome();
		}
		try {
			checks4SelectedGara();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.gara.selezione.ko");
			return goHome();
		}
		try {
			checks4ExitentsIscrizioni();
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.iscrizione.presenza.ko");
			return goHome();
		}
		return GeCompOutcomes.LISTA_PRESTAZIONI;
	}    

	public String inserisciAtleta () {
		return GeCompOutcomes.INSERISCI_ATLETA;
	}
	public String listaAtleti () {
		return GeCompOutcomes.LISTA_ATLETI;
	}

	
	//Classifiche gara
	public String visualizzaClassificaGaraSocieta () {
		try {
			checks4ClassificaGara();
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, e.getMessage());
			return goHome();
		}
		return GeCompOutcomes.VISUALIZZA_CLASSIFICA_GARA_SOCIETA;
	}
	public String visualizzaClassificaGara () {
		try {
			checks4ClassificaGara();
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, e.getMessage());
			return goHome();
		}
		return GeCompOutcomes.VISUALIZZA_CLASSIFICA_GARA;
	}
	private void checks4ClassificaGara() throws GeCompException {
		try {
			checks4SelectedCompetizione();
		} catch (Exception e) {
			throw new GeCompException("error.competizione.selezione.ko");
		}
		try {
			checks4SelectedGara();
		} catch (Exception e) {
			throw new GeCompException("error.gara.selezione.ko");
		}
		try {
			checks4ExitentsIscrizioni();
		} catch (Exception e) {
			throw new GeCompException("error.iscrizione.presenza.ko");
		}
		try {
			checks4ExitentsPrestazioni();
		} catch (Exception e) {
			throw new GeCompException("message.gara.nessun.prestazione.presente.descrizione");
		}
	}
	//Classifiche gara
	
	
	public String visualizzaClassificaCompetizione () {
		return GeCompOutcomes.VISUALIZZA_CLASSIFICA_COMPETIZIONE;
	}
	
	public String inserisciSocieta () {
		return GeCompOutcomes.INSERISCI_SOCIETA;
	}
	public String listaSocieta () {
		return GeCompOutcomes.LISTA_SOCIETA;
	} 
	
	public String goHome() {
		return GeCompOutcomes.HOME;
	}
}
