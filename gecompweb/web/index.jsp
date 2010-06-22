<%@page import="net.sb.gecomp.utils.logger.GeCompLogger"%>
<%
	GeCompLogger logger = GeCompLogger.getGeCompLogger("index.jsp");
  	final String contextRoot = request.getContextPath();
  	logger.info("contextRoot="+contextRoot);
  	
  	final String target = contextRoot + "/main/login/login.jsf";
  	logger.info("target="+target);
  	
  	response.sendRedirect(target);
%>
<html><body></body></html>
