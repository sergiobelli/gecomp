package net.sb.gecomp.web.executers.classifiche;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.commons.model.view.ClassificaGaraView;
import net.sb.gecomp.commons.model.view.ClassificaView;
import net.sb.gecomp.commons.model.view.PrestazioneView;
import net.sb.gecomp.web.delegates.categorie.CategoriaDelegate;
import net.sb.gecomp.web.delegates.classifiche.ClassificaGaraDelegate;
import net.sb.gecomp.web.delegates.prestazioni.PrestazioneDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.report.ReportManager;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class ClassificaGaraExecuter extends GenericExecuter {

	private PrestazioneDelegate prestazioneDelegate;
	public void setPrestazioneDelegate(PrestazioneDelegate prestazioneDelegate) {
		this.prestazioneDelegate = prestazioneDelegate;
	}

	private CategoriaDelegate 	categoriaDelegate;
	public void setCategoriaDelegate(CategoriaDelegate categoriaDelegate) {
		this.categoriaDelegate = categoriaDelegate;
	}

	private ClassificaGaraDelegate classificaGaraDelegate;
	public void setClassificaGaraDelegate(
			ClassificaGaraDelegate classificaGaraDelegate) {
		this.classificaGaraDelegate = classificaGaraDelegate;
	}

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
			setPrestazioni(prestazioneDelegate.list(getSelectedGara(),categoria, Boolean.FALSE));
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
