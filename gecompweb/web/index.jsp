<%
  	final String contextRoot = request.getContextPath();
  	final String target = contextRoot + "/main/login/login.jsf";
  	response.sendRedirect(target);
%>
<html><body></body></html>
