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

	<form action="searchAllKeeper" method="post">
		<input type="submit" value="動物一覧表示">
	</form>
	
	<form action="searchAnimal" method="post">
		動物ID :
		<input type="text" name="animalID">キーワードを入力してください<br>
		名前 :
		<input type="text" name="animalName">キーワードを入力してください<br>
		種族 :
		<input type="text" name="typeName">キーワードを入力してください<br>
		所属エリア :
		<input type="text" name="areaName">キーワードを入力してください<br>
		
		<!--  
		担当飼育員 :
		<input type="text" name="keeperName">キーワードを入力してください
		-->
		
		<input type="submit" value="検索">
	</form>	
</body>
</html>