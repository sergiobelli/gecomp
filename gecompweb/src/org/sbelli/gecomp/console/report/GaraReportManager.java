package org.sbelli.gecomp.console.report;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sbelli.gecomp.console.bridges.view.ClassificaGaraView;
import org.sbelli.gecomp.console.bridges.view.GaraView;
import org.sbelli.gecomp.console.bridges.view.PrestazioneView;

public class GaraReportManager extends ReportManager {

	public GaraReportManager() {
		super();
		report = new HSSFWorkbook();
		titleStyle = getTitleStyle();
		headerStyle = getHeaderStyle();
		tableStyle = getTableStyle();
	}

	public HSSFWorkbook getReport(ClassificaGaraView classificaGaraView) {
		generateInformazioniSheet(classificaGaraView.getGara());
		generateClassificaGeneraleSheet(classificaGaraView.getClassificaGenerale());
		return report;
	}

	private void generateInformazioniSheet (GaraView gara) {
		int i = 0;
		//Informazioni
		HSSFSheet informazioniSheet = report.createSheet("Informazioni");

		HSSFCell informazioniTitle = informazioniSheet.createRow((short) i).createCell((short) 0);
		informazioniTitle.setCellValue(gara.getNome());
		informazioniTitle.setCellStyle(headerStyle);

		i++;
		HSSFRow informazioniHeader = informazioniSheet.createRow((short) i);

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Descrizione:");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(tableStyle);
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(gara.getDescrizione());
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(tableStyle);
		i++;

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Data :");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(tableStyle);
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(sdf.format(gara.getData()));
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(tableStyle);
		i++;

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Societa' Organizzatrice:");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(tableStyle);
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(gara.getCompetizione().getSocietaOrganizzatrice().getDenominazione());
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(tableStyle);
		i++;      
		//Informazioni
	}

	private void generateClassificaGeneraleSheet (List<PrestazioneView> prestazioniAssoluteInCompetizione) {
		int i = 0;
		//Classifica assoluta
		HSSFSheet classificaAssolutaSheet = report.createSheet("Classifica Assoluta");

		HSSFCell classificaAssolutaTitle = classificaAssolutaSheet.createRow((short) i).createCell((short) 0);
		classificaAssolutaTitle.setCellValue("Classifica Assoluta");
		classificaAssolutaTitle.setCellStyle(headerStyle);

		classificaAssolutaSheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 0).setCellStyle(headerStyle);
		
		classificaAssolutaSheet.getRow((short) i).createCell((short) 1).setCellValue("Atleta");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 1).setCellStyle(headerStyle);
		
		classificaAssolutaSheet.getRow((short) i).createCell((short) 2).setCellValue("Sesso");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 2).setCellStyle(headerStyle);
		
		classificaAssolutaSheet.getRow((short) i).createCell((short) 3).setCellValue("Anno Nascita");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 3).setCellStyle(headerStyle);
		
		classificaAssolutaSheet.getRow((short) i).createCell((short) 4).setCellValue("Categoria");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 4).setCellStyle(headerStyle);
		
		classificaAssolutaSheet.getRow((short) i).createCell((short) 5).setCellValue("Societa");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 5).setCellStyle(headerStyle);
		
		classificaAssolutaSheet.getRow((short) i).createCell((short) 6).setCellValue("Tipo Prstazione");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 6).setCellStyle(headerStyle);
		
		classificaAssolutaSheet.getRow((short) i).createCell((short) 7).setCellValue("Tempo");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 7).setCellStyle(headerStyle);
		
		i++;

		int pos = 1;
		for (PrestazioneView prest : prestazioniAssoluteInCompetizione) {

			classificaAssolutaSheet.createRow((short) i).createCell((short) 0).setCellValue(prest.getPosizione());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 0).setCellStyle(tableStyle);
			classificaAssolutaSheet.createRow((short) i).createCell((short) 1).setCellValue(prest.getIscrizione().getAtleta().getNominativo());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 1).setCellStyle(tableStyle);
			classificaAssolutaSheet.createRow((short) i).createCell((short) 2).setCellValue(prest.getIscrizione().getAtleta().getSesso());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 2).setCellStyle(tableStyle);
			classificaAssolutaSheet.createRow((short) i).createCell((short) 3).setCellValue(prest.getIscrizione().getAtleta().getAnnoNascita());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 3).setCellStyle(tableStyle);
			classificaAssolutaSheet.createRow((short) i).createCell((short) 4).setCellValue(prest.getCategoria().getNomeCategoria());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 4).setCellStyle(tableStyle);
			classificaAssolutaSheet.createRow((short) i).createCell((short) 5).setCellValue(prest.getIscrizione().getAtleta().getSocietaAppartenenza().getDenominazione());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 5).setCellStyle(tableStyle);
			classificaAssolutaSheet.createRow((short) i).createCell((short) 6).setCellValue(prest.getTipoPrestazione().getDescrizione());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 6).setCellStyle(tableStyle);
			classificaAssolutaSheet.createRow((short) i).createCell((short) 7).setCellValue(prest.getValoreMisuraFormatted());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 7).setCellStyle(tableStyle);
			
			i++;
			pos++;
		}
		//Classifica assoluta
	}

}
