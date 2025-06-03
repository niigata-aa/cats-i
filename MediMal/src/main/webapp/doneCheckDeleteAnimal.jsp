<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物削除（完了画面）</title>
<link rel ="stylesheet" href="style/doneStyle.css">
</head>
<body>
	<%@include file="headerLink.jsp" %>
	<div class="around">
	<div class="message">
	動物情報の削除が完了しました。
	<form action="searchAllKeeper" method="post" >
	<input type="submit" value="従業員一覧画面へ" class="btn">
	</form>
	</div>
	</div>

</body>
</html>