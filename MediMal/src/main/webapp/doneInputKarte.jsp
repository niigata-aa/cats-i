<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投薬情報・出産情報</title>
<link rel ="stylesheet" href="style/doneStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<div class="around">
	<div class="message">
	投薬情報・出産情報の記録が完了しました。

	<form action="goKarteDetail" method="post">
		<input type="submit" value="カルテ詳細画面へ" class="btn">
	</form>
	</div>
	</div>

</body>
</html>