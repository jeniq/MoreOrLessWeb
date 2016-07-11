<%@page import="servlet.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Game</h1>
		<p>Try to guess the number.</p>
		<p>
		<% 
			int minVal = (int)session.getAttribute(Constant.MIN_VALUE);
			int maxVal = (int)session.getAttribute(Constant.MAX_VALUE);
		%>
		Range is (<%= minVal %>;<%= maxVal %>)</p>
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
	</div>
</body>
</html>