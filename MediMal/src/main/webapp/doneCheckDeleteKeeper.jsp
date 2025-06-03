<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員削除（完了画面）</title>
<link rel ="stylesheet" href="style/doneStyle.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="around">
	<div class="message">
	従業員情報の削除が完了しました。
	<form action="resultSearchKeeper.jsp" method="post" >
	<input type="submit" value="従業員検索結果画面へ" class="btn">
	</form>
	</div>
	</div>

</body>
</html>