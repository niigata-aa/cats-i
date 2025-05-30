<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物検索画面</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>

	<form action="searchAllAnimal" method="post">
		<input type="submit" value="動物一覧表示">
	</form>
	
	<form action="searchAnimal" method="post">
		動物ID :
		<input type="text" name="animalID"placeholder="キーワードを入力"><br>
		名前 :
		<input type="text" name="animalName"placeholder="キーワードを入力"><br>
		種族 :
		<input type="text" name="typeName"placeholder="キーワードを入力"><br>
		所属エリア :
		<input type="text" name="areaName"placeholder="キーワードを入力"><br>
		
		<!--  
		担当飼育員 :
		<input type="text" name="keeperName">キーワードを入力してください
		-->
		
		<input type="submit" value="検索">
	</form>	
</body>
</html>