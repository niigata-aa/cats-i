<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物削除（確認画面）</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>
	<%@include file="headerLink.jsp"%>
	
	<div class="A">
	<p>※【確認】動物情報を削除しますか？</p>


	<%request.setCharacterEncoding("utf-8"); %>

	</div>

	<form action="deleteAnimalCheck" method="post">
		<input type="submit" value="はい" class="btn_left">
	</form>

	<form action="updateAnimal.jsp" method="post">
		<input type="submit" value="いいえ" class="btn_right">
	</form>
	<%
		String returnURL = "checkDeleteAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>