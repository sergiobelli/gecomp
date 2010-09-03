package net.sb.gecomp.web.utils.context;

import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GecompContextFactory {
	
	protected static Logger logger = Logger.getLogger(DbManagerFactory.class.getName());
		
	public static final ApplicationContext getContext() {
		logger.info("Start GecompContextFactory Spring System Initialization...");
		
		String[] files = {"classpath:applicationContext.xml"};
		logger.debug("files="+files);
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(files);
		logger.debug("applicationContext="+applicationContext);
		
		logger.info("End GecompContextFactory Spring System Initialization...");		
		return applicationContext;
	}
	
}
