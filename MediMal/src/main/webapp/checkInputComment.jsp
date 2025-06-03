<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.AnimalComment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント記入（確認画面）</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>

	<%@ include file="header.jsp"%>
	
	<div class="A">
	<h3>＜コメント記入＞</h3>
	
	<p>※以下の内容でコメントを記入しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="inputComment" scope = "session" class ="model.entity.AnimalComment"/>
	
	動物ID　:　<jsp:getProperty name = "inputComment" property = "animalID"/><br>
	
	
	入力日　:　<jsp:getProperty name = "inputComment" property = "commentTime"/><br>
	
	飼育員ID　:　<jsp:getProperty name = "inputComment" property = "empID"/><br>
	
	
	
	<br>
	＜記入したコメント＞
	<br>
	<jsp:getProperty name = "inputComment" property = "content"/>

	</div>
	

	<form action="inputCommentCheck" method="post">
	<input type="submit" value="はい" class="btn_left_comment_check">
	</form>
	<form action="inputComment.jsp" method="post">
	<input type="submit" value="いいえ" class="btn_right_comment_check">
	</form>





</body>
</html>