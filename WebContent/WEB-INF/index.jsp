<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>zPattern Engine</title>
<c:set var="root" scope="session" value="${pageContext.request.contextPath}" />
<link rel="shortcut icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<link rel="icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
</head>
<body>
<h3>zPattern Data Engine</h3>
<%
java.util.Enumeration<String> headerNames = request.getHeaderNames();
while (headerNames.hasMoreElements()) {
	String pName = headerNames.nextElement();
	Object pVal = request.getHeader(pName);
%>
	<%=pName %> - <%=pVal.toString() %><br />
<%
}

java.util.Enumeration<String> parameterNames = request.getParameterNames();
while (parameterNames.hasMoreElements()) {
	String pName = parameterNames.nextElement();
	Object pVal = request.getParameter(pName);
%>
	<%=pName %> - <%=pVal.toString() %><br />
<%
}

String ipAddress = request.getHeader("X-FORWARDED-FOR");  
if (ipAddress == null) {  
	ipAddress = request.getRemoteAddr();  
}
%>

ip addr - <%=ipAddress %><br />

<%
String requestingURL = "";
StringBuffer requestURL = request.getRequestURL();
String queryString = request.getQueryString();

if (queryString == null) {
	requestingURL = requestURL.toString();
} else {
	requestingURL = requestURL.append('?').append(queryString).toString();
}
%>

requesting url - <%=requestingURL %><br />

auth type - <%=request.getAuthType() %><br /> 
cookies - <%=request.getCookies() %><br /> 
http method - <%=request.getMethod() %><br /> 
path info - <%=request.getPathInfo() %><br /> 
path translated - <%=request.getPathTranslated() %><br /> 
query string - <%=request.getQueryString() %><br /> 
remote user - <%=request.getRemoteUser() %><br /> 
servlet path - <%=request.getServletPath() %><br /> 
session - <%=request.getSession() %><br /> 
user principal  - <%=request.getUserPrincipal() %><br /> 
async context - <%=request.getAsyncContext() %><br />
char enconding - <%=request.getCharacterEncoding() %><br />
content length - <%=request.getContentLength() %><br />
content type - <%=request.getContentType() %><br />
dispatcher type - <%=request.getDispatcherType() %><br />
local addr - <%=request.getLocalAddr() %><br />
locale - <%=request.getLocale() %><br />
local name - <%=request.getLocalName() %><br />
local port - <%=request.getLocalPort() %><br />
parameter map - <%=request.getParameterMap() %><br />
protocol - <%=request.getProtocol() %><br />
reader - <%=request.getReader() %><br />
remote addr - <%=request.getRemoteAddr() %><br />
remote host - <%=request.getRemoteHost() %><br />
remote port - <%=request.getRemotePort() %><br />
scheme - <%=request.getScheme() %><br />
server name - <%=request.getServerName() %><br />
server port - <%=request.getServerPort() %><br />
servlet context - <%=request.getServletContext() %><br />

</body>
</html>
