<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録画面</title>
</head>
<body>

	<form action = "registAnimal" method = "post">
	
		動物ID　:　
		<input type = "text" name = "animalID"><br>
		名前　:　
		<input type = "text" name = "name"><br>
		種族　:　
		<input type = "text" name = "animalType"><br>
		品種　:　
		<input type = "number" name="kindID"><br>
		所属エリアID　:　
		<input type = "number" name = "areaID"><br>
		生年月日　:　
		<input type = "date" name = "birthDay"><br>
		出身地　:　
		<input type = "text" name = "country"><br>
		性別　:　
		<input type = "text" name = "sex"><br>
<!--		担当飼育員:-->
<!--		<input type = "text" name = "keepers"><br>-->
		写真　:　
		<input type = "text" name = "photo"><br>


		<input type = "submit" value = "登録">


	</form>
</body>
</html>