<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC - Event List</title>
<c:set var="root" scope="session" value="${pageContext.request.contextPath}" />
<link rel="shortcut icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<link rel="icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<c:set var="totalEvents" value="${fn:length(userEvents)}" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	$(function() {
		$(function(event) {
			// Need #click1, #click2, #click3, etc.
			<% Integer count = (Integer) pageContext.getAttribute("totalEvents"); %>
			<% for (int i = 0; i < count; i++) { %>
			$('#click<%=i%>').on('click', function(event) {
				var url = $('#click<%=i%>').attr("value");
				//$('#mapview').attr('src', url);
				$(location).attr('href', url);
			});
			<% } %>
		});
	});
</script>
<style>
table,td,th {
	border-collapse: collapse;
	border: 1px solid orange;
}

th {
	background-color: orange;
	color: white;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Events List</h1>
		<h2>
			<a href="${root}/events/eventnew?id=${userId}">New Event</a>&nbsp; <a href="${root}/users/userlist">User List</a>
		</h2>

		<table>
			<tr>
				<th>User Id</th>
				<th>Event Id</th>
				<th>Event Id Timestamp</th>
				<th>Event</th>
				<th>Location Id</th>
				<th>Latitude</th>
				<th>Longitude</th>
				<th>Altitude</th>
				<th>Created Date</th>
				<th>Updated Date</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach var="event" items="${userEvents}" varStatus="status">
				<tr>
					<td>${event.userId}</td>
					<td>${event.eventId}</td>
					<td>${event.eventIdTimestamp}</td>
					<td>${event.event}</td>
					<td>${event.locationId}</td>
					<td>${event.latitude}</td>
					<td>${event.longitude}</td>
					<td>${event.altitude}</td>
					<td>${event.createdDate}</td>
					<td>${event.updatedDate}</td>
					<td><a href="${root}/events/eventedit?id=${event.eventId}">E</a> - <a href="${root}/events/eventdelete?id=${event.eventId}">D</a> -
						<button id='click${status.index}' value='https://www.google.com/maps/@${event.latitude},${event.longitude},15z'>Map</button></td>

					<%-- https://www.google.com/maps/@33.423037,-116.388672,11z --%>
					<%-- https://www.google.com/maps?q=33.423037,-116.388672 --%>

				</tr>
			</c:forEach>
		</table>

		<br />

		<!-- https://developers.google.com/maps/documentation/embed/guide -->
		<!-- 
		<iframe id="mapview" width="600" height="450" frameborder="0" style="border: 0"
			src="https://www.google.com/maps/embed/v1/view?key=AIzaSyB0nBOnQdvv4-j0Aqu9CDYbgK3f_TeFic0&center=32.8569,-117.2152&zoom=10&maptype=roadmap">
		</iframe>
		-->
	</div>

</body>
</html>
