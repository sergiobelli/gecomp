package net.sb.gecomp.orm;

import java.util.Date;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.model.Properties;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;


public class InsertData {

	/**
	 * @param args
	 * @throws GeCompOrmException 
	 */
	public static void main(String[] args) throws GeCompOrmException {

//		insertSocieta();
//		insertAtleti();
//		insertCategorie();
//		insertCompetizioni();
//		insertGare();
		insertIscrizioni();
//		insertPrestazioni();
//		insertCategoriaGara();
//		insertProperties();
	}

	private static void insertSocieta() throws GeCompOrmException {
		for (int i = 0; i < 20; i++) {
			Societa societa = new Societa();
			societa.setDenominazione("SOCIETA_" + i);
			societa.setCodiceFidal("VC" + i);
			DbManagerFactory.getInstance().getSocietaDao().insert(societa);
		}
	}

	private static void insertAtleti() throws GeCompOrmException {
		
		int numeroAtleta = 0;
		List<Societa> socs = DbManagerFactory.getInstance().getSocietaDao().list();
		for (Societa societa : socs) {
			for (int i = 0; i < 5; i++) {
				Atleta atleta = new Atleta();
				atleta.setCognome("ATLETA_" + numeroAtleta);
				atleta.setNome("ATLETA_" + numeroAtleta);
				atleta.setSesso("M");
				atleta.setAnnoNascita("19" + new Double(Math.random() * 100).longValue());
				atleta.setSocietaAppartenenza(societa);				
				DbManagerFactory.getInstance().getAtletaDao().insert(atleta);
				numeroAtleta++;
			}
		}
		
	}

	private static void insertCategorie() throws GeCompOrmException {
		
		for (int i = 1; i < 10; i++) {
			Categoria categoria = new Categoria();
			categoria.setNomeCategoria("Categoria_" + i);
			categoria.setAnnoPartenza("2008");
			categoria.setAnnoFine("2009");
			categoria.setSesso("M");
			
			DbManagerFactory.getInstance().getCategoriaDao().insert(categoria);
		}
		
	}
	
	private static void insertCompetizioni() throws GeCompOrmException {
		
		for (int i = 0; i < 5; i++) {
			Competizione competizione = new Competizione();
			competizione.setNome("Competizione_" + i);
			competizione.setDescrizione("Competizione_" + i);
			competizione.setDataInizio(new Date(System.currentTimeMillis()));
			competizione.setDataFine(new Date(System.currentTimeMillis()));
			competizione.setSocietaOrganizzatrice(DbManagerFactory.getInstance().getSocietaDao().list().iterator().next());
			
			DbManagerFactory.getInstance().getCompetizioneDao().insert(competizione);
		}
	}
	
	private static void insertGare() throws GeCompOrmException {
		
		List<Competizione> comps = DbManagerFactory.getInstance().getCompetizioneDao().list();
		for (Competizione comp : comps) {
			for (int i = 0; i < 5; i++) {
				Gara gara = new Gara();
				gara.setNome("Gara_" + i);
				gara.setDescrizione("Gara_" + i);
				gara.setData(new Date(System.currentTimeMillis()));
				gara.setCompetizione(comp);
				DbManagerFactory.getInstance().getGaraDao().insert(gara);
			}
		}
		
	}
	
	private static void insertIscrizioni() throws GeCompOrmException {
		
		List<Gara> gare = DbManagerFactory.getInstance().getGaraDao().list();
		List<Atleta> atleti = DbManagerFactory.getInstance().getAtletaDao().list();
		
		for (Atleta atleta : atleti) {
			for (Gara gara : gare) {
				Iscrizione iscrizione = new Iscrizione();
				iscrizione.setAtleta(atleta);
				iscrizione.setGara(gara);
				DbManagerFactory.getInstance().getIscrizioneDao().insert(iscrizione);
			}
		}
		
	}
	
	private static void insertPrestazioni() throws GeCompOrmException {
		List<Iscrizione> iscrizioni = DbManagerFactory.getInstance().getIscrizioneDao().list();
		
		TipoPrestazione tipoPrestazione = DbManagerFactory.getInstance().getTipoPrestazioneDao().list().get(0);
		TipoMisura tipoMisura = DbManagerFactory.getInstance().getTipoMisuraDao().list().get(0);
		
		for (Iscrizione iscrizione : iscrizioni) {
			Prestazione prestazione = new Prestazione();
			prestazione.setIscrizione(iscrizione);
			prestazione.setValoreMisura(new Double(Math.random() * 10000000).longValue());
			prestazione.setTipoPrestazione(tipoPrestazione);
			prestazione.setTipoMisura(tipoMisura);
			DbManagerFactory.getInstance().getPrestazioneDao().insert(prestazione);
		}
	}
	
	private static void insertCategoriaGara() throws GeCompOrmException {
		
		List<Competizione> competizioni = DbManagerFactory.getInstance().getCompetizioneDao().list();
		List<Categoria> categorie = DbManagerFactory.getInstance().getCategoriaDao().list();
		
		for (Competizione competizione : competizioni) {
			List<Gara> gare = DbManagerFactory.getInstance().getGaraDao().list(competizione);
			for (Gara gara : gare) {
				for (Categoria categoria : categorie) {
					CategoriaGara categoriaGara = new CategoriaGara();
					categoriaGara.setCategoria(categoria);
					categoriaGara.setGara(gara);
					DbManagerFactory.getInstance().getCategoriaGaraDao().insert(categoriaGara);
				}
			}
		}
	}

	private static void insertProperties() throws GeCompOrmException {
		for (int i = 0; i < 5; i++) {
			Properties prop = new Properties();
			prop.setChiave("CHIAVE_"+i);
			prop.setValore("VALORE_"+i);
			DbManagerFactory.getInstance().getPropertiesDao().insert(prop);
		}
		
  }
	
}
