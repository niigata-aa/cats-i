<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員削除（最終確認画面）</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<div class="A">
	<p>※【最終確認】従業員情報を削除しますか？</p>
	<form action="finalDeleteKeeperCheck" method="post">
		<input type="submit" value="はい" class="btn_left">
	</form>
	<form action="updateKeeper.jsp" method="post" >
		<input type="submit" value="いいえ" class="btn_right">
	</form>
	<%
		String returnURL = "finalCheckDeleteKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
	</div>
</body>
</html>