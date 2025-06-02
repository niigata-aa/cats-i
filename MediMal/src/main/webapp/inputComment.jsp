<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント記入画面</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<form action="inputComment" method="post">

			
	動物ID　:　
	<%= session.getAttribute("animalID") %>
	<br>
	入力日　:　
	<input type="datetime-local" name="commentTime">
	<br>
	従業員ID　:　
	<input type="text" name="empID" value=<%=session.getAttribute("LoginID") %>>
	<br>
	<br>
	
	
	
	※コメントを記入してください
	<br>
	
	<textarea  name="content" id="content" rows="10" cols="70"></textarea>
	<br>
	
	
	
	<input type="submit" value="記入">
	</form>

</body>
</html>