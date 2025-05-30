<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物情報編集確認画面2</title>
</head>
<body>

<p>※【最終確認】以下の内容で動物情報を編集しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="updateAnimal" scope = "session" class ="model.entity.AnimalBean"/>
	飼育員在籍情報 :
	<%if (Integer.parseInt((String)session.getAttribute("livingNow"))==1){ %>
	復職により飼育動物として再登録します。<br>
	<%}else{ %>
	離園として登録します。<br>
	<%} %>
	
	動物ID : <jsp:getProperty name = "updateAnimal" property = "AnimalID"/>
	
	生年月日 : <jsp:getProperty name = "updateAnimal" property = "birthDay"/><br>
	
	名前 : <jsp:getProperty name = "updateAnimal" property = "name"/>
	
	出身 : <jsp:getProperty name = "updateAnimal" property = "country"/><br>
	
	種族 : <jsp:getProperty name = "updateEmployee" property = "firstName"/>
	
	性別　: <jsp:getProperty name = "updateEmployee" property = "gender"/><br>
	
	エリア情報:  <jsp:getProperty name = "updateEmployee" property = "areaID"/>
	
	担当飼育員 : <br>
	
	写真 : <jsp:getProperty name = "updateAnimal" property = "photo"/><br>
	
	<form action="finaUpdateAnimalCheck" method="post">
		<input type="submit" value="はい">
	</form>
	
	<form action="checkUpdateAnimal.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
	
</body>
</html>