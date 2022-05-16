<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Player Page!</title>
</head>
<body>
	<h1>LIST Players</h1>
	<c:if test="${not empty success}">
		<h3 style="color: green">${success}</h3>
	</c:if>
	<c:if test="${not empty error}">
		<h3 style="color: red">${error}</h3>
	</c:if>
	<br />
	<form action="SearchPlayerByClubName">
		<b>Club Name:</b><input type="text" name="clubName" /><input
			type="submit" value="Search" />
	</form>
	<br />
	<table border="1">
		<tr>
			<th>Player Id</th>
			<th>Player Name</th>
			<th>Gender</th>
			<th>Birthday</th>
			<th>Address</th>
			<th>Club Name</th>
			<th>Position Play</th>
			<th>Transport Cost</th>
			<th>Details</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.playerId}</td>
				<td>${p.playerName}</td>
				<td>${p.gender}</td>
				<td>${p.birthday}</td>
				<td>${p.address}</td>
				<td>${p.clubName}</td>
				<td>${p.positionPlay}</td>
				<td>${p.transportCost}</td>
				<td><a href="DetailPlayer?playerId=${p.playerId}">detail</a></td>
				<td><a href="DeletePlayer?playerId=${p.playerId}"
					onclick="return confirm('Sure')">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertPlayer.jsp">Add New Player</a>
</body>
</html>