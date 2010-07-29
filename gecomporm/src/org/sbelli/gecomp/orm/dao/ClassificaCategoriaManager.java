package org.sbelli.gecomp.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.CategoriaGara;
import org.sbelli.gecomp.orm.model.CategoriaGaraAssoluta;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaCategoriaCompetizione;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaCategoriaGara;

/**
 * @author sbelli
 * @deprecated tutte queste attivita' devono essere fatte a front-end
 */
public class ClassificaCategoriaManager {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	/**
	 * 
	 * @param categoria
	 * @param competizione
	 * @param gareDellaCompetizione
	 * @param prestazioniDellaCompetizione
	 * @return
	 * @throws GeCompOrmException
	 */
	public ClassificaCategoriaCompetizione getClassificaCategoriaCompetizione(
			Categoria categoria, 
			Competizione competizione, 
			List<Gara> gareDellaCompetizione,
			List<Prestazione> prestazioniDellaCompetizione) throws GeCompOrmException {
		
		ClassificaCategoriaCompetizione classificaCategoriaCompetizione = null;
		try {
			classificaCategoriaCompetizione = new ClassificaCategoriaCompetizione();
			classificaCategoriaCompetizione.setCategoria(categoria);
			classificaCategoriaCompetizione.setCompetizione(competizione);
			
			for (Gara garaDellaCompetizione : gareDellaCompetizione) {
				classificaCategoriaCompetizione
					.addClassificaGara(
							getClassificaCategoriaGara(
									categoria, 
									garaDellaCompetizione, 
									prestazioniDellaCompetizione));
			}
			
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return classificaCategoriaCompetizione;
	}
	
	/**
	 * 
	 * @param categoria
	 * @param gara
	 * @param prestazioniDellaCompetizione
	 * @return
	 * @throws GeCompOrmException
	 */
	public ClassificaCategoriaGara getClassificaCategoriaGara(
			CategoriaGara categoriaGara, 
			List<Prestazione> prestazioniDellaCompetizione) throws GeCompOrmException {
		
		ClassificaCategoriaGara classificaGara = null;
		try {
			
			List<Prestazione> prestazioniCategoriaGara = new ArrayList<Prestazione>();
			for (Prestazione prestazione : prestazioniDellaCompetizione) {
				if (prestazione.getIscrizione().getGara().equals(categoriaGara.getGara())
						&& categoriaGara.getCategoria().getSesso().equals(prestazione.getIscrizione().getAtleta().getSesso())) {
					
					if (categoriaGara instanceof CategoriaGaraAssoluta) {
						if (prestazioniCategoriaGara.size() < ((CategoriaGaraAssoluta)categoriaGara).getNumeroPosizioni()) {
							prestazioniCategoriaGara.add(prestazione);
						}
					} else if (categoriaGara.getCategoria().getAnniAppartenenza().contains(Integer.valueOf(prestazione.getIscrizione().getAtleta().getAnnoNascita()))) {
						prestazioniCategoriaGara.add(prestazione);
					}
				}
			}

			classificaGara = new ClassificaCategoriaGara(categoriaGara.getGara(), categoriaGara.getCategoria(), prestazioniCategoriaGara);
			
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return classificaGara;
	}
	
	public ClassificaCategoriaGara getClassificaCategoriaGara(
			Categoria categoria,
			Gara gara,
			List<Prestazione> prestazioniDellaCompetizione) throws GeCompOrmException {
		
		ClassificaCategoriaGara classificaGara = null;
		try {
			
			List<Prestazione> prestazioniCategoriaGara = new ArrayList<Prestazione>();
			for (Prestazione prestazione : prestazioniDellaCompetizione) {
				if (prestazione.getIscrizione().getGara().equals(gara)
						&& categoria.getSesso().equals(prestazione.getIscrizione().getAtleta().getSesso())
						&& categoria.getAnniAppartenenza().contains(Integer.valueOf(prestazione.getIscrizione().getAtleta().getAnnoNascita()))) {
					prestazioniCategoriaGara.add(prestazione);
				}
			}

			classificaGara = new ClassificaCategoriaGara(gara, categoria, prestazioniCategoriaGara);
			
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return classificaGara;
	}
	
}
