package net.sb.gecomp.web.report.sheet;

import java.util.HashMap;
import java.util.List;

import net.sb.gecomp.commons.model.view.IscrizioneView;
import net.sb.gecomp.commons.utils.Eval;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ElencoIscrittiSheetManager {

	public HSSFSheet addSheet(HSSFWorkbook report, HashMap<String,HSSFCellStyle> styles, List<IscrizioneView> iscritti) {
		int i;
		HSSFSheet sheet;
		HSSFCell title;
		int pos;
		//		Societa' classificate
		i = 0;
		sheet = report.createSheet("Elenco Iscritti");

		title = sheet.createRow((short) i).createCell((short) 0);
		title.setCellValue("Elenco Iscritti");
		title.setCellStyle(styles.get("headerStyle"));

		sheet.createRow((short) i).createCell((short) 0).setCellValue("Pettorale");
		sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 1).setCellValue("Atleta");
		sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 2).setCellValue("Sesso");
		sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 3).setCellValue("Anno Nascita");
		sheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 4).setCellValue("Societa");
		sheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 5).setCellValue("Competitivo");
		sheet.getRow((short) i).getCell((short) 5).setCellStyle(styles.get("headerStyle"));

		i++;
		
		for (IscrizioneView o : iscritti) {

			sheet.createRow((short) i).createCell((short) 0).setCellValue(Eval.isNotNull(o.getNumeroPettorale()) ? o.getNumeroPettorale().toString() : "n.d.");
			sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 1).setCellValue(o.getAtleta().getNominativo());
			sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 2).setCellValue(o.getAtleta().getSesso());
			sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 3).setCellValue(o.getAtleta().getAnnoNascita());
			sheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 4).setCellValue(o.getAtleta().getSocietaAppartenenza().getDenominazione());
			sheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 5).setCellValue(o.getCompetitivo().equals(Boolean.TRUE) ? "SI" : "NO");
			sheet.getRow((short) i).getCell((short) 5).setCellStyle(styles.get("tableStyle"));

			i++;
			
		}
		
		return sheet;
	}
	
}
