package net.sb.gecomp.utils.exceptions;


import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;


public class GeCompExceptionManager {

	public static final void manageException (GeCompLogger logger, Throwable ex) {
		manageException (logger, "Exception = ", ex);
	}
	
	public static final void manageException (GeCompLogger logger, String message, Throwable ex) {
		if (Eval.isNotNull(ex)) {	
			if (ex instanceof GeCompException) {
				handleManagedException(logger, ex);
			} else {
				handleRawException(logger, ex);
			}			
		}
	}

	public static void handleManagedException ( GeCompLogger logger, Throwable e ) {
		if (Eval.isNotNull(e)) {
			System.out.println("***** <GeComp> Catched exception : " + e.getClass().getName());
			System.out.println("***** <GeComp> message           : " + e.getMessage());
			
			if (Eval.isNotNull(logger)) {
				logger.error("***** <GeComp> Catched exception : " + e.getClass().getName());
				logger.error("***** <GeComp> message           : " + e.getMessage());
			}			
		}
	}

	public static void handleRawException ( GeCompLogger logger, Throwable e ) {
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
