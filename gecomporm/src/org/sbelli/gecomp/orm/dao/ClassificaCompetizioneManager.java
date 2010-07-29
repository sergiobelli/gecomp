package org.sbelli.gecomp.orm.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaCategoriaCompetizione;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaCompetizione;
import org.sbelli.gecomp.orm.presentation.classifiche.PrestazioneInCompetizione;

/**
 * @author sbelli
 * @deprecated tutte queste attivita' devono essere fatte a front-end
 */
public class ClassificaCompetizioneManager {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private static ClassificaCompetizioneManager instance;
	private ClassificaCompetizioneManager() {}
	public static ClassificaCompetizioneManager getInstance() {
		if (instance == null) {
			instance = new ClassificaCompetizioneManager();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param competizione
	 * @return
	 */
	public ClassificaCompetizione getClassificaCompetizione(Competizione competizione) {
		
		ClassificaCompetizione classificaCompetizione = null;
		try {
			
			logger.info("");
			logger.info("Generazione delle classifiche per la competizione = " + competizione);
			
			classificaCompetizione = new ClassificaCompetizione();
			
			/**
			 * Nome della competizione
			 */
			classificaCompetizione.setCompetizione(competizione);
			logger.debug("Competizione = " + competizione);
			
			/**
			 * Lista delle categorie ammesse alla competizione
			 */
			List<Categoria> categorieDellaCompetizione = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(competizione);
			classificaCompetizione.setCategorie(categorieDellaCompetizione);
			logger.debug("Categorie = " + categorieDellaCompetizione);
			
			/**
			 * Lista delle gare della competizione
			 */
			List<Gara> gareDellaCompetizione = DbManagerFactory.getInstance().getGaraDao().list(competizione);
			classificaCompetizione.setGare(gareDellaCompetizione);
			logger.debug("Gare = " + gareDellaCompetizione);
			
			/**
			 * Lista degli atleti iscritti/partecipanti alla competizione
			 */
			List<Atleta> atletiPartecipanti = DbManagerFactory.getInstance().getAtletaDao().list(competizione);
			classificaCompetizione.setAtleti(atletiPartecipanti);
			logger.debug("Atleti = " + atletiPartecipanti);
			
			/**
			 * Lista delle prestazioni della competizione
			 */
			final List<Prestazione> prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(competizione);
			classificaCompetizione.setPrestazioni(prestazioni);
			logger.debug("Prestazioni = " + prestazioni);
			
			/**
			 * Classifica assoluta della competizione
			 */
			classificaCompetizione.setClassificaAssolutaCompetizione(new ClassificaAssolutaManager().getClassificaAssoluta(atletiPartecipanti, competizione, prestazioni));
			logger.debug("Classifica Assoluta = " + classificaCompetizione.getClassificaAssolutaCompetizione());
			
			/**
			 * Classifiche assolute delle gare della competizione
			 */
			Hashtable<Gara, List<Prestazione>> classificheAssoluteGare = new Hashtable<Gara, List<Prestazione>>();
			for (Gara gara : gareDellaCompetizione) {
				classificheAssoluteGare.put(gara, new ClassificaAssolutaManager().getClassificaAssoluta(gara, prestazioni));
			}
			classificaCompetizione.setClassificheAssoluteGare(classificheAssoluteGare);
			logger.debug("Classifiche Assolute di Gara = " + classificaCompetizione.getClassificheAssoluteGare());
			
			/**
			 * Classifiche di categoria
			 */
			Hashtable<Categoria, ClassificaCategoriaCompetizione> classificheCompetizione = new Hashtable<Categoria, ClassificaCategoriaCompetizione>();
			for (Categoria categoria : categorieDellaCompetizione) {
				classificheCompetizione.put(
						categoria, 
						new ClassificaCategoriaManager().getClassificaCategoriaCompetizione(categoria, competizione, gareDellaCompetizione, prestazioni));
			}
			classificaCompetizione.setClassificheCompetizione(classificheCompetizione);
			logger.debug("Classifiche di Categoria = " + classificheCompetizione);
			
			logger.debug("classificaCompetizione = " + classificaCompetizione);			
		} catch (Exception ex) {
			GeCompExceptionManager.manageException(logger, ex);			
		}
		
		logger.info("Classifiche per la competizione (" + competizione + ") generate correttamente ! ");
		logger.info("");

		return classificaCompetizione;
		
	}
	
	/**
	 * 
	 * @param disordinata
	 * @return
	 */
	public static final List<Prestazione> ordina(final List<Prestazione> disordinata) {
		List<Prestazione> ordinata = new ArrayList<Prestazione>();
		List<Prestazione> tmpDisordinata = new ArrayList<Prestazione>();
		tmpDisordinata.addAll(disordinata);
		
		while (tmpDisordinata.size() > 0) {
			Prestazione first = ClassificaCompetizioneManager.getFirst(tmpDisordinata);
			ordinata.add(first);
			tmpDisordinata.remove(first);
		}
		return ordinata;
	}
	/**
	 * 
	 * @param disordinata
	 * @return
	 */
	public static final List<PrestazioneInCompetizione> ordinaCompetizione(final List<PrestazioneInCompetizione> disordinata) {
		List<PrestazioneInCompetizione> ordinata = new ArrayList<PrestazioneInCompetizione>();
		List<PrestazioneInCompetizione> tmpDisordinata = new ArrayList<PrestazioneInCompetizione>();
		tmpDisordinata.addAll(disordinata);
		
		while (tmpDisordinata.size() > 0) {
			PrestazioneInCompetizione first = ClassificaCompetizioneManager.getFirstInCompetizione(tmpDisordinata);
			ordinata.add(first);
			tmpDisordinata.remove(first);
		}
		
		return ordinata;
	}	
	
	/**
	 * 
	 * @param prestazioni
	 * @return
	 */
	public static final Prestazione getFirst(List<Prestazione> prestazioni) {
		Prestazione min = null;
		for (Prestazione prestazione : prestazioni) {
			if (min == null) {
				min = prestazione;
			} else {
				if (min.getValoreMisura() > prestazione.getValoreMisura()) {
					min = prestazione;
				}
			}
		}
		return min;
	}
	
	public static final PrestazioneInCompetizione getFirstInCompetizione(List<PrestazioneInCompetizione> prestazioni) {
		PrestazioneInCompetizione min = null;
		for (PrestazioneInCompetizione prestazione : prestazioni) {
			if (min == null) {
				min = prestazione;
			} else {
				if (min.getValoreMisuraTotale() > prestazione.getValoreMisuraTotale()) {
					min = prestazione;
				}
			}
		}
		return min;
	}
	
}
