<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Volunteer</title>
</head>
<body>
	<form action="createNewVolunteerServlet" method="post">
		Volunteer Name: <input type="text" name="volunteerName"><br />
		Add Pets:<br />
		Hold Ctrl to select multiple<br />
		<select name="allPetsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allPets}" var="currentPet">
				<option value="${currentPet.id}">${currentPet.name} | ${currentPet.species} | ${currentPet.age}</option>
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Create Volunteer and Add Pets">
	</form>
	<a href="index.html">Go add new pets instead.</a>
</body>
</html>