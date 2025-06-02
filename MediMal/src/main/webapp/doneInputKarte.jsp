<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投薬情報・出産情報</title>
</head>
<body>
<%@include file="headerLink.jsp" %>
	<%@ include file="headerLink.jsp"%>
	投薬情報・出産情報の記録が完了しました。

	<form action="goKarteDetail" method="post">
		<input type="submit" value="カルテ詳細画面へ">
	</form>

</body>
</html>