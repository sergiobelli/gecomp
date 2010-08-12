package net.sb.gecomp.web.utils.exceptions;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.commons.utils.exceptions.MessageSeverity;
import net.sb.gecomp.web.utils.guimessages.GuiMessageHandler;

import org.apache.log4j.Logger;

public class GeCompGuiExceptionManager {

	public static final void manageGUIException (Logger logger, Throwable ex, Object message) {
		if (Eval.isNotNull(ex)) {
			GeCompExceptionManager.traceException(logger, ex);
			if (ex instanceof GeCompException) {
				GuiMessageHandler.addGUIMessage(MessageSeverity.error, ex.getMessage(), (String)message);
			} else {
				GuiMessageHandler.addGUIMessage(MessageSeverity.error, "error.generic", "error.generic.ko.descrizione");
			}
		}
	}

	public static final void manageGUIException (Logger logger, Throwable ex, Object ... messages) {
		if (Eval.isNotNull(ex)) {	
			GeCompExceptionManager.traceException(logger, ex);
			StringBuilder sb = new StringBuilder();
			for (Object msg : messages) {
				sb.append(msg);
			}
			GuiMessageHandler.addGUIMessage(MessageSeverity.error, ex.getMessage(), sb.toString());
		}	
	}
}
