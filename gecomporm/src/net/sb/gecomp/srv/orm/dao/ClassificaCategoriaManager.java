package net.sb.gecomp.srv.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.CategoriaGaraAssoluta;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.presentation.classifiche.ClassificaCategoriaCompetizione;
import net.sb.gecomp.srv.orm.presentation.classifiche.ClassificaCategoriaGara;

import org.apache.log4j.Logger;


/**
 * @deprecated tutte queste attivita' devono essere fatte a front-end
 */
public class ClassificaCategoriaManager {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
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
			GeCompExceptionManager.traceException(logger, e);
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
			GeCompExceptionManager.traceException(logger, e);
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
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return classificaGara;
	}
	
}
