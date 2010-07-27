package org.sbelli.gecomp.console.report;

import java.util.HashMap;
import java.util.List;

import net.sb.gecomp.utils.Eval;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sbelli.gecomp.console.bridges.view.CategoriaView;
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
		generateCategorieSheet(classificaGaraView.getCategorie());
		generateClassificaGeneraleSheet(classificaGaraView.getClassificaGenerale());
		generateClassificheDiCategoriaSheet(classificaGaraView.getClassificheCategorie());
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

	private void generateClassificaGeneraleSheet (List<PrestazioneView> prestazioni) {
		int i = 0;
		//Classifica assoluta
		HSSFSheet sheet = report.createSheet("Classifica Assoluta");

		HSSFCell classificaAssolutaTitle = sheet.createRow((short) i).createCell((short) 0);
		classificaAssolutaTitle.setCellValue("Classifica Assoluta");
		classificaAssolutaTitle.setCellStyle(headerStyle);

		sheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
		sheet.getRow((short) i).getCell((short) 0).setCellStyle(headerStyle);
		
		sheet.getRow((short) i).createCell((short) 1).setCellValue("Atleta");
		sheet.getRow((short) i).getCell((short) 1).setCellStyle(headerStyle);
		
		sheet.getRow((short) i).createCell((short) 2).setCellValue("Sesso");
		sheet.getRow((short) i).getCell((short) 2).setCellStyle(headerStyle);
		
		sheet.getRow((short) i).createCell((short) 3).setCellValue("Anno Nascita");
		sheet.getRow((short) i).getCell((short) 3).setCellStyle(headerStyle);
		
		sheet.getRow((short) i).createCell((short) 4).setCellValue("Categoria");
		sheet.getRow((short) i).getCell((short) 4).setCellStyle(headerStyle);
		
		sheet.getRow((short) i).createCell((short) 5).setCellValue("Societa");
		sheet.getRow((short) i).getCell((short) 5).setCellStyle(headerStyle);
		
		sheet.getRow((short) i).createCell((short) 6).setCellValue("Tipo Prstazione");
		sheet.getRow((short) i).getCell((short) 6).setCellStyle(headerStyle);
		
		sheet.getRow((short) i).createCell((short) 7).setCellValue("Tempo");
		sheet.getRow((short) i).getCell((short) 7).setCellStyle(headerStyle);
		
		i++;

		int pos = 1;
		for (PrestazioneView prest : prestazioni) {

			sheet.createRow((short) i).createCell((short) 0).setCellValue(prest.getPosizione());
			sheet.getRow((short) i).getCell((short) 0).setCellStyle(tableStyle);
			sheet.createRow((short) i).createCell((short) 1).setCellValue(prest.getIscrizione().getAtleta().getNominativo());
			sheet.getRow((short) i).getCell((short) 1).setCellStyle(tableStyle);
			sheet.createRow((short) i).createCell((short) 2).setCellValue(prest.getIscrizione().getAtleta().getSesso());
			sheet.getRow((short) i).getCell((short) 2).setCellStyle(tableStyle);
			sheet.createRow((short) i).createCell((short) 3).setCellValue(prest.getIscrizione().getAtleta().getAnnoNascita());
			sheet.getRow((short) i).getCell((short) 3).setCellStyle(tableStyle);
			sheet.createRow((short) i).createCell((short) 4).setCellValue(prest.getCategoria().getNomeCategoria());
			sheet.getRow((short) i).getCell((short) 4).setCellStyle(tableStyle);
			sheet.createRow((short) i).createCell((short) 5).setCellValue(prest.getIscrizione().getAtleta().getSocietaAppartenenza().getDenominazione());
			sheet.getRow((short) i).getCell((short) 5).setCellStyle(tableStyle);
			sheet.createRow((short) i).createCell((short) 6).setCellValue(prest.getTipoPrestazione().getDescrizione());
			sheet.getRow((short) i).getCell((short) 6).setCellStyle(tableStyle);
			sheet.createRow((short) i).createCell((short) 7).setCellValue(prest.getValoreMisuraFormatted());
			sheet.getRow((short) i).getCell((short) 7).setCellStyle(tableStyle);
			
			i++;
			pos++;
		}
		//Classifica assoluta
	}

	private void generateClassificheDiCategoriaSheet (HashMap<CategoriaView, List<PrestazioneView>> classificheCategorie) {
		int i = 0;
		//Classifiche di Categoria
		for (CategoriaView categoria : classificheCategorie.keySet()) {

			i = 0;

			HSSFSheet sheet = report.createSheet(categoria.getNomeCategoria());

			HSSFCell classificaCategoriaCompetizioneTitle = sheet.createRow((short) i).createCell((short) 0);
			classificaCategoriaCompetizioneTitle.setCellValue("Classifica Categoria:" + categoria.getNomeCategoria());
			classificaCategoriaCompetizioneTitle.setCellStyle(headerStyle);

			sheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
			sheet.getRow((short) i).getCell((short) 0).setCellStyle(headerStyle);

			sheet.getRow((short) i).createCell((short) 1).setCellValue("Atleta");
			sheet.getRow((short) i).getCell((short) 1).setCellStyle(headerStyle);

			sheet.getRow((short) i).createCell((short) 2).setCellValue("Sesso");
			sheet.getRow((short) i).getCell((short) 2).setCellStyle(headerStyle);

			sheet.getRow((short) i).createCell((short) 3).setCellValue("Anno Nascita");
			sheet.getRow((short) i).getCell((short) 3).setCellStyle(headerStyle);

			sheet.getRow((short) i).createCell((short) 4).setCellValue("Categoria");
			sheet.getRow((short) i).getCell((short) 4).setCellStyle(headerStyle);

			sheet.getRow((short) i).createCell((short) 5).setCellValue("Societa");
			sheet.getRow((short) i).getCell((short) 5).setCellStyle(headerStyle);

			sheet.getRow((short) i).createCell((short) 6).setCellValue("Tipo Prstazione");
			sheet.getRow((short) i).getCell((short) 6).setCellStyle(headerStyle);

			sheet.getRow((short) i).createCell((short) 7).setCellValue("Tempo");
			sheet.getRow((short) i).getCell((short) 7).setCellStyle(headerStyle);
			i++;

			List<PrestazioneView> prestazioni = classificheCategorie.get(categoria);
			if (Eval.isNotEmpty(prestazioni)) {
				for (PrestazioneView prest : prestazioni) {
					sheet.createRow((short) i).createCell((short) 0).setCellValue(prest.getPosizione());
					sheet.getRow((short) i).getCell((short) 0).setCellStyle(tableStyle);
					sheet.createRow((short) i).createCell((short) 1).setCellValue(prest.getIscrizione().getAtleta().getNominativo());
					sheet.getRow((short) i).getCell((short) 1).setCellStyle(tableStyle);
					sheet.createRow((short) i).createCell((short) 2).setCellValue(prest.getIscrizione().getAtleta().getSesso());
					sheet.getRow((short) i).getCell((short) 2).setCellStyle(tableStyle);
					sheet.createRow((short) i).createCell((short) 3).setCellValue(prest.getIscrizione().getAtleta().getAnnoNascita());
					sheet.getRow((short) i).getCell((short) 3).setCellStyle(tableStyle);
					sheet.createRow((short) i).createCell((short) 4).setCellValue(prest.getCategoria().getNomeCategoria());
					sheet.getRow((short) i).getCell((short) 4).setCellStyle(tableStyle);
					sheet.createRow((short) i).createCell((short) 5).setCellValue(prest.getIscrizione().getAtleta().getSocietaAppartenenza().getDenominazione());
					sheet.getRow((short) i).getCell((short) 5).setCellStyle(tableStyle);
					sheet.createRow((short) i).createCell((short) 6).setCellValue(prest.getTipoPrestazione().getDescrizione());
					sheet.getRow((short) i).getCell((short) 6).setCellStyle(tableStyle);
					sheet.createRow((short) i).createCell((short) 7).setCellValue(prest.getValoreMisuraFormatted());
					sheet.getRow((short) i).getCell((short) 7).setCellStyle(tableStyle);

					i++;
				}
			}
		}
		//Classifiche di Categoria
	}
	
}
