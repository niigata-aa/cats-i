<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録(確認画面)</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<p>※以下の内容で動物情報情報を登録しますか？</p>

	<%request.setCharacterEncoding("utf-8"); %>

	
	<jsp:useBean id ="inputAnimal" scope = "session" class ="model.entity.AnimalBean"/>
	
	
	
	動物ID　:　<jsp:getProperty name = "inputAnimal" property = "animalID"/><br>
	
	名前　:　<jsp:getProperty name = "inputAnimal" property = "name"/><br>
	
	
	種族　:　<jsp:getProperty name = "inputAnimal" property = "animalType"/><br>
	
	品種　:　<jsp:getProperty name = "inputAnimal" property = "kindID"/><br>
	
	所属エリアID　:　<jsp:getProperty name = "inputAnimal" property = "areaID"/><br>
	
	誕生日　:　<jsp:getProperty name = "inputAnimal" property = "birthDay"/><br>
	
	出身　:　<jsp:getProperty name = "inputAnimal" property = "country"/><br>
	
	
	性別　:　<jsp:getProperty name = "inputAnimal" property = "sex"/><br>
	
<!--	担当飼育員　:　<jsp:getProperty name = "inputAnimal" property = "keepers"/><br>-->
	
	写真　:　<jsp:getProperty name = "inputAnimal" property = "photo"/><br>
	

	
	
	
	<form action="registAnimalCheck" method="post">
		<input type="submit" value="はい">
	</form>
	
	<form action="registAnimal.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
	<%
		String returnURL = "checkRegistAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>