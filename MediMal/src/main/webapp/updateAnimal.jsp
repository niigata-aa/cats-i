<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物情報 編集・削除画面</title>
</head>
<body>
※編集・削除したい項目を選択してください
	<img src = "https://www.teikyo.ed.jp/wp/wp-content/themes/teikyo2018/images/test.jpg"
	width="100" height="100" alt="テスト画像">
	
	<form action ="updateAnimal" method="post">
		動物在籍情報 :         
		<input type = "radio" name = "livingnow" value="在籍">在籍
		<input type = "radio" name = "livingnow" value="退籍">退籍
		<br>
		動物ID :
		<input type="text" name="animalID" >
		生年月日　: 
		<input type="text" name="birthDay" ><br>
		名前 : 
		<input type="text" name="name" >
		出身 : 
		<input type="text" name="country" ><br>
		種族 : 
		<input type="text" name="animalType" >
		性別 : 
		<input type="text" name="sex" ><br>
		エリア情報 : 
		<input type="text" name="area" >
		飼育員情報 :
		 <input type="text" name="keepers" ><br>

		<input type="submit" value="編集">
		<input type="submit" value="削除">

	</form>
</body>
</html>