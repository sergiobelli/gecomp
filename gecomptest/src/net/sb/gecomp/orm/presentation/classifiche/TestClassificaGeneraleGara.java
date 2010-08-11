package net.sb.gecomp.orm.presentation.classifiche;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.model.Prestazione;
import net.sb.gecomp.orm.dao.ClassificaCompetizioneManager;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.orm.presentation.classifiche.ClassificaGeneraleGara;


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
