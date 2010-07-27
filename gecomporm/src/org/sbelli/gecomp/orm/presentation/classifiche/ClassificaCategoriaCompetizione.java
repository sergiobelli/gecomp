package org.sbelli.gecomp.orm.presentation.classifiche;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.orm.dao.ClassificaCompetizioneManager;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Prestazione;


public class ClassificaCategoriaCompetizione implements IClassifica {

	private static final long serialVersionUID = -7253161299223789162L;
	
	private Categoria categoria;
	public Categoria getCategoria() { return categoria; }
	public void setCategoria(Categoria categoria) { this.categoria = categoria; }
	
	private Competizione competizione;
	public Competizione getCompetizione() { return competizione; }
	public void setCompetizione(Competizione competizione) { this.competizione = competizione; }
	
	private List<Prestazione> classificaCompetizione;
	public List<Prestazione> getClassificaCompetizione() { return classificaCompetizione; }
	public void setClassificaCompetizione(List<Prestazione> classificaCompetizione) { this.classificaCompetizione = classificaCompetizione; }
	
	private List<ClassificaCategoriaGara> classificheGare;
	public List<ClassificaCategoriaGara> getClassificheGare() { return classificheGare; }
	public void setClassificheGare(List<ClassificaCategoriaGara> classificheGare) { this.classificheGare = classificheGare; }
	public void addClassificaGara(ClassificaCategoriaGara classificaGara) {
		
		//Aggiorno l'elenco delle gare appartenenti alla competizione...
		if (Eval.isNull(getClassificheGare())) { setClassificheGare(new ArrayList<ClassificaCategoriaGara>()); }
		getClassificheGare().add(classificaGara);
		
		
		//Aggiorno la classifica finale della competizione...
		if (Eval.isNull(getClassificaCompetizione())) { 
			//Se si tratta del primo inserimento allora la classifica della competizione corrisponde a quello della singola gara
			setClassificaCompetizione(new ArrayList<Prestazione>());
			
			for (Prestazione prestazione : classificaGara.getClassificaGara()) {
				
				Prestazione tmp = new Prestazione();
				tmp.setIdPrestazione(prestazione.getIdPrestazione());
				tmp.getIscrizione().setAtleta(prestazione.getIscrizione().getAtleta());
				tmp.getIscrizione().setGara(prestazione.getIscrizione().getGara());
				
				long vm = prestazione.getValoreMisura();
				tmp.setValoreMisura(vm);
				
				getClassificaCompetizione().add(tmp);	
			}
		} else { //Altrimenti effettuo la somma delle prestazioni per ogni atleta...
			for (Prestazione prestazioneCompetizione : getClassificaCompetizione()) { //Per ogni prestazione della competizione...
				for (Prestazione prestazioneGara : classificaGara.getClassificaGara()) { //Sommo il tempo ottenuto nell'ennesima gara della competizione stessa...
					if (prestazioneGara.getIscrizione().getAtleta().equals(prestazioneCompetizione.getIscrizione().getAtleta())) {
						prestazioneCompetizione.setValoreMisura(prestazioneCompetizione.getValoreMisura() + prestazioneGara.getValoreMisura());
					}
				}
			}			
		}
		
		//Ordino la classifica generata...
		classificaCompetizione = ClassificaCompetizioneManager.ordina(classificaCompetizione);
				
	}
}
