package org.sbelli.gecomp.console.classifiche.executers;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.report.ReportManager;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.console.bridges.view.CategoriaView;
import org.sbelli.gecomp.console.bridges.view.ClassificaGaraView;
import org.sbelli.gecomp.console.bridges.view.ClassificaView;
import org.sbelli.gecomp.console.bridges.view.PrestazioneView;
import org.sbelli.gecomp.console.categorie.delegates.CategoriaDelegate;
import org.sbelli.gecomp.console.classifiche.delegates.ClassificaGaraDelegate;
import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.prestazioni.delegates.PrestazioneDelegate;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class ClassificaGaraExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private PrestazioneDelegate prestazioneDelegate = new PrestazioneDelegate();
	private CategoriaDelegate 	categoriaDelegate 	= new CategoriaDelegate();
	private ClassificaGaraDelegate classificaGaraDelegate = new ClassificaGaraDelegate();
	
	private List<PrestazioneView> prestazioni;
	public List<PrestazioneView> getPrestazioni() {return prestazioni;}
	public void setPrestazioni(List<PrestazioneView> prestazioni) {this.prestazioni = prestazioni;}

	private Long idCategoria;
	public Long getIdCategoria() {return idCategoria;}
	public void setIdCategoria(Long idCategoria) {this.idCategoria = idCategoria;}

	private Gara gara;
	public Gara getGara() {return gara;}
	public void setGara(Gara gara) {this.gara = gara;}

	private SelectItem[] categorieItem;
	public SelectItem[] getCategorieItem() {return categorieItem;}
	public void setCategorieItem(SelectItem[] categorieItem) {this.categorieItem = categorieItem;}

	private ClassificaGaraView classifica;
	public ClassificaGaraView getClassifica() {return classifica;}
	public void setClassifica(ClassificaGaraView classifica) {this.classifica = classifica;}
	
	public ClassificaGaraExecuter () {
		try {
			checks4SelectedCompetizione();
			checks4SelectedGara();

			setGara(getSelectedGara());
			setPrestazioni(prestazioneDelegate.list(getSelectedGara()));
			setCategorieItem(
					getHelper()
						.getListaCategorieItem(
								categoriaDelegate.list(getSelectedGara())));

		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.classifica.rigenerazione.ko");
		}
	}

	public void loadCategoria(ActionEvent event) {
		idCategoria = (Long) event.getComponent().getAttributes().get("idCategoria");
	} 
	public String ricaricaClassifica() {
		try {
			CategoriaView categoria = categoriaDelegate.get(idCategoria);
			setPrestazioni(prestazioneDelegate.list(getSelectedGara(),categoria));
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.classifica.rigenerazione.ko");
		}
		return GeCompOutcomes.VISUALIZZA_CLASSIFICA_GARA;
	}
	
	protected GecompModelObject retrieve() throws GeCompException {
//		Non me ne faccio niente....
		return null;
	}
	
	public void esporta(ActionEvent event) {
		try {
			ClassificaView classifica = classificaGaraDelegate.getClassifica(getSelectedGara());
			ReportManager r = new ReportManager();
			r.generateReport(classifica);
			
//			ClassificaCompetizione classificaCompetizione = ClassificaCompetizioneManager.getInstance().getClassificaCompetizione(getSelectedGara().getCompetizione());
//			ReportManager r = new ReportManager();
//			r.generateReport(classificaCompetizione);

		} catch (GeCompException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
