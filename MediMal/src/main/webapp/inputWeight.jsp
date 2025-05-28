<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import= "java.util.Date, java.text.SimpleDateFormat"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体重記録画面</title>
</head>
<body>
	<form action="inputWeight" method="post">
	動物ID　:　
	<% session.getAttribute("animalID"); %>
	日　付　:　
	<input type="SimpleDateFormat" name = "inputDate"><br>
	今日の体重:
	<input type="number" name="measureWeight">
	
	<select name="unit">
		<option value="g">g
		<option value="kg">kg
	</select><br>
	
	<input type="submit" value="記録">
	</form>
	
</body>
</html>