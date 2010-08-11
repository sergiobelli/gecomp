package net.sb.gecomp.web.executers;

import javax.faces.component.html.HtmlDataTable;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.view.CompetizioneView;
import net.sb.gecomp.web.bridges.view.GaraView;
import net.sb.gecomp.web.delegates.iscrizioni.IscrizioneDelegate;
import net.sb.gecomp.web.delegates.prestazioni.PrestazioneDelegate;
import net.sb.gecomp.web.user.GeCompUserSessionHandler;


public abstract class GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	//protected abstract <T extends GecompModelObject> T retrieve(int i) throws GeCompException;//TODO:questo lavoro l'ho finito o no??????????
	
	public enum STATO { INSERIMENTO, MODIFICA, CANCELLAZIONE, LISTA; }
	
	private STATO INSERIMENTO = STATO.INSERIMENTO;
	public STATO getINSERIMENTO() {return INSERIMENTO;}

	public STATO MODIFICA = STATO.MODIFICA;
	public STATO getMODIFICA() {return MODIFICA;}

	public STATO CANCELLAZIONE = STATO.CANCELLAZIONE;
	public STATO getCANCELLAZIONE() {return CANCELLAZIONE;}
	
	public STATO LISTA = STATO.LISTA;
	public STATO getLISTA() {return LISTA;}	

	
	protected STATO stato;
	
	public ExecuterHelper getHelper() { return new ExecuterHelper(); }
	
	protected Boolean isSelectedCompetizione() { return Eval.isNotNull(GeCompUserSessionHandler.getGeCompUserSession().getCompetizione()); }
	protected CompetizioneView getSelectedCompetizione() { return GeCompUserSessionHandler.getGeCompUserSession().getCompetizione(); }
	protected void checks4SelectedCompetizione() throws GeCompException {
		if (!isSelectedCompetizione()) {
			throw new GeCompException("message.competizione.non.selezionata");
		}
	}

	protected Boolean isSelectedGara() {return Eval.isNotNull(GeCompUserSessionHandler.getGeCompUserSession().getGara());}
	protected GaraView getSelectedGara() {return new GaraView(GeCompUserSessionHandler.getGeCompUserSession().getGara());}
	protected void checks4SelectedGara() throws GeCompException {
		if (!isSelectedGara()) {
			throw new GeCompException("message.gara.non.selezionata");
		}
	}
	
	protected void checks4ExitentsIscrizioni() throws GeCompException {
		if (Eval.isEmpty(new IscrizioneDelegate().list(getSelectedGara()))) {
			throw new GeCompException("message.gara.nessun.iscritto.presente");
		}
	}
	protected void checks4ExitentsPrestazioni() throws GeCompException {
		if (Eval.isEmpty(new PrestazioneDelegate().list(getSelectedGara()))) {
			throw new GeCompException("message.gara.nessun.prestazione.presente");
		}
	}
	
	

	
//	Gestione elenchi
	public void pageFirst() {
		myDataTable.setFirst(0);
	}

	public void pagePrevious() {
		myDataTable.setFirst(myDataTable.getFirst() - myDataTable.getRows());
	}

	public void pageNext() {
		myDataTable.setFirst(myDataTable.getFirst() + myDataTable.getRows());
	}

	public void pageLast() {
		int count = myDataTable.getRowCount();
		int rows = myDataTable.getRows();
		myDataTable.setFirst(count
				- ((count % rows != 0) ? count % rows : rows));
	}

	private HtmlDataTable myDataTable;

	public void setMyDataTable(HtmlDataTable myDataTable) {
		this.myDataTable = myDataTable;
	}

	public HtmlDataTable getMyDataTable() {
		return myDataTable;
	}

	public String getPagina() {
		int recordPagina = myDataTable.getRows();
		int primoRecord = myDataTable.getFirst();
		int numeroPagina = (primoRecord / recordPagina) + 1;
		return Integer.valueOf(numeroPagina).toString();
	}

	public String getPagine() {
		int numeroRighe = myDataTable.getRowCount();
		int recordPagina = myDataTable.getRows();
		int numeroPagine = (numeroRighe / recordPagina) + 1;
		return Integer.valueOf(numeroPagine).toString();
	}
//	Gestione elenchi
}
