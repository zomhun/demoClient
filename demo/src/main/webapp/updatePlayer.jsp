<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Player Page!</title>
</head>
<body>
	<h1>UPDATE PLAYER</h1>
	<h3 style="color:red">${error}</h3>
	
	<form action="UpdatePlayer" method="post">
		<table>
			<tr>
				<td>Player Id</td>
				<td><input type="text" name="playerId" value="${p.playerId}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Player Name</td>
				<td><input type="text" name="playerName" value="${p.playerName}"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="true" ${p.gender?"checked":""}/>Male
				<input type="radio" name="gender" value="false" ${!p.gender?"checked":""}/>Female</td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td><input type="date" name="birthday"  value='<fmt:formatDate pattern="yyyy-MM-dd" value="${p.birthday}"/>'/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea name="address">${p.address}</textarea></td>
			</tr>
			<tr>
				<td>Club Name:</td>
				<td><input type="text" name="clubName" value="${p.clubName}"/></td>
			</tr>
			<tr>
				<td>Position Play</td>
				<td><input type="text" name="positionPlay" value="${p.positionPlay}"/></td>
			</tr>
			<tr>
				<td>Transport Cost</td>
				<td><input type="number" name="transportCost" value="${p.transportCost}"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"/>
				<input type="reset" value="Clear"/></td>
			</tr>
		</table>
	</form>
	<a href="DetailPlayer?playerId=${p.playerId}">Back</a>
</body>
</html>