package test.org.sbelli.gecomp.orm.presentation.classifiche;

import java.util.List;

import org.sbelli.gecomp.orm.dao.ClassificaCompetizioneManager;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaGeneraleGara;

public class TestClassificaGeneraleGara {
	public static void main(String[] args) {
		try {
			Gara gara = DbManagerFactory.getInstance().getGaraDao().get(1l);
			List<Prestazione> prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(gara);
			
			ClassificaGeneraleGara classificaGara = ClassificaCompetizioneManager.getInstance().getClassificaGeneraleGara(gara, prestazioni);
			System.out.println(classificaGara.getClassificaGeneraleGara());
			for (Prestazione p : classificaGara.getClassificaGeneraleGara()) {
				System.out.println(
						p.getIscrizione().getAtleta().getCognome() + " " + p.getIscrizione().getAtleta().getNome()
						+ "->" + p.getValoreMisura());
			}
		} catch (GeCompOrmException e) {
			e.printStackTrace();
		}
	}
}
