package net.sb.gecomp.utils.logger;

import org.apache.log4j.Logger;

/**
 * @author sbelli
 */
public class GeCompLogger /*extends org.apache.log4j.Logger*/ {

	private Logger logger = null; 
	private GeCompLogger(String className) {logger = Logger.getLogger(className);}
	private GeCompLogger(Class clazz) {logger = Logger.getLogger(clazz);}
	public static GeCompLogger getGeCompLogger(String className) {
		return new GeCompLogger(className);
	}
	public static GeCompLogger getGeCompLogger(Class clazz) {
		return new GeCompLogger(clazz);
	}
	
	public void log (Object ... messages) {
		StringBuilder sb = new StringBuilder();
		for (Object msg : messages) { sb.append(msg); }
		System.out.println(sb.toString()); 
	}
	
	public void debug (Object ... messages) {
		StringBuilder sb = new StringBuilder();
		for (Object msg : messages) { sb.append(msg); }
		logger.debug(sb.toString()); 
	}
	
	public void info (Object ... messages) {
		StringBuilder sb = new StringBuilder();
		for (Object msg : messages) { sb.append(msg); }
		logger.info(sb.toString()); 
	}
	
	public void warn (Object ... messages) {
		StringBuilder sb = new StringBuilder();
		for (Object msg : messages) { sb.append(msg); }
		logger.warn(sb.toString()); 
	}
	public void warn (Throwable ex, Object ... messages) {
		StringBuilder sb = new StringBuilder();
		for (Object msg : messages) { sb.append(msg); }
		logger.warn(sb.toString(), ex); 
	}
	
	public void error (Object ... messages) {
		StringBuilder sb = new StringBuilder();
		for (Object msg : messages) { sb.append(msg); }
		logger.error(sb.toString()); 
	}
	public void error (Throwable ex, Object ... messages) {
		StringBuilder sb = new StringBuilder();
		for (Object msg : messages) { sb.append(msg); }
		logger.error(sb.toString(), ex); 
	}

}
