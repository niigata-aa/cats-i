<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物情報編集確認画面2</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>
<%@ include file="headerLink.jsp"%>
<div class="A">
<p>※【最終確認】以下の内容で動物情報を編集しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="updateAnimal" scope = "session" class ="model.entity.AnimalBean"/>
	　動物在籍情報 :
	<%if (Integer.parseInt((String)session.getAttribute("livingNow"))==1){ %>
	<br>
	<%}else{ %>
	離園として登録します。<br>
	<%} %>
	
	　　　　動物ID : <jsp:getProperty name = "updateAnimal" property = "animalID"/><br>
	
	　　　生年月日 : <jsp:getProperty name = "updateAnimal" property = "birthDay"/><br>
	
	　　　　　名前 : <jsp:getProperty name = "updateAnimal" property = "name"/><br>
	
	　　　　　出身 : <jsp:getProperty name = "updateAnimal" property = "country"/><br>
	
	　　　　　種族 : <jsp:getProperty name = "updateAnimal" property = "animalKind"/><br>
	
	　　　　　性別 : <jsp:getProperty name = "updateAnimal" property = "sex"/><br>
	
	　　エリア情報: <jsp:getProperty name = "updateAnimal" property = "area"/><br>
	
	　　　　　写真 : <img src="/MediMal/image/<jsp:getProperty name = "updateAnimal" property = "photo"/>" width="100" height="100"><br>
	
	<form action="finalUpdateAnimalCheck" method="post">
		<input type="submit" value="はい" class="btn_left_comment_check">
	</form>
	
	<form action="updateAnimal.jsp" method="post">
		<input type="submit" value="いいえ" class="btn_right_comment_check">
	</form>
	</div>
</body>
</html>