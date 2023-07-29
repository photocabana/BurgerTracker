<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
</head>
<body>
	<h2>Edit Burger</h2>
	<form:form action="/edit/${burger.id}" mode="put" modelAttribute="burger">
		<div>
			<form:label path="name">Burger Name:</form:label><br>
			<form:errors path="name" class="error"/>
			<form:input path="name" style="width: 200px;"/>
		</div>
		<div>
			<form:label path="restaurant">Restaurant Name:</form:label><br>
			<form:errors path="restaurant" class="error"/>
			<form:input path="restaurant" style="width: 200px;"/>
		</div>
		<div>
			<form:label path="rating">Rating:</form:label><br>
			<form:errors path="rating" class="error"/>
			<form:input path="rating" style="width: 200px;"/>
		</div>
		<div>
			<form:label path="notes">Notes:</form:label><br>
			<form:errors path="notes" class="error"/>
			<form:textarea path="notes" rows="4" style="width: 250px;"/>
		</div>
		<div>
			<input type="submit" value="Submit"/>
		</div>
	</form:form>
</body>
</html>