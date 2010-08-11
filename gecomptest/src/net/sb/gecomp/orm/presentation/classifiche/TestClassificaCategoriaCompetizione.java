package net.sb.gecomp.orm.presentation.classifiche;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.model.Categoria;
import net.sb.gecomp.model.Competizione;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.model.Iscrizione;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;


public class TestClassificaCategoriaCompetizione {
	public static void main(String[] args) {
		try {
			
			long start = System.currentTimeMillis();
			
			MyClassificaCompetizione grandPrix2010 = 
				new MyClassificaCompetizione(DbManagerFactory.getInstance().getCompetizioneDao().get(1l));
			
			
			
			
//			Categoria JPSM = DbManagerFactory.getInstance().getCategoriaDao().get(1l);
//			Competizione competizione = DbManagerFactory.getInstance().getCompetizioneDao().get(1l);
//			List<Gara> gare = DbManagerFactory.getInstance().getGaraDao().list(competizione);
//			List<Prestazione> prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(competizione, JPSM);
//			
//			ClassificaCompetizione cc = ClassificaCompetizioneManager.getInstance().getClassificaCompetizione(competizione);
//			System.out.println(cc);
//			
////			ClassificaCategoriaCompetizione classificaCompetizione = ClassificaCompetizioneManager.getInstance().getClassificaCategoriaCompetizione(JPSM, competizione, gare, prestazioni);
////			System.out.println(classificaCompetizione);
			
			long end = System.currentTimeMillis();
			
			System.out.println("time taken = " + (end - start));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}

class MyClassificaCompetizione {
	public Competizione competizione;
	public List<Gara> gare;
	public List<Iscrizione> iscritti;
	public List<Categoria> categorie;
	
	public MyClassificaCompetizione(Competizione competizione) throws GeCompOrmException {
		this.gare = DbManagerFactory.getInstance().getGaraDao().list(competizione);
		this.iscritti = DbManagerFactory.getInstance().getIscrizioneDao().list(competizione);
		this.categorie = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(competizione);
		
		
	}
}