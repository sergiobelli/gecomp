package org.sbelli.gecomp.console.user;

import java.util.Map;

import javax.faces.context.FacesContext;

import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

public class GeCompUserSessionHandler {
	
	private static GeCompLogger logger = GeCompLogger.getGeCompLogger(GeCompUserSessionHandler.class);
	
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
			logger.error(ex, "Errore nel reperimento della sessione utente : ", ex.getMessage());
			return null;
		}
	}

	public static GeCompUserHttpSession getGeCompUserHttpSession() {
		GeCompUserHttpSession geCompUserSession = null;
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			if (Eval.isNotNull(facesContext)) {
				
//				HttpSession httpSession = ((HttpServletRequest)facesContext.getExternalContext().getRequest()).getSession();
				Map httpSession = facesContext.getExternalContext().getSessionMap();
				
//				geCompUserSession = (GeCompUserHttpSession) httpSession.getAttribute(GECOMP_USER_HTTP_SESSION_NAME);
				geCompUserSession = (GeCompUserHttpSession) httpSession.get(GECOMP_USER_HTTP_SESSION_NAME);
				
				if (Eval.isNull(geCompUserSession)) {
					geCompUserSession = new GeCompUserHttpSession();
					
//					httpSession.setAttribute(GECOMP_USER_HTTP_SESSION_NAME, geCompUserSession);
					httpSession.put(GECOMP_USER_HTTP_SESSION_NAME, geCompUserSession);
					
				}
			}
		} catch (Throwable ex) {
			logger.error(ex, "Errore nel reperimento della sessione http : ", ex.getMessage());
		}
		return geCompUserSession;
	}
	
}

//class UserSessionHandler {
//    protected Logger womLogger = Logger.getLogger(this.getClass().getName());
//    private static UserSessionHandler instance;
//    private UserSessionHandler() {}
//    public static UserSessionHandler getInstance() {
//        return (Assert.isNull(instance)) ? new UserSessionHandler() : instance;
//    }
//
//    /**
//     * Method that returns the session of the logged user.
//     * @return user session Map
//     */
//    public Map getUserSession () { return createUserSessionMap(); }
//
//    /**
//     * Method that permits to set the user session.
//     * @param session
//     */
//    public void setUserSession (Map session) { setUserSessionMap(session); }
//
//    /**
//     * Method that permits to clear the logged user session.
//     */
//    public void clearUserSession() { setUserSession(null); }
//
//    /**
//     * Creates a new user session instance or returns the existing ones.
//     * @return
//     */
//    private Map createUserSessionMap () {
//        Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//        //womLogger.debug("<createUserSessionMap>session="+session);
//        String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
//        womLogger.debug("<createUserSessionMap>user="+user);
//
//        Map userSession = null;
//        if (!session.containsKey(user)) {
//            userSession = new HashMap();
//            session.put(user, userSession);
//        } else {
//            userSession = (Map) session.get(user);
//        }
//        //womLogger.debug("<createUserSessionMap>userSession="+userSession);
//        return userSession;
//    }
//    private void setUserSessionMap(Map userSession) {
//        if (Assert.isNotNull(userSession)) {
//            Map facesSession = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//            //womLogger.debug("<setUserSessionMap>facesSession=" + facesSession);
//            String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
//            womLogger.debug("<setUserSessionMap>user=" + user);
//
//            facesSession.put(user, userSession);
//            //womLogger.debug("<setUserSessionMap>userSession=" + userSession);
//        } else {
//            womLogger.debug("<setUserSessionMap>removing");
//            Map facesSession = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//            String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
//            facesSession.remove(user);
//        }
//    }
//}
