package net.sb.gecomp.orm.presentation.classifiche;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.srv.orm.dao.ClassificaCompetizioneManager;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.srv.orm.presentation.classifiche.ClassificaGeneraleGara;

/**
 * 
 * @author 71862
 *
 */
public class TestClassificaGeneraleGara {
	public static void main(String[] args) {
		try {
//			Gara gara = DbManagerFactory.getInstance().getGaraDao().get(1l);
//			List<Prestazione> prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(gara);
//			
//			ClassificaGeneraleGara classificaGara = ClassificaCompetizioneManager.getInstance().getClassificaGeneraleGara(gara, prestazioni);
//			System.out.println(classificaGara.getClassificaGeneraleGara());
//			for (Prestazione p : classificaGara.getClassificaGeneraleGara()) {
//				System.out.println(
//						p.getIscrizione().getAtleta().getCognome() + " " + p.getIscrizione().getAtleta().getNome()
//						+ "->" + p.getValoreMisura());
//			}
		} catch (GeCompOrmException e) {
			e.printStackTrace();
		}
	}
}
