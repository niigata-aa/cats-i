<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録（確認画面）</title>
</head>
<body>
	<%@include file="headerLink.jsp" %>

	動物登録が完了しました。
	<form action="goKarteDetail" method="post">
	<input type="submit" value="カルテ詳細画面へ">
	</form>
</body>
</html>