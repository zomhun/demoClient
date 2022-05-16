<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Player Page!</title>
</head>
<body>
	<h1>INSERT Player</h1>
	<h3 style="color:red">${error}</h3>
	
	<form action="InsertPlayer" method="post">
		<table>
			<tr>
				<td>Player Name</td>
				<td><input type="text" name="playerName"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="true"/>Male
				<input type="radio" name="gender" value="false"/>Female</td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td><input type="date" name="birthday"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea name="address"></textarea></td>
			</tr>
			<tr>
				<td>Club Name:</td>
				<td><input type="text" name="clubName"/></td>
			</tr>
			<tr>
				<td>Position Play</td>
				<td><input type="text" name="positionPlay"/></td>
			</tr>
			<tr>
				<td>Transport Cost</td>
				<td><input type="number" name="transportCost"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Insert"/>
				<input type="reset" value="Clear"/></td>
			</tr>
		</table>
	</form>
</body>
</html>