package net.sb.gecomp.commons.utils.exceptions;


import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.utils.Eval;

import org.apache.log4j.Logger;


public class GeCompExceptionManager {

	public static final void traceException (Logger logger, Throwable ex) {
		traceException (logger, "Exception = ", ex);
	}
	
	public static final void traceException (Logger logger, String message, Throwable ex) {
		if (Eval.isNotNull(ex)) {	
			if (ex instanceof GeCompException) {
				handleManagedException(logger, ex);
			} else {
				handleRawException(logger, ex);
			}			
		}
	}

	private static void handleManagedException ( Logger logger, Throwable e ) {
		if (Eval.isNotNull(e)) {
			System.out.println("***** <GeComp> Catched exception : " + e.getClass().getName());
			System.out.println("***** <GeComp> message           : " + e.getMessage());
			
			if (Eval.isNotNull(logger)) {
				logger.error("***** <GeComp> Catched exception : " + e.getClass().getName());
				logger.error("***** <GeComp> message           : " + e.getMessage());
			}			
		}
	}

	private static void handleRawException ( Logger logger, Throwable e ) {
		if (Eval.isNotNull(e)) {
			System.out.println("*****************************************************************");
			System.out.println("***** <GeComp> Catched exception : " + e.getClass().getName());
			e.printStackTrace();
			System.out.println("*****************************************************************");
			
			if (Eval.isNotNull(logger)) {
				logger.error("*****************************************************************");
				logger.error("***** <GeComp> Catched exception : " + e.getClass().getName());
				logger.error("***** <GeComp> cause             : " + e.getCause());
				logger.error("***** <GeComp> message           : " + e.getMessage());
				logger.error("***** <GeComp> localized message : " + e.getLocalizedMessage());
				logger.error("***** <GeComp> trace             : ");
				for (StackTraceElement track : e.getStackTrace()) { logger.error(track); }
				logger.error("*****************************************************************");
			}			
		}		
	}
		
}
