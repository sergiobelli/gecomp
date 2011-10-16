package net.sb.gecomp.web.user;

import java.util.Map;

import javax.faces.context.FacesContext;

import net.sb.gecomp.commons.utils.Eval;

import org.apache.log4j.Logger;

public class GeCompUserSessionHandler {
	
	protected static Logger logger = Logger.getLogger(GeCompUserSessionHandler.class.getName());
	
	public static final String GECOMP_USER_SESSION_NAME = "GeCompUserSession";
	public static final String GECOMP_USER_HTTP_SESSION_NAME = "GeCompUserHttpSession";
	
	public static GeCompUserSession getGeCompUserSession() {
		try {
			GeCompUserSession geCompUserSession = null;
			FacesContext facesContext = FacesContext.getCurrentInstance();
			if (Eval.isNotNull(facesContext)) {
				geCompUserSession = (GeCompUserSession) facesContext.getExternalContext().getSessionMap().get(GECOMP_USER_SESSION_NAME);
				if (Eval.isNull(geCompUserSession)) {
					geCompUserSession = new GeCompUserSession();
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(GECOMP_USER_SESSION_NAME, geCompUserSession);
				}
			}
			return geCompUserSession;
		} catch (Throwable ex) {
			logger.error("Errore nel reperimento della sessione utente : ", ex);
			return null;
		}
	}

	public static GeCompUserHttpSession getGeCompUserHttpSession() {
		GeCompUserHttpSession geCompUserSession = null;
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			if (Eval.isNotNull(facesContext)) {
				
				Map httpSession = facesContext.getExternalContext().getSessionMap();
				
				geCompUserSession = (GeCompUserHttpSession) httpSession.get(GECOMP_USER_HTTP_SESSION_NAME);
				
				if (Eval.isNull(geCompUserSession)) {
					geCompUserSession = new GeCompUserHttpSession();
					
					httpSession.put(GECOMP_USER_HTTP_SESSION_NAME, geCompUserSession);
					
				}
			}
		} catch (Throwable ex) {
			logger.error("Errore nel reperimento della sessione http : ", ex);
		}
		return geCompUserSession;
	}
	
}
