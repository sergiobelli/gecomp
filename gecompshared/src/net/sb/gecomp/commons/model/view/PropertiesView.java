package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.Properties;

public class PropertiesView extends Properties {

	public static final String START_PATH = "gecomp.start.path";
	public static final String STAGING_AREA_PATH = "gecomp.staging.area";
	public static final String FILE_EXTENSION = "gecomp.report.file.extension";
	
	public PropertiesView() { }
	public PropertiesView(Properties property) {
		ViewUtils.copyProperties(this, property);
	}
	
}
