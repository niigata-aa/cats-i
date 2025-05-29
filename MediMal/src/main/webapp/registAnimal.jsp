<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録画面</title>
</head>
<body>

	<form action = "registAnimal" method = "post">
	
		動物ID:
		<input type = "text" name = "animal"><br>
		名前:
		<input type = "text" name = “Name”><br>
		種族:
		<input type = text name = "type"><br>
		エリア情報:
		<input type = "text" name = "area"><br>
		生年月日:
		<input type = "number" name = "birthDay"><br>
		出身地:
		<input type = "date" name = "countryOfBirth"><br>
		性別:
		<input type = "text" name = "sex"><br>
		担当飼育員:
		<input type = "text" name = "keepers"><br>
		写真:
		<input type = "text" name = "photo"><br>


		<input type = "submit" value = "登録">


	</form>
</body>
</html>