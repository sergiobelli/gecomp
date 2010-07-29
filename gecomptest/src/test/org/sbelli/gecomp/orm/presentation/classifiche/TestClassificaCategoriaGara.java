package test.org.sbelli.gecomp.orm.presentation.classifiche;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;

public class TestClassificaCategoriaGara {
	public static void main(String[] args) {
		try {
			Gara gara = DbManagerFactory.getInstance().getGaraDao().get(1l);
			
			Categoria JPSM = DbManagerFactory.getInstance().getCategoriaDao().get(1l);
			List<Prestazione> prestazioniUomini = DbManagerFactory.getInstance().getPrestazioneDao().list(gara, JPSM);
			for (Prestazione p : prestazioniUomini) {
				System.out.println(
						p.getIscrizione().getAtleta().getNominativo()
						+" ("+p.getIscrizione().getAtleta().getAnnoNascita()+")"
						+" -> "+p.getValoreMisura()
				);	
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			Categoria JPSF = DbManagerFactory.getInstance().getCategoriaDao().get(2l);
			List<Prestazione> prestazioniDonne = DbManagerFactory.getInstance().getPrestazioneDao().list(gara, JPSF);
			for (Prestazione p : prestazioniDonne) {
				System.out.println(
						p.getIscrizione().getAtleta().getNominativo()
						+" ("+p.getIscrizione().getAtleta().getAnnoNascita()+")"
						+" -> "+p.getValoreMisura()
				);	
			}
			
			//ClassificaCategoriaGara classificaGara = ClassificaCompetizioneManager.getInstance().getClassificaCategoriaGara(categoria, gara, prestazioni);
			//System.out.println(classificaGara);
			
		} catch (GeCompOrmException e) {
			e.printStackTrace();
		}
	}
}
