<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "model.entity.Feed"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食事記録画面</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>
	<%@include file="headerLink.jsp" %>
	<form action="inputFeed" method="post">
	
	<div class="A">
	<h3>＜食事記録＞</h3>
	
	　動物ID　:　
	<%= session.getAttribute("animalID") %><br> 
	食事時間　:　
	<input type="datetime-local" name = "feedTime" class="textbox_time" required><br>
	従業員ID　:　
	<input type="text" name="empID" value=<%=session.getAttribute("LoginID") %>  class="textbox"><br>
	食事内容　:　
	<input type="text" name="feedContent"  class="textbox" required><br>
	食事量　　:　
	<input type="number" name="feedAmount" min="0"  class="textbox" 
	pattern="[0-9]+" required placeholder="数字で入力してください">
	
	
	<select name="feedUnit" class="textbox_unit">
		<option value="g">g
		<option value="kg" selected>kg
	</select><br>
	
	</div>
	<input type="submit" value="記録" class="btn">
	</form>
	
	<form action="searchAllAnimal" method="post">
		<input type="submit" value="動物一覧に戻る">
	</form>
	
	<form action="searchAllAnimal" method="post">
		<input type="submit" value="動物一覧に戻る">
	</form>
	
	<%
		String returnURL = "inputFeed.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>