package org.sbelli.gecomp.console.classifiche;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Prestazione;

public class ClassificaSocietaGaraExecuter extends GenericExecuter {
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private List<Prestazione> prestazioni;
	public List<Prestazione> getPrestazioni() {return prestazioni;}
	public void setPrestazioni(List<Prestazione> prestazioni) {this.prestazioni = prestazioni;}

	private Long idCategoria;
	public Long getIdCategoria() {return idCategoria;}
	public void setIdCategoria(Long idCategoria) {this.idCategoria = idCategoria;}

	private SelectItem[] categorieItem;
	public SelectItem[] getCategorieItem() {return categorieItem;}
	public void setCategorieItem(SelectItem[] categorieItem) {this.categorieItem = categorieItem;}

	public ClassificaSocietaGaraExecuter () {
		try {
			checks4SelectedCompetizione();
			checks4SelectedGara();

			setPrestazioni(DbManagerFactory.getInstance().getPrestazioneDao().list(getSelectedGara()));
			setCategorieItem(
					getHelper()
						.getListaCategorieItem(
								DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(getSelectedGara())));
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.classifica.rigenerazione.ko");
		}
	}

	public void loadCategoria(ActionEvent event) {
		idCategoria = (Long) event.getComponent().getAttributes().get("idCategoria");
	} 
	public String ricaricaClassifica() {
		try {
			Categoria categoria = DbManagerFactory.getInstance().getCategoriaDao().get(idCategoria);
			setPrestazioni(DbManagerFactory.getInstance().getPrestazioneDao().list(getSelectedGara(),categoria));
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.classifica.rigenerazione.ko");
		}
		return "visualizzaClassificaGara";
	}
	
	protected GecompModelObject retrieve() throws GeCompException {
//		Non me ne faccio niente....
		return null;
	}
}
