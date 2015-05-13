<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC - Event Form</title>
<c:set var="root" scope="session" value="${pageContext.request.contextPath}" />
<link rel="shortcut icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<link rel="icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
</head>
<body>

	<sf:form method="post" id="details" action="${root}/events/eventsave" commandName="event">

		<!-- Additional hidden fields are for passing all data to controller -->
		<!-- Without them these items may get overwritten with blank or null -->
		
		<sf:input type="hidden" path="id" />
		<sf:input type="hidden" path="userId" />
		<sf:input type="hidden" path="createdDate" />
		<sf:input type="hidden" path="updatedDate" />
		<sf:input type="hidden" path="active" />
		<sf:input type="hidden" path="eventIdTimestamp" />

		<sf:label path="event">Event:</sf:label>
		<spring:bind path="event">
			<sf:textarea path="event" />
			<br /><br />
		</spring:bind>

		<input type="submit" value="Submit" />

	</sf:form>

</body>
</html>
