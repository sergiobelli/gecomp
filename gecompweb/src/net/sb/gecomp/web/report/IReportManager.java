package net.sb.gecomp.web.report;

import net.sb.gecomp.srv.orm.presentation.classifiche.IClassifica;

public interface IReportManager<T extends IClassifica> {

	void generateReport (T classifica);
	
}
