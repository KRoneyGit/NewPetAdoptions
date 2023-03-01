<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Volunteers</title>
</head>
<body>
	<form method="post" action="volunteerNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allVolunteers}" var="currentVolunteer">
				<tr>
					<td><input type="radio" name="id" value="${currentVolunteer.id}"></td>
					<td><h2>${currentVolunteer.volunteerName}</h2></td>
				<c:forEach var="pet" items="${currentVolunteer.listOfPets}">
					<tr><td></td><td colspan="3">${pet.name}, ${pet.species}, ${pet.age}</td></tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToVolunteer">
		<input type="submit" value="delete" name="doThisToVolunteer">
		<input type="submit" value="add" name="doThisToVolunteer">
	</form>
	<a href="index.html">Add a Pet</a>
</body>
</html>