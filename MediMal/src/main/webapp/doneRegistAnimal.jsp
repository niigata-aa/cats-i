<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録（確認画面）</title>
<link rel ="stylesheet" href="style/doneStyle.css">
</head>
<body>
	<%@include file="headerLink.jsp" %>
	<div class="around">
	<div class="message">
	動物登録が完了しました。
	<form action="goKarteDetail" method="post">
	<input type="submit" value="カルテ詳細画面へ" class="btn">
	</form>
	
	<%
		String returnURL = "doneRegistAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
	</div>
	</div>
</body>
</html>