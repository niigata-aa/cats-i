<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物削除（完了画面）</title>
</head>
<body>
	<%@include file="header.jsp" %>
	動物情報の削除が完了しました。
	<form action="resultSearchKeeper.jsp" method="post" >
	<input type="submit" value="従業員検索結果画面へ">
	</form>

</body>
</html>