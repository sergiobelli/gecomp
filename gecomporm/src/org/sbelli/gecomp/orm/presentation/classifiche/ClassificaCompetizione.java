package org.sbelli.gecomp.orm.presentation.classifiche;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;

import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;

/**
 * 
 * @author S.BELLI
 */
public class ClassificaCompetizione implements Serializable {

	private static final long serialVersionUID = 292866104169652816L;
	
	/**
	 * Nome della competizione
	 */
	private Competizione competizione;
	public Competizione getCompetizione() { return competizione; }
	public void setCompetizione(Competizione competizione) { this.competizione = competizione; }
	
	/**
	 * Lista delle categorie ammesse alla competizione
	 */
	private List<Categoria> categorie;
	public List<Categoria> getCategorie() { return categorie; }
	public void setCategorie(List<Categoria> categorie) { this.categorie = categorie; }
	
	/**
	 * Lista delle gare della competizione
	 */
	private List<Gara> gare;
	public List<Gara> getGare() { return gare; }
	public void setGare(List<Gara> gare) { this.gare = gare; }
	
	/**
	 * Lista degli atleti iscritti alla gara
	 */
	private List<Atleta> atleti;
	public List<Atleta> getAtleti() { return atleti; }
	public void setAtleti(List<Atleta> atleti) { this.atleti = atleti; }
	
	/**
	 * Elenco delle prestazioni generali nella competizione
	 */
	private List<Prestazione> prestazioni;
	public List<Prestazione> getPrestazioni() {return prestazioni;}
	public void setPrestazioni(List<Prestazione> prestazioni) {this.prestazioni = prestazioni;}
	
	/**
	 * Classifica assoluta della competizione
	 */
	private List<PrestazioneInCompetizione> classificaAssolutaCompetizione;
	public List<PrestazioneInCompetizione> getClassificaAssolutaCompetizione() { return classificaAssolutaCompetizione; }
	public void setClassificaAssolutaCompetizione(List<PrestazioneInCompetizione> classificaAssolutaCompetizione) { this.classificaAssolutaCompetizione = classificaAssolutaCompetizione; }
	
	/**
	 * Classifiche assolute delle varie gare della competizione
	 */
	private Hashtable<Gara, List<Prestazione>> classificheAssoluteGare;
	public Hashtable<Gara, List<Prestazione>> getClassificheAssoluteGare() { return classificheAssoluteGare; }
	public void setClassificheAssoluteGare(Hashtable<Gara, List<Prestazione>> classificheAssoluteGare) { this.classificheAssoluteGare = classificheAssoluteGare; }
	
	/**
	 * Classifiche di categoria
	 */
	private Hashtable<Categoria, ClassificaCategoriaCompetizione> classificheCompetizione;
	public Hashtable<Categoria, ClassificaCategoriaCompetizione> getClassificheCompetizione() { return classificheCompetizione; }
	public void setClassificheCompetizione(Hashtable<Categoria, ClassificaCategoriaCompetizione> classificheCompetizione) { this.classificheCompetizione = classificheCompetizione; }
	
	/**
	 * Classifica di Societa'
	 */
	private List<PrestazioneSocieta> classificaDiSocieta;
	public List<PrestazioneSocieta> getClassificaDiSocieta() { return classificaDiSocieta; }
	public void setClassificaXSocieta(List<PrestazioneSocieta> classificaDiSocieta) { this.classificaDiSocieta = classificaDiSocieta; }
	
}
