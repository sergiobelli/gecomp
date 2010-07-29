package net.sb.gecomp.web.report.gara;

import java.text.SimpleDateFormat;

import net.sb.gecomp.web.report.ReportManager;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReportGaraManager extends ReportManager {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private HSSFCellStyle 	titleStyle;
	private HSSFCellStyle 	headerStyle;
	private HSSFCellStyle 	tableStyle;
	private HSSFWorkbook 	classificaGara;
	
}
