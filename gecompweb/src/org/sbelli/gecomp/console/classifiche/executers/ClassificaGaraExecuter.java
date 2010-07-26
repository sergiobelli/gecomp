package org.sbelli.gecomp.console.classifiche.executers;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.bridges.view.PrestazioneView;
import org.sbelli.gecomp.console.categorie.delegates.CategoriaDelegate;
import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.prestazioni.delegates.PrestazioneDelegate;
import org.sbelli.gecomp.console.report.ReportManager;
import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.orm.dao.ClassificaManager;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaCompetizione;

public class ClassificaGaraExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

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

	private PrestazioneDelegate prestazioneDelegate = new PrestazioneDelegate();
	private CategoriaDelegate 	categoriaDelegate 	= new CategoriaDelegate();
	
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
			Categoria categoria = categoriaDelegate.get(idCategoria);
			setPrestazioni(prestazioneDelegate.list(getSelectedGara(),categoria));
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.classifica.rigenerazione.ko");
		}
		return "visualizzaClassificaGara";
	}
	
	protected GecompModelObject retrieve() throws GeCompException {
//		Non me ne faccio niente....
		return null;
	}
	
	public void esporta(ActionEvent event) {
		//Long idGara = (Long) event.getComponent().getAttributes().get("idGara");
		ClassificaCompetizione classificaCompetizione = ClassificaManager.getInstance().getClassificaCompetizione(getSelectedGara().getCompetizione());
		ReportManager r = new ReportManager();
		r.generateReport(classificaCompetizione);
	}
}
