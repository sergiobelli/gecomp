package net.sb.gecomp.web.executers.classifiche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.view.ClassificaSocietaView;
import net.sb.gecomp.web.bridges.view.SocietaPunteggioView;
import net.sb.gecomp.web.delegates.classifiche.societa.ClassificaSocietaPunteggioDecrescenteDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.model.Societa;

//TODO: NON funziona!!!!
public class ClassificaSocietaGaraExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	protected ClassificaSocietaPunteggioDecrescenteDelegate delegate = new ClassificaSocietaPunteggioDecrescenteDelegate();
	
	private List<Prestazione> prestazioni;
	public List<Prestazione> getPrestazioni() {return prestazioni;}
	public void setPrestazioni(List<Prestazione> prestazioni) {this.prestazioni = prestazioni;}

	private Long tipoClassifica;
	public Long getTipoClassifica() {return tipoClassifica;}
	public void setTipoClassifica(Long tipoClassifica) {this.tipoClassifica = tipoClassifica;}

	private List<SocietaPunteggioView> classifica;
	public List<SocietaPunteggioView> getClassifica() {return classifica;}
	public void setClassifica(List<SocietaPunteggioView> classifica) {this.classifica = classifica;}
	
	private SelectItem[] tipiClassificaItem = 
		new SelectItem[] {
			new SelectItem(0, "Classifica di Societa' (Atleti iscritti)"),
			new SelectItem(1, "Classifica di Societa' (Atleti classificati)"),
			new SelectItem(2, "Classifica di Societa' (Punteggio)")
	};
	public SelectItem[] getTipiClassificaItem() {return tipiClassificaItem;}
	public void setTipiClassificaItem(SelectItem[] tipiClassificaItem) {this.tipiClassificaItem = tipiClassificaItem;}
	
	public ClassificaSocietaGaraExecuter () {
		try {
			checks4SelectedCompetizione();
			checks4SelectedGara();

			ClassificaSocietaView classifica = delegate.getClassifica(getSelectedGara());
			Set<SocietaPunteggioView> classificaTmp = new TreeSet<SocietaPunteggioView>();
			for (Map.Entry<Societa, Integer> entry : classifica.getClassificaSocietaIscritte().entrySet()) {
				classificaTmp.add(new SocietaPunteggioView(entry.getKey(), entry.getValue()));
			}
			setClassifica(new ArrayList<SocietaPunteggioView>(classificaTmp));
			
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "xxxx.xxxxx.xxxxxxx.xxxxxxxxxxxxxxxxxxxxxx");
		}
	}

	public void loadTipoClassifica(ActionEvent event) {
		tipoClassifica = (Long) event.getComponent().getAttributes().get("tipoClassifica");
	} 
	
	public String ricaricaClassifica() {
		try {
			
			ClassificaSocietaView classifica = delegate.getClassifica(getSelectedGara());
			HashMap<Societa, Integer> mappa = null;
			switch ( tipoClassifica.intValue() ) {
				case 0: {
					mappa = classifica.getClassificaSocietaIscritte();
					break;
				}
				case 1: {
					mappa = classifica.getClassificaSocietaClassificate();
					break;
				}
				case 2: {
					mappa = classifica.getClassificaSocietaPunteggio();
					break;
				}
			}
			
			Set<SocietaPunteggioView> classificaTmp = new TreeSet<SocietaPunteggioView>();
			for (Map.Entry<Societa, Integer> entry : mappa.entrySet()) {
				classificaTmp.add(new SocietaPunteggioView(entry.getKey(), entry.getValue()));
			}
			setClassifica(new ArrayList<SocietaPunteggioView>(classificaTmp));
			
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "xxxx.xxxxx.xxxxxxx.xxxxxxxxxxxxxxxxxxx");
		}
		return GeCompOutcomes.VISUALIZZA_CLASSIFICA_GARA_SOCIETA;
	}
	
	protected GecompModelObject retrieve() throws GeCompException {
//		Non me ne faccio niente....
		return null;
	}
}
