package net.sb.gecomp.orm.report;

/*
 * Main.java
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// import net.sf.jasperreports.engine.JRExporterParameter;
// import net.sf.jasperreports.engine.JasperExportManager;
// import net.sf.jasperreports.engine.JasperFillManager;
// import net.sf.jasperreports.engine.JasperPrint;
// import net.sf.jasperreports.engine.export.JRXlsExporter;
// import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

/**
 * 
 * @author sgl
 */
public class Main {

	/** Creates a new instance of Main */
	public Main() {
	}

	//
	// /**
	// * @param args the command line arguments
	// */
	// public static void main(String[] args) {
	// try{
	//
	// //File jasper sorgente
	// String fileName="C:\\classic.jasper";
	// //File pdf di destinazione
	// String destFileNamePdf="C:\\report1.pdf";
	// //File xls di destinazione
	// String destFileNameXls="C:\\report1.xls";
	//
	// //Passaggio parametri da passare al jasper.
	// Map parameters = new HashMap();
	// parameters.put("param1", new Integer(1));
	//
	// //Preparazione del file da stampare (in questa fase si esegue la query e
	// si inseriscono
	// //i valori estratti dalla query)
	// JasperPrint jasperPrint=JasperFillManager.fillReport(fileName,
	// parameters, getConnection());
	//
	// //Creazione del PDF
	// JasperExportManager.exportReportToPdfFile(jasperPrint, destFileNamePdf);
	//
	// //Creazione dell'xls
	// JRXlsExporter exporter = new JRXlsExporter();
	// exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	// exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
	// destFileNameXls);
	// exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
	// Boolean.TRUE);
	// exporter.exportReport();
	//
	// System.exit(0);
	// }catch (Exception e){
	// e.printStackTrace();
	// }
	//
	// }

	/** Metodo per creare la connessione al DB */
	private static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		// Change these settings according to your local configuration
		String driver = "org.gjt.mm.mysql.Driver";
		String connectString = "jdbc:mysql://localhost/gecomp";
		String user = "root";
		String password = "";

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(connectString, user,
				password);
		return conn;
	}

}