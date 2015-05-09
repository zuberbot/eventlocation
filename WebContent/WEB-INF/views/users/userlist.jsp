<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC - User List</title>
<c:set var="root" scope="session" value="${pageContext.request.contextPath}" />
<link rel="shortcut icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<link rel="icon" href="${root}/imgs/favicon.ico" type="image/x-icon">
<style>
table, td, th {
	border-collapse: collapse;
    border: 1px solid green;
}

th {
    background-color: green;
    color: white;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Users List</h1>
		<h2>
			<a href="${root}/users/usernew">New User</a>
		</h2>

		<table>
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Created Date</th>
				<th>Updated Date</th>
				<th>Events</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach var="user" items="${userList}" varStatus="status">
				<tr>
					<td>${user.id}</td>
					<td>${user.userName}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.phone}</td>
					<td>${user.email}</td>
					<td>${user.createdDate}</td>
					<td>${user.updatedDate}</td>
					<td><a href="${root}/events/eventlist?id=${user.id}">Events</a></td>
					<td><a href="${root}/users/useredit?id=${user.id}">E</a> - <a href="${root}/users/userdelete?id=${user.id}">D</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
