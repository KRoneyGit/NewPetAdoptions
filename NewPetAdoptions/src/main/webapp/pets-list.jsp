<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Pets</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allPets}" var="currentpet">
				<tr>
					<td><input type="radio" name="id" value="${currentpet.id}"></td>
					<td>${currentpet.name}</td>
					<td>${currentpet.species}</td>
					<td>${currentpet.age}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToPet">
		<input type="submit" value="delete" name="doThisToPet">
		<input type="submit" value="add" name="doThisToPet">
	</form>
</body>
</html>