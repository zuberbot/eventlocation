<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<c:set var="root" scope="session" value="${pageContext.request.contextPath}" />
<link rel="shortcut icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<link rel="icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
</head>
<body>
<h2>Home of Spring MVC Java Config!</h2>
<p>
<a href="${root}/SpringMvc">String SPRING_MVC_URL = "/SpringMvc";</a><br />
<a href="${root}/SpringMvc/locations">String LOCATIONS_URL = "/SpringMvc/locations";</a><br />
<a href="${root}/users/userlist">String USER_LIST_URL = "/users/userlist";</a><br />
</p>
</body>
</html>
