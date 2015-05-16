<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC - Location Form</title>
<c:set var="root" scope="session" value="${pageContext.request.contextPath}" />
<link rel="shortcut icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<link rel="icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
</head>
<body>

	<sf:form method="post" id="details" action="${root}/locations/locationsave" commandName="location">

		<!-- Additional hidden fields are for passing all data to controller -->
		<!-- Without them these items may get overwritten with blank or null -->
		
		<sf:input type="hidden" path="id" />
		<sf:input type="hidden" path="eventId" />
		<sf:input type="hidden" path="createdDate" />
		<sf:input type="hidden" path="updatedDate" />
		<sf:input type="hidden" path="active" />

		<sf:label path="latitude">Latitude:</sf:label>
		<spring:bind path="latitude">
			<sf:input path="latitude" type="text" />
			<br /><br />
		</spring:bind>

		<sf:label path="longitude">Longitude:</sf:label>
		<spring:bind path="longitude">
			<sf:input path="longitude" type="text" />
			<br /><br />
		</spring:bind>

		<sf:label path="altitude">Altitude:</sf:label>
		<spring:bind path="altitude">
			<sf:input path="altitude" type="text" />
			<br /><br />
		</spring:bind>

		<input type="submit" value="Submit" />

	</sf:form>

</body>
</html>
