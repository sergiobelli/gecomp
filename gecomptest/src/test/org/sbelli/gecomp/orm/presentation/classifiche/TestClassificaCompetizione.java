package test.org.sbelli.gecomp.orm.presentation.classifiche;

import java.util.ArrayList;
import java.util.List;

import org.sbelli.gecomp.console.report.ReportManager;
import org.sbelli.gecomp.orm.dao.ClassificaCompetizioneManager;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaCompetizione;

public class TestClassificaCompetizione {
	public static void main(String[] args) {
		try {
			List<ClassificaCompetizione> cs = new ArrayList<ClassificaCompetizione>();
			List<Competizione> competizioni = DbManagerFactory.getInstance().getCompetizioneDao().list();
			for (Competizione competizione : competizioni) {
				
				long start = System.currentTimeMillis();
				ClassificaCompetizione classificaCompetizione = ClassificaCompetizioneManager.getInstance().getClassificaCompetizione(competizione);
				long end = System.currentTimeMillis();
				System.out.println("time taken = " + (end - start));
				
				cs.add(classificaCompetizione);
			}
			
		
			
//			Competizione competizione = CompetizioneDao.getInstance().list().iterator().next();
//				
//				long start = System.currentTimeMillis();
//				ClassificaCompetizione classificaCompetizione = ClassificaCompetizioneManager.getInstance().getClassificaCompetizione(competizione);
//				long end = System.currentTimeMillis();
//				System.out.println("time taken = " + (end - start));
//				
//				cs.add(classificaCompetizione);
			
			
			System.out.println("cs = " + cs);
			for (ClassificaCompetizione c : cs) {
				ReportManager r = new ReportManager();
				r.generateReport(c);
			}
			
			
//			
//			
//			
//			
//			//File jasper sorgente
//			String fileName="C:\\classic.jasper";
//			//File pdf di destinazione
//			String destFileNamePdf="C:\\report1.pdf";
//			//File xls di destinazione
//			String destFileNameXls="C:\\report1.xls";
//
//			//Passaggio parametri da passare al jasper.
//			Map parameters = new HashMap();
//			parameters.put("param1", cs.iterator().next());
//
//			//Preparazione del file da stampare (in questa fase si esegue la query e si inseriscono
//			//i valori estratti dalla query)
//			
//			JRDataSource dataSource = JRDataSource();
//			JasperPrint jasperPrint=JasperFillManager.fillReport(fileName, parameters, );
//
//			//Creazione del PDF
//			JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf);
//
//			//Creazione dell'xls
//			JRXlsExporter exporter = new JRXlsExporter();
//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFileNameXls);
//			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
//			exporter.exportReport();
//			
//			
//			
			
			
			
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
