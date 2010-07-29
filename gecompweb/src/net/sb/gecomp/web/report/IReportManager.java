package net.sb.gecomp.web.report;

import org.sbelli.gecomp.orm.presentation.classifiche.IClassifica;

public interface IReportManager<T extends IClassifica> {

	void generateReport (T classifica);
	
}
