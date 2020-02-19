<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W#C//DTD HTML 4.01 Transitional//EN" "http://www.org/T/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" charset="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div>
		<h1>Employee List For TestApp</h1>
		<table border="0">
			<th>Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>
			
			<c:forEach var="staff" items="${listStaff}">
				<tr>
					<td>${staff.name}</td>
					<td>${staff.password}</td>
					<td>${staff.email}</td>
					<td>${staff.address}</td>
					<td>${staff.telephone}</td>
					<td><a href="editStaff?id=${staff.id}">Edit</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteStaff?id=${staff.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<h4>New Employee Register<a href="newStaff">here</a></h4>
</body>
</html>