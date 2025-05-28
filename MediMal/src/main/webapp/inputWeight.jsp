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
	<p>動物ID　:　</p>
	<input type="text" name="animalID" ><br>
	<p>日　付　:　</p>
	<input type="SimpleDateFormat" name = "inputDate"><br>
	<p>今日の体重:</p>
	<input type="number" name="measureWeight">
	
	<select name="unit">
		<option value="k">
		<option value="kg">
	</select><br>
	
	<input type="submit" value="記録">
	</form>
	
</body>
</html>