<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物編集画面(完了画面)</title>
</head>
<body>
	<%@include file="header.jsp"%>
	動物情報の編集が完了しました。
	
	<form action="goKarteDetail" method="post">
		<input type="submit" value="カルテ詳細画面へ">
	</form>
</body>
</html>