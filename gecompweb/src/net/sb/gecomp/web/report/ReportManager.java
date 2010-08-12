package net.sb.gecomp.web.report;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.commons.model.view.ClassificaCompetizioneView;
import net.sb.gecomp.commons.model.view.ClassificaGaraView;
import net.sb.gecomp.commons.model.view.IClassificaView;
import net.sb.gecomp.commons.model.view.PropertiesView;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.srv.orm.presentation.classifiche.ClassificaCategoriaCompetizione;
import net.sb.gecomp.srv.orm.presentation.classifiche.ClassificaCompetizione;
import net.sb.gecomp.srv.orm.presentation.classifiche.IClassifica;
import net.sb.gecomp.srv.orm.presentation.classifiche.PrestazioneInCompetizione;
import net.sb.gecomp.web.delegates.properties.PropertiesDelegate;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * @author S.BELLI
 */
public class ReportManager implements IReportManager {

	protected PropertiesDelegate delegate = new PropertiesDelegate();
	
	private static final String INTERNAL_PATH_SEPARATOR = "|";
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());

	protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	protected HashMap<String,HSSFCellStyle> styles;
	
	protected HSSFWorkbook report;
	
	public void generateReport (IClassificaView classifica) {
		HSSFWorkbook report = null;
		String nomeReport = "";
		String nomeCartella = "";
		if (classifica instanceof ClassificaGaraView) {
			ClassificaGaraView classificaGaraView = (ClassificaGaraView)classifica;
			report = new GaraReportManager().getReport(classificaGaraView);
			nomeCartella = classificaGaraView.getGara().getCompetizione().getNome() + INTERNAL_PATH_SEPARATOR + classificaGaraView.getGara().getNome();
			nomeReport = classificaGaraView.getGara().getNome();
		} else if (classifica instanceof ClassificaCompetizioneView) {
			ClassificaCompetizioneView classificaCompetizioneView = (ClassificaCompetizioneView)classifica;
			report = new CompetizioneReportManager().getReport(classificaCompetizioneView);
			nomeCartella = classificaCompetizioneView.getCompetizione().getNome();
			nomeReport = classificaCompetizioneView.getCompetizione().getNome();
		}
		writeReportToFile (report, nomeCartella, nomeReport);
	}
	public void generateReport (IClassifica classifica) { }

	private void writeReportToFile (HSSFWorkbook report, String nomeCartella, String nomeFile) {
		try {
			// Write the output to a file

			String startPath = 
				delegate.get(PropertiesView.START_PATH).getValore()
					.replace(INTERNAL_PATH_SEPARATOR, System.getProperty("file.separator"));
			logger.info("startPath=" + startPath);
			
			String filePath = 
				delegate.get(PropertiesView.STAGING_AREA_PATH).getValore()
					.replace(INTERNAL_PATH_SEPARATOR, System.getProperty("file.separator"));
			logger.info("filePath=" +  filePath);
			
			String fileName = nomeFile.trim().replaceAll(" ", "_");
			logger.info("fileName=" +  fileName);
			
			String fileExtension = 
				delegate.get(PropertiesView.FILE_EXTENSION).getValore();
			logger.info("fileExtension=" +  fileExtension);
			
			nomeCartella = nomeCartella.replace(INTERNAL_PATH_SEPARATOR, System.getProperty("file.separator"));
			logger.info("nomeCartella=" +  nomeCartella);
			
			String dir = 
				startPath + System.getProperty("file.separator") 
				+ filePath + System.getProperty("file.separator")
				+ nomeCartella;
			logger.info("dir=" +  dir);
			
			String all = dir + System.getProperty("file.separator") + fileName  + fileExtension;
			logger.info("all=" +  all);
			
			File file = new File(dir);
			file.mkdirs();
			
			file = new File(all);
			if (!file.exists()) {
				boolean isCreated = file.createNewFile();
				if (!isCreated) {
					throw new Exception("KO");
				}
			}

			FileOutputStream fileOut = new FileOutputStream(file);
			report.write(fileOut);
			fileOut.close();
		} catch (Exception ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
	}

	private void generateClassificaDiSocietaSheet (ClassificaCompetizione classificaCompetizione) {
		// TODO Auto-generated method stub	  
	}

	private void generateClassificheDiCategoriaSheet (List<CategoriaView> categorie, Hashtable<Categoria, ClassificaCategoriaCompetizione> classificheCompetizione) {
		int i = 0;
		//Classifiche di Categoria
		for (Categoria categoria : categorie) {

			i = 0;
			ClassificaCategoriaCompetizione classificaCategoriaCompetizione = classificheCompetizione.get(categoria);

			HSSFSheet classificaCategoriaCompetizioneSheet = report.createSheet("Classifica Categoria");

			HSSFCell classificaCategoriaCompetizioneTitle = classificaCategoriaCompetizioneSheet.createRow((short) i).createCell((short) 0);
			classificaCategoriaCompetizioneTitle.setCellValue("Classifica Categoria:" + classificaCategoriaCompetizione.getCategoria().getNomeCategoria());
			classificaCategoriaCompetizioneTitle.setCellStyle(styles.get("headerStyle"));

			classificaCategoriaCompetizioneSheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
			classificaCategoriaCompetizioneSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));
			classificaCategoriaCompetizioneSheet.getRow((short) i).createCell((short) 1).setCellValue("Atleta");
			classificaCategoriaCompetizioneSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));
			classificaCategoriaCompetizioneSheet.getRow((short) i).createCell((short) 2).setCellValue("Tempo");
			classificaCategoriaCompetizioneSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));
			i++;

			int pos = 1;
			for (Prestazione prest : classificaCategoriaCompetizione.getClassificaCompetizione()) {

				classificaCategoriaCompetizioneSheet.createRow((short) i).createCell((short) 0).setCellValue(pos);
				classificaCategoriaCompetizioneSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
				classificaCategoriaCompetizioneSheet.createRow((short) i).createCell((short) 1).setCellValue(prest.getIscrizione().getAtleta().toReportString());
				classificaCategoriaCompetizioneSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
				classificaCategoriaCompetizioneSheet.createRow((short) i).createCell((short) 2).setCellValue(DbManagerFactory.getInstance().getPrestazioneDao().getTempo(prest.getValoreMisura()));
				classificaCategoriaCompetizioneSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));

				i++;
				pos++;
			}
		}
		//Classifiche di Categoria
	}

	private void generateClassificaAssolutaSheet (List<PrestazioneInCompetizione> prestazioniAssoluteInCompetizione) {
		int i = 0;
		//Classifica assoluta
		HSSFSheet classificaAssolutaSheet = report.createSheet("Classifica Assoluta");

		HSSFCell classificaAssolutaTitle = classificaAssolutaSheet.createRow((short) i).createCell((short) 0);
		classificaAssolutaTitle.setCellValue("Classifica Assoluta");
		classificaAssolutaTitle.setCellStyle(styles.get("headerStyle"));

		classificaAssolutaSheet.createRow((short) i).createCell((short) 0).setCellValue("Posizione");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));
		classificaAssolutaSheet.getRow((short) i).createCell((short) 1).setCellValue("Atleta");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));
		classificaAssolutaSheet.getRow((short) i).createCell((short) 2).setCellValue("Tempo");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));
		classificaAssolutaSheet.getRow((short) i).createCell((short) 3).setCellValue("Gare Sostenute");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("headerStyle"));
		classificaAssolutaSheet.getRow((short) i).createCell((short) 4).setCellValue("Ritirato");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("headerStyle"));
		classificaAssolutaSheet.getRow((short) i).createCell((short) 5).setCellValue("Squalificato");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 5).setCellStyle(styles.get("headerStyle"));
		classificaAssolutaSheet.getRow((short) i).createCell((short) 6).setCellValue("Note");
		classificaAssolutaSheet.getRow((short) i).getCell((short) 6).setCellStyle(styles.get("headerStyle"));
		i++;

		int pos = 1;
		for (PrestazioneInCompetizione prest : prestazioniAssoluteInCompetizione) {

			classificaAssolutaSheet.createRow((short) i).createCell((short) 0).setCellValue(pos);
			classificaAssolutaSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			classificaAssolutaSheet.createRow((short) i).createCell((short) 1).setCellValue(prest.getAtleta().toReportString());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			classificaAssolutaSheet.createRow((short) i).createCell((short) 2).setCellValue(DbManagerFactory.getInstance().getPrestazioneDao().getTempo(prest.getValoreMisuraTotale()));
			classificaAssolutaSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));
			classificaAssolutaSheet.createRow((short) i).createCell((short) 3).setCellValue(prest.getGareSostenute().size());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("tableStyle"));
			classificaAssolutaSheet.createRow((short) i).createCell((short) 4).setCellValue(prest.isRitirato());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("tableStyle"));
			classificaAssolutaSheet.createRow((short) i).createCell((short) 5).setCellValue(prest.isSqualificato());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 5).setCellStyle(styles.get("tableStyle"));
			classificaAssolutaSheet.createRow((short) i).createCell((short) 6).setCellValue(prest.getNote());
			classificaAssolutaSheet.getRow((short) i).getCell((short) 6).setCellStyle(styles.get("tableStyle"));

			i++;
			pos++;
		}
		//Classifica assoluta
	}

	protected void generateCategorieSheet (List<CategoriaView> categorie) {
		int i = 0;
		//Categorie
		HSSFSheet categorieSheet = report.createSheet("Elenco Categorie Ammesse");

		HSSFCell categorieTitle = categorieSheet.createRow((short) i).createCell((short) 0);
		categorieTitle.setCellValue("Elenco Categorie Ammesse");
		categorieTitle.setCellStyle(styles.get("headerStyle"));

		categorieSheet.createRow((short) i).createCell((short) 0).setCellValue("Categorie");
		categorieSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));
		categorieSheet.getRow((short) i).createCell((short) 1).setCellValue("Sesso");
		categorieSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));
		categorieSheet.getRow((short) i).createCell((short) 2).setCellValue("Anni Appartenenza");
		categorieSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));
		i++;

		for (Categoria categoria : categorie) {

			categorieSheet.createRow((short) i).createCell((short) 0).setCellValue(categoria.getNomeCategoria());
			categorieSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			categorieSheet.createRow((short) i).createCell((short) 1).setCellValue(categoria.getSesso());
			categorieSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			categorieSheet.createRow((short) i).createCell((short) 2).setCellValue(categoria.getAnniAppartenenza().toString());
			categorieSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));
			i++;
		}		
		//Categorie
	}

	protected void generateAtletiSheet (List<Atleta> atleti) {
		int i = 0;
		//Atleti
		HSSFSheet atletiSheet = report.createSheet("Elenco Atleti Iscritti");

		HSSFCell atletiTitle = atletiSheet.createRow((short) i).createCell((short) 0);
		atletiTitle.setCellValue("Elenco Atleti Iscritti");
		atletiTitle.setCellStyle(styles.get("headerStyle"));

		atletiSheet.createRow((short) i).createCell((short) 0).setCellValue("Cognome");
		atletiSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));
		atletiSheet.getRow((short) i).createCell((short) 1).setCellValue("Nome");
		atletiSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));
		atletiSheet.getRow((short) i).createCell((short) 2).setCellValue("Sesso");
		atletiSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));
		atletiSheet.getRow((short) i).createCell((short) 3).setCellValue("Anno Nascita");
		atletiSheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("headerStyle"));
		atletiSheet.getRow((short) i).createCell((short) 4).setCellValue("Societa' Appartenenza");
		atletiSheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("headerStyle"));
		i++;

		for (Atleta atleta : atleti) {

			atletiSheet.createRow((short) i).createCell((short) 0).setCellValue(atleta.getCognome());
			atletiSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			atletiSheet.createRow((short) i).createCell((short) 1).setCellValue(atleta.getNome());
			atletiSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			atletiSheet.createRow((short) i).createCell((short) 2).setCellValue(atleta.getSesso());
			atletiSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));
			atletiSheet.createRow((short) i).createCell((short) 3).setCellValue(atleta.getAnnoNascita());
			atletiSheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("tableStyle"));
			atletiSheet.createRow((short) i).createCell((short) 4).setCellValue(atleta.getSocietaAppartenenza().getDenominazione());
			atletiSheet.getRow((short) i).getCell((short) 4).setCellStyle(styles.get("tableStyle"));
			i++;
		}
		//Atleti
	}

	private void generateGareSheet (List<Gara> gare) {
		int i = 0;
		//Gare
		HSSFSheet gareSheet = report.createSheet("Elenco Gare");

		HSSFCell gareTitle = gareSheet.createRow((short) i).createCell((short) 0);
		gareTitle.setCellValue("Elenco Gare");
		gareTitle.setCellStyle(styles.get("headerStyle"));

		gareSheet.createRow((short) i).createCell((short) 0).setCellValue("Nome");
		gareSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("headerStyle"));
		gareSheet.getRow((short) i).createCell((short) 1).setCellValue("Descrizione");
		gareSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("headerStyle"));
		gareSheet.getRow((short) i).createCell((short) 2).setCellValue("Data");
		gareSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("headerStyle"));
		gareSheet.getRow((short) i).createCell((short) 3).setCellValue("Distanza");
		gareSheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("headerStyle"));
		i++;

		for (Gara gara : gare) {

			gareSheet.createRow((short) i).createCell((short) 0).setCellValue(gara.getNome());
			gareSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
			gareSheet.createRow((short) i).createCell((short) 1).setCellValue(gara.getDescrizione());
			gareSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
			gareSheet.createRow((short) i).createCell((short) 2).setCellValue(sdf.format(gara.getData()));
			gareSheet.getRow((short) i).getCell((short) 2).setCellStyle(styles.get("tableStyle"));
			gareSheet.createRow((short) i).createCell((short) 3).setCellValue(gara.getDistanza());
			gareSheet.getRow((short) i).getCell((short) 3).setCellStyle(styles.get("tableStyle"));
			i++;
		}		
		//Gare
	}

	private void generateInformazioniSheet (Competizione competizione) {
		int i = 0;
		//Informazioni
		HSSFSheet informazioniSheet = report.createSheet("Informazioni");

		HSSFCell informazioniTitle = informazioniSheet.createRow((short) i).createCell((short) 0);
		informazioniTitle.setCellValue(competizione.getNome());
		informazioniTitle.setCellStyle(styles.get("headerStyle"));

		i++;
		HSSFRow informazioniHeader = informazioniSheet.createRow((short) i);

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Descrizione:");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(competizione.getDescrizione());
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
		i++;

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Data Inizio:");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(sdf.format(competizione.getDataInizio()));
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
		i++;

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Data Fine:");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(sdf.format(competizione.getDataFine()));
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
		i++;

		informazioniSheet.createRow((short) i).createCell((short) 0).setCellValue("Societa' Organizzatrice:");
		informazioniSheet.getRow((short) i).getCell((short) 0).setCellStyle(styles.get("tableStyle"));
		informazioniSheet.getRow((short) i).createCell((short) 1).setCellValue(competizione.getSocietaOrganizzatrice().getDenominazione());
		informazioniSheet.getRow((short) i).getCell((short) 1).setCellStyle(styles.get("tableStyle"));
		i++;      
		//Informazioni
	}

	protected HSSFCellStyle getTitleStyle () {

		//title style
		HSSFCellStyle titleStyle = report.createCellStyle();
		HSSFFont titleFont = report.createFont();
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		titleStyle.setFont(titleFont);
		//title style

		return titleStyle;
	}

	protected HSSFCellStyle getHeaderStyle () {

		//header style                        
		HSSFCellStyle headerStyle = report.createCellStyle();
		HSSFFont headerFont = report.createFont();
		headerFont.setColor(HSSFColor.WHITE.index);
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerStyle.setFont(headerFont);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headerStyle.setFillForegroundColor(HSSFColor.RED.index);
		headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headerStyle.setRightBorderColor(HSSFColor.BLACK.index);
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headerStyle.setTopBorderColor(HSSFColor.BLACK.index);           
		//header style                        

		return headerStyle;
	}	

	protected HSSFCellStyle getTableStyle () {

		//table style
		HSSFCellStyle tableStyle = report.createCellStyle();
		tableStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		tableStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		tableStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		tableStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		tableStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		tableStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		tableStyle.setRightBorderColor(HSSFColor.BLACK.index);
		tableStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		tableStyle.setTopBorderColor(HSSFColor.BLACK.index);
		//table style

		return tableStyle;
	}
	
}
