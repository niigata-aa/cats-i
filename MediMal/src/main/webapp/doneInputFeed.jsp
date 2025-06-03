<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食事記録（完了画面）</title>
<link rel ="stylesheet" href="style/doneStyle.css">
</head>
<body>

	<%@include file="header.jsp"%>
	<div class="around">
	<div class="message">
	食事履歴の記録が完了しました。
	
	<form action="goKarteDetail" method="post">
	<input type="submit" value="カルテ詳細画面へ">
	</form>
	</div>
	</div>
	
</body>
</html>