package org.sbelli.gecomp.console.report.gara;

import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sbelli.gecomp.console.report.ReportManager;

public class ReportGaraManager extends ReportManager {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private HSSFCellStyle 	titleStyle;
	private HSSFCellStyle 	headerStyle;
	private HSSFCellStyle 	tableStyle;
	private HSSFWorkbook 	classificaGara;
	
}
