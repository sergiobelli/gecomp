package org.sbelli.gecomp.console.executers;

import javax.faces.component.html.HtmlDataTable;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.iscrizioni.delegates.IscrizioneDelegate;
import org.sbelli.gecomp.console.prestazioni.delegates.PrestazioneDelegate;
import org.sbelli.gecomp.console.user.GeCompUserSessionHandler;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;

public abstract class GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	//protected abstract <T extends GecompModelObject> T retrieve(int i) throws GeCompException;//TODO:questo lavoro l'ho finito o no??????????
	
	public ExecuterHelper getHelper() { return new ExecuterHelper(); }
	
	protected Boolean isSelectedCompetizione() { return Eval.isNotNull(GeCompUserSessionHandler.getGeCompUserSession().getCompetizione()); }
	protected Competizione getSelectedCompetizione() { return GeCompUserSessionHandler.getGeCompUserSession().getCompetizione(); }
	protected void checks4SelectedCompetizione() throws GeCompException {
		if (Eval.isNull(getSelectedCompetizione())) {
			throw new GeCompException("message.competizione.non.selezionata");
		}
	}

	protected Boolean isSelectedGara() {return Eval.isNotNull(GeCompUserSessionHandler.getGeCompUserSession().getGara());}
	protected Gara getSelectedGara() {return GeCompUserSessionHandler.getGeCompUserSession().getGara();}
	protected void checks4SelectedGara() throws GeCompException {
		if (Eval.isNull(getSelectedGara())) {
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
