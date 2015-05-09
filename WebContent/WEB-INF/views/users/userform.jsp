<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC - User Form</title>
<c:set var="root" scope="session" value="${pageContext.request.contextPath}" />
<link rel="shortcut icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<link rel="icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
</head>
<body>

	<sf:form method="post" id="details" action="${root}/users/usersave" commandName="user">

		<!-- Additional hidden fields are for passing all data to controller -->
		<!-- Without them these items may get overwritten with blank or null -->
		
		<sf:input type="hidden" path="id" />
		<sf:input type="hidden" path="createdDate" />
		<sf:input type="hidden" path="updatedDate" />
		<sf:input type="hidden" path="active" />

		<sf:label path="userName">User Name:</sf:label>
		<spring:bind path="userName">
			<sf:input path="userName" type="text" />
			<br /><br />
		</spring:bind>

		<sf:label path="firstName">First Name:</sf:label>
		<spring:bind path="firstName">
			<sf:input path="firstName" type="text" />
			<br /><br />
		</spring:bind>

		<sf:label path="lastName">Last Name:</sf:label>
		<spring:bind path="lastName">
			<sf:input path="lastName" type="text" />
			<br /><br />
		</spring:bind>

		<sf:label path="phone">Phone:</sf:label>
		<spring:bind path="phone">
			<sf:input path="phone" type="text" />
			<br /><br />
		</spring:bind>

		<sf:label path="email">Email:</sf:label>
		<spring:bind path="email">
			<sf:input path="email" type="text" />
			<br /><br />
		</spring:bind>

		<input type="submit" value="Submit" />

	</sf:form>

</body>
</html>
