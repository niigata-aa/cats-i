<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物削除（確認画面）</title>
</head>
<body>
	<%@include file="headerLink.jsp"%>
	<p>※【確認】動物情報を削除しますか？</p>


	<%request.setCharacterEncoding("utf-8"); %>

	

	<form action="deleteAnimalCheck" method="post">
		<input type="submit" value="はい">
	</form>

	<form action="updateAnimal.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>
	<%
		String returnURL = "checkDeleteAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>