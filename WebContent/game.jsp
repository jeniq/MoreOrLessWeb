<%@page import="servlet.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "/MoreOrLessWeb">New game</a>
	<div align="center">
		<h1>Game</h1>
		<p>Try to guess the number.</p>
		<c:out value="${result}"/>
		<p>
		Range is (<c:out value="${game.getMinValue()};${game.getMaxValue()}"/>)</p>
		<p>Enter your variant to the field:</p>
		<form method="GET" action="CheckResult">
			<table>
				<tr>
					<td><input type="number" name="userNumber" value="0"></td>
				</tr>
				<tr align="center">
					<td><p>
							<input type="submit" value="Check">
						</p></td>
				</tr>
			</table>
		</form>
		<c:forEach var="a" items="${game.getHistory()}">
			<c:out value="${a}"/><br>
		</c:forEach>
	</div>
</body>
</html>