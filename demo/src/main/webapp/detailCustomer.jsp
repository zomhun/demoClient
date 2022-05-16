<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Player Page!</title>
</head>
<body>
	<h1>DETAIL PLAYER</h1>
		<table>
			<tr>
				<td>Player Id</td>
				<td>${p.playerId}</td>
			</tr>
			<tr>
				<td>Player Name</td>
				<td>${p.playerName}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${p.gender?"Male":"Female"}</td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td>${p.birthday}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${p.address}</td>
			</tr>
			<tr>
				<td>Club Name:</td>
				<td>${p.clubName}</td>
			</tr>
			<tr>
				<td>Position Play</td>
				<td>${p.positionPlay}</td>
			</tr>
			<tr>
				<td>Transport Cost</td>
				<td>${p.transportCost}</td>
			</tr>		
			<tr>
				<td>
					<a href="index.jsp">Back</a>
				</td>
				<td>
					<a href="InitUpdatePlayer?playerId=${p.playerId}">update</a>
				</td>
			</tr>	
		</table>
		
</body>
</html>