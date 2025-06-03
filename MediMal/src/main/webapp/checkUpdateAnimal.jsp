<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物情報編集確認画面1</title>
</head>
<body>

<p>※以下の内容で動物情報を編集しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="updateAnimal" scope = "session" class ="model.entity.AnimalBean"/>
	飼育員在籍情報 :
	
	
	動物ID : <jsp:getProperty name = "updateAnimal" property = "animalID"/>
	
	生年月日 : <jsp:getProperty name = "updateAnimal" property = "birthDay"/><br>
	
	名前 : <jsp:getProperty name = "updateAnimal" property = "name"/>
	
	出身 : <jsp:getProperty name = "updateAnimal" property = "country"/><br>
	
	種族 : <jsp:getProperty name = "updateAnimal" property = "animalKind"/>
	
	性別　: <jsp:getProperty name = "updateAnimal" property = "sex"/><br>
	
	エリア情報:  <jsp:getProperty name = "updateAnimal" property = "area"/>
	
	担当飼育員 : <br>
	
	写真 : <img src="/MediMal/image/<jsp:getProperty name = "updateAnimal" property = "photo"/>" width="100" height="100">
	<br>
	
	<form action="updateAnimalCheck" method="post">
		<input type="submit" value="はい">
	</form>
	
	<form action="updateAnimal.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
	
</body>
</html>