package net.sb.gecomp.web.utils.exceptions;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.exceptions.MessageSeverity;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.utils.guimessages.GuiMessageHandler;


public class GeCompGuiExceptionManager {

	public static final void manageGUIException (GeCompLogger logger, Throwable ex, Object message) {
		if (Eval.isNotNull(ex)) {	
			if (ex instanceof GeCompException) {
				GeCompExceptionManager.handleManagedException(logger, ex);
				GuiMessageHandler.addGUIMessage(MessageSeverity.error, ex.getMessage(), (String)message);
			} else {
				GeCompExceptionManager.handleRawException(logger, ex);
				GuiMessageHandler.addGUIMessage(MessageSeverity.error, "error.generic", "error.generic.ko.descrizione");
			}
		}
	}

	public static final void manageGUIException (GeCompLogger logger, Throwable ex, Object ... messages) {
		if (Eval.isNotNull(ex)) {	
			if (ex instanceof GeCompException) {
				GeCompExceptionManager.handleManagedException(logger, ex);				
			} else {
				GeCompExceptionManager.handleRawException(logger, ex);
			}
			StringBuilder sb = new StringBuilder();
			for (Object msg : messages) {
				sb.append(msg);
			}
			GuiMessageHandler.addGUIMessage(MessageSeverity.error, ex.getMessage(), sb.toString());
		}	
	}
}
