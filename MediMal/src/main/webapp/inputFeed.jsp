<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import= "java.util.Date, java.text.SimpleDateFormat"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食事記録画面</title>
</head>
<body>
	<form action="inputFeed" method="post">
	動物ID　　:　
	<input type="text" name="animalID" ><br>
	食事時間　:　
	<input type="SimpleDateFormat" name = "date"><br>
	食事内容　:　
	<input type="text" name="content"><br>
	食事量　　:　
	<input type="number" name="amount">
	
	<select name="unit">
		<option value="g">g
		<option value="kg">kg
	</select><br>
	
	<input type="submit" value="記録">
	</form>
	
</body>
</html>