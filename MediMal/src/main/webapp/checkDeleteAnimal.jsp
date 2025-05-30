<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物削除（確認画面）</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<p>※【確認】動物情報を削除しますか？</p>


	<%request.setCharacterEncoding("utf-8"); %>

	<!--	<jsp:useBean id ="deleteAnimal" scope = "session" class ="model.entity.EmployeeBean"/>-->


	<!--	従業員ID : <jsp:getProperty name = "deleteAnimal" property = "animalID"/><br>-->


	<form action="deleteAnimalCheck" method="post">
		<input type="submit" value="はい">
	</form>

	<form action="updateAnimal.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>

</body>
</html>