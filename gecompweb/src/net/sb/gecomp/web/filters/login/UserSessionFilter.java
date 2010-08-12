package net.sb.gecomp.web.filters.login;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sb.gecomp.commons.model.view.PropertiesView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.delegates.properties.PropertiesDelegate;
import net.sb.gecomp.web.user.GeCompUserHttpSession;

import org.apache.log4j.Logger;


public class UserSessionFilter implements Filter {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private FilterConfig filterConfig = null;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	public void destroy() {
		this.filterConfig = null;
	}
	
	private static final String LOGIN_URI = "/main/login/login.jsf";
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = ((HttpServletRequest)req);
		HttpServletResponse response = ((HttpServletResponse) resp);
		String target = request.getContextPath() + LOGIN_URI;

		if (filterConfig == null){
			return;
		}
		
		GeCompUserHttpSession session = (GeCompUserHttpSession) request.getSession().getAttribute("GeCompUserHttpSession");//FIXME:La sessione GeCompUserSession e' sempre nulla
		if (Eval.isNull(session)) {//Sessione non esistente, redirigere verso pagina di login
			logger.warn("Richiesta pervenuta da host [" + request.getRemoteHost() + "," + request.getRemoteAddr() + "] con sessione non presente, redirigo verso pagina di login");
			if (!request.getRequestURI().contains(LOGIN_URI)) {
				response.sendRedirect(target);
				return;
			}
		} else {
			Calendar actualTime = Calendar.getInstance();
			if (actualTime.after(session.getExpireDate())) {//Sessione presente ma scaduta, redirigo verso la pagina di login
				logger.warn("Richiesta pervenuta da host [" + request.getRemoteHost() + "," + request.getRemoteAddr() + "] con sessione presente ma scaduta, redirigo verso pagina di login");
				response.sendRedirect(target);
				return;
			} else {//Tutto ok, sessione presente e valida
				try {
					PropertiesDelegate delegate = new PropertiesDelegate();
					String sessionOffset = delegate.get(PropertiesView.SESSION_OFFSET).getValore();
					actualTime.add(Calendar.MINUTE, Integer.valueOf(sessionOffset).intValue());
					session.setExpireDate(actualTime.getTime());
					logger.info("Sessione aggiornata per l'utente " + session.getLoggedUser().getUsername());
				} catch (Exception e) {
					logger.error("Non e' stato possibile aggiornare l'expiration date per l'utente " + session.getLoggedUser().getUsername());
				}
			}
		}
		
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		logger.info("For request [" + request.getRequestURI() + "] took time : " + (after - before) + "ms");

	}
	
}
