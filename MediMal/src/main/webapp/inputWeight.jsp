<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.entity.Weight"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体重記録画面</title>
</head>
<body>

	<%@ include file="headerLink.jsp"%>
	<form action="inputWeight" method="post"><a></a>
	
	
	

	動物ID　:　
	<%= session.getAttribute("animalID") %><br>
	
	日　付　:　
	<input type="datetime-local" name = "inputTime"><br>
	飼育員ID　:　
	<input type="text" name="empID" value=<%=session.getAttribute("LoginID") %>><br>
	
	今日の体重:
	<input type="number" name="weight" min="0">
	
	<select name="weightUnit">
		<option value="g">g
		<option value="kg">kg
	</select><br>
	
	<input type="submit" value="記録">
	</form>
	<%
		String returnURL = "inputWeight.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>