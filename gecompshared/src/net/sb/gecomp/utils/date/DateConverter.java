package net.sb.gecomp.utils.date;

import java.util.Date;

/**
 * @author sergio
 */
public class DateConverter {
	private DateConverter instance;
	private DateConverter() {}
	public DateConverter getInstance() {
		if (instance == null) {instance = new DateConverter();}
		return instance;
	}
	
	public String parse (Date dataToBeParsed, String format) {
//		return new SimpleDateFormat(format).parse(dataToBeParsed);
		return null;
	}
	public String format (String dataToBeParsed, String format) {
//		return new SimpleDateFormat(format).format(dataToBeParsed);
		return null;
	}
}
