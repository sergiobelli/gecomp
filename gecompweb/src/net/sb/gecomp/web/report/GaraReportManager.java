package net.sb.gecomp.web.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.report.sheet.ElencoIscrittiSheetManager;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sbelli.gecomp.console.bridges.view.CategoriaView;
import org.sbelli.gecomp.console.bridges.view.ClassificaGaraView;
import org.sbelli.gecomp.console.bridges.view.ClassificaSocietaView;
import org.sbelli.gecomp.console.bridges.view.GaraView;
import org.sbelli.gecomp.console.bridges.view.IscrizioneView;
import org.sbelli.gecomp.console.bridges.view.PrestazioneView;
import org.sbelli.gecomp.orm.model.Societa;

public class GaraReportManager extends ReportManager {

	public GaraReportManager() {
		super();
		report = new HSSFWorkbook();

		if (Eval.isNull(styles)) {
			styles = new HashMap<String, HSSFCellStyle>();
			styles.put("titleStyle", getTitleStyle());
			styles.put("headerStyle", getHeaderStyle());
			styles.put("tableStyle", getTableStyle());
		}
	}

	public HSSFWorkbook getReport(ClassificaGaraView classificaGaraView) {
		generateInformazioniSheet(classificaGaraView.getGara());
		generateCategorieSheet(classificaGaraView.getCategorie());
		generateIscrittiSheet(classificaGaraView.getIscritti());
		generateClassificaGeneraleSheet(classificaGaraView.getClassificaGenerale());
		generateClassificheDiCategoriaSheet(classificaGaraView.getClassificheCategorie());
		generateClassificheDiSocietaSheet(classificaGaraView.getClassificaSocieta());
		return report;
	}



	private void generateIscrittiSheet(List<IscrizioneView> iscritti) {
		new ElencoIscrittiSheetManager().addSheet(report, styles, iscritti);
	}

	private void generateClassificheDiSocietaSheet(
			ClassificaSocietaView classificaSocieta) {
		generateClassificheDiSocietaIscrittiSheet(classificaSocieta);
		generateClassificheDiSocietaArrivatiSheet(classificaSocieta);
		generateClassificheDiSocietaPunteggioSheet(classificaSocieta);
	}

	private void generateClassificheDiSocietaPunteggioSheet(
			ClassificaSocietaView classificaSocieta) {
		int i;
		HSSFSheet sheet;
		HSSFCell title;
		int pos;
		//		Societa' a punti
		i = 0;
		sheet = report.createSheet("Societa' Punteggio");

		title = sheet.createRow((short) i).createCell((short) 0);
		title.setCellValue("Classifica Societa' a punteggio");
		title.setCellStyle(styles.get("headerStyle"));

		sheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
		sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 1).setCellValue("Societa'");
		sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 2).setCellValue("Punteggio");
		sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));


		i++;
		pos = 1;
		for (Entry<Societa, Integer> o : classificaSocieta.getClassificaSocietaPunteggio().entrySet()) {

			sheet.createRow((short) i).createCell((short) 0).setCellValue(pos);
			sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 1).setCellValue(o.getKey().getDenominazione());
			sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 2).setCellValue(o.getValue());
			sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));

			i++;
			pos++;
		}
	}

	private void generateClassificheDiSocietaArrivatiSheet(ClassificaSocietaView classificaSocieta) {
		int i;
		HSSFSheet sheet;
		HSSFCell title;
		int pos;
		//		Societa' classificate
		i = 0;
		sheet = report.createSheet("Societa' Arrivati");

		title = sheet.createRow((short) i).createCell((short) 0);
		title.setCellValue("Classifica Societa' Arrivati");
		title.setCellStyle(styles.get("headerStyle"));

		sheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
		sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 1).setCellValue("Societa'");
		sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 2).setCellValue("Numero arrivati");
		sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));


		i++;
		pos = 1;
		for (Entry<Societa, Integer> o : classificaSocieta.getClassificaSocietaClassificate().entrySet()) {

			sheet.createRow((short) i).createCell((short) 0).setCellValue(pos);
			sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 1).setCellValue(o.getKey().getDenominazione());
			sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 2).setCellValue(o.getValue());
			sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));

			i++;
			pos++;
		}
	}

	private void generateClassificheDiSocietaIscrittiSheet(
			ClassificaSocietaView classificaSocieta) {
		//		Societa' iscritte
		int i = 0;
		HSSFSheet sheet = report.createSheet("Societa' Iscritti");

		HSSFCell title = sheet.createRow((short) i).createCell((short) 0);
		title.setCellValue("Classifica Societa' Iscritti");
		title.setCellStyle(styles.get("headerStyle"));

		sheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
		sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 1).setCellValue("Societa'");
		sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 2).setCellValue("Numero iscritti");
		sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));


		i++;
		int pos = 1;
		for (Entry<Societa, Integer> o : classificaSocieta.getClassificaSocietaIscritte().entrySet()) {

			sheet.createRow((short) i).createCell((short) 0).setCellValue(pos);
			sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 1).setCellValue(o.getKey().getDenominazione());
			sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 2).setCellValue(o.getValue());
			sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));

			i++;
			pos++;
		}
	}

	private void generateInformazioniSheet (GaraView gara) {
		int i = 0;
		//Informazioni
		HSSFSheet informazioniSheet = report.createSheet("Informazioni");

		HSSFCell informazioniTitle = informazioniSheet.createRow((short) i).createCell((short) 0);
		informazioniTitle.setCellValue(gara.getNome());
		informazioniTitle.setCellStyle(styles.get("headerStyle"));

		i++;
		HSSFRow informazioniHeader = informazioniSheet.createRow((short) i);

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Descrizione:");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(gara.getDescrizione());
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
		i++;

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Data :");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(sdf.format(gara.getData()));
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
		i++;

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Societa' Organizzatrice:");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(gara.getCompetizione().getSocietaOrganizzatrice().getDenominazione());
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
		i++;      
		//Informazioni
	}

	private void generateClassificaGeneraleSheet (List<PrestazioneView> prestazioni) {
		int i = 0;
		//Classifica assoluta
		HSSFSheet sheet = report.createSheet("Classifica Assoluta");

		HSSFCell classificaAssolutaTitle = sheet.createRow((short) i).createCell((short) 0);
		classificaAssolutaTitle.setCellValue("Classifica Assoluta");
		classificaAssolutaTitle.setCellStyle(styles.get("headerStyle"));

		sheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
		sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 1).setCellValue("Atleta");
		sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 2).setCellValue("Sesso");
		sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 3).setCellValue("Anno Nascita");
		sheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 4).setCellValue("Categoria");
		sheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 5).setCellValue("Societa");
		sheet.getRow((short) i).getCell((short) 5).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 6).setCellValue("Tipo Prstazione");
		sheet.getRow((short) i).getCell((short) 6).setCellStyle(styles.get("headerStyle"));

		sheet.getRow((short) i).createCell((short) 7).setCellValue("Tempo");
		sheet.getRow((short) i).getCell((short) 7).setCellStyle(styles.get("headerStyle"));

		i++;

		int pos = 1;
		for (PrestazioneView prest : prestazioni) {

			sheet.createRow((short) i).createCell((short) 0).setCellValue(prest.getPosizione());
			sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 1).setCellValue(prest.getIscrizione().getAtleta().getNominativo());
			sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 2).setCellValue(prest.getIscrizione().getAtleta().getSesso());
			sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 3).setCellValue(prest.getIscrizione().getAtleta().getAnnoNascita());
			sheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 4).setCellValue(prest.getCategoria().getNomeCategoria());
			sheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 5).setCellValue(prest.getIscrizione().getAtleta().getSocietaAppartenenza().getDenominazione());
			sheet.getRow((short) i).getCell((short) 5).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 6).setCellValue(prest.getTipoPrestazione().getDescrizione());
			sheet.getRow((short) i).getCell((short) 6).setCellStyle(styles.get("tableStyle"));
			sheet.createRow((short) i).createCell((short) 7).setCellValue(prest.getValoreMisuraFormatted());
			sheet.getRow((short) i).getCell((short) 7).setCellStyle(styles.get("tableStyle"));

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
			classificaCategoriaCompetizioneTitle.setCellStyle(styles.get("headerStyle"));

			sheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
			sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));

			sheet.getRow((short) i).createCell((short) 1).setCellValue("Atleta");
			sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));

			sheet.getRow((short) i).createCell((short) 2).setCellValue("Sesso");
			sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));

			sheet.getRow((short) i).createCell((short) 3).setCellValue("Anno Nascita");
			sheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("headerStyle"));

			sheet.getRow((short) i).createCell((short) 4).setCellValue("Categoria");
			sheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("headerStyle"));

			sheet.getRow((short) i).createCell((short) 5).setCellValue("Societa");
			sheet.getRow((short) i).getCell((short) 5).setCellStyle(styles.get("headerStyle"));

			sheet.getRow((short) i).createCell((short) 6).setCellValue("Tipo Prstazione");
			sheet.getRow((short) i).getCell((short) 6).setCellStyle(styles.get("headerStyle"));

			sheet.getRow((short) i).createCell((short) 7).setCellValue("Tempo");
			sheet.getRow((short) i).getCell((short) 7).setCellStyle(styles.get("headerStyle"));
			i++;

			List<PrestazioneView> prestazioni = classificheCategorie.get(categoria);
			if (Eval.isNotEmpty(prestazioni)) {
				for (PrestazioneView prest : prestazioni) {
					sheet.createRow((short) i).createCell((short) 0).setCellValue(prest.getPosizione());
					sheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
					sheet.createRow((short) i).createCell((short) 1).setCellValue(prest.getIscrizione().getAtleta().getNominativo());
					sheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
					sheet.createRow((short) i).createCell((short) 2).setCellValue(prest.getIscrizione().getAtleta().getSesso());
					sheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));
					sheet.createRow((short) i).createCell((short) 3).setCellValue(prest.getIscrizione().getAtleta().getAnnoNascita());
					sheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("tableStyle"));
					sheet.createRow((short) i).createCell((short) 4).setCellValue(prest.getCategoria().getNomeCategoria());
					sheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("tableStyle"));
					sheet.createRow((short) i).createCell((short) 5).setCellValue(prest.getIscrizione().getAtleta().getSocietaAppartenenza().getDenominazione());
					sheet.getRow((short) i).getCell((short) 5).setCellStyle(styles.get("tableStyle"));
					sheet.createRow((short) i).createCell((short) 6).setCellValue(prest.getTipoPrestazione().getDescrizione());
					sheet.getRow((short) i).getCell((short) 6).setCellStyle(styles.get("tableStyle"));
					sheet.createRow((short) i).createCell((short) 7).setCellValue(prest.getValoreMisuraFormatted());
					sheet.getRow((short) i).getCell((short) 7).setCellStyle(styles.get("tableStyle"));

					i++;
				}
			}
		}
		//Classifiche di Categoria
	}

}
