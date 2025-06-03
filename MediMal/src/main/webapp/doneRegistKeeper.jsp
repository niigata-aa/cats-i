<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員登録画面（完了画面）</title>
<link rel ="stylesheet" href="style/doneStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<div class="around">
	<div class="message">
	従業員の登録が完了しました。
	<form action="goMenu" method="post">
		<input type="submit" value="メニュー画面に戻る" class="btn">
	</form>
	</div>
	</div>
	<%
		String returnURL = "doneRegistKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>