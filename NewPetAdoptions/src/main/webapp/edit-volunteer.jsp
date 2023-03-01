<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing Volunteer</title>
</head>
<body>
	<form action = "editVolunteerServlet" method="post">
		<input type="hidden" name="id" value="${volunteerToEdit.id}">
		Volunteer Name: <input type="text" name="volunteerName" value="${volunteerToEdit.volunteerName}"><br />

		Available Pets:<br />
		Hold Ctrl to select multiple<br />
		
		<select name="allPetsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allPets}" var="currentPet">
				<option value="${currentPet.id}">${currentPet.name} | ${currentPet.species} | ${currentPet.age}</option>
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Edit Volunteer and Add Pets">
	</form>
	<a href="index.html">Go add new pets instead.</a>
</body>
</html>