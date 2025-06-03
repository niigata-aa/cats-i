<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.entity.Weight"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体重記録画面</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>

	<%@ include file="headerLink.jsp"%>
	<form action="inputWeight" method="post"><a></a>
	
	
	<div class="A">
	<h3>＜体重記録＞</h3>

	　　動物ID　:　
	<%= session.getAttribute("animalID") %><br>
	
	　　　日付　:　
	<input type="datetime-local" name = "inputTime" 
	class="textbox_time" required placeholder="入力してください"><br>
	　飼育員ID　:　
	<input type="text" name="empID" value=<%=session.getAttribute("LoginID") %> class="textbox"><br>
	
	今日の体重　:　
	<input type="number" name="weight" min="0" class="textbox" 
	pattern="[0-9]+" required placeholder="数字で入力してください">
	
	<select name="weightUnit" class="textbox_unit">
		<option value="g">g
		<option value="kg" selected>kg
	</select><br>
	
	</div>
	
	<input type="submit" value="記録" class="btn">
	</form>
	
	<form action="searchAllAnimal" method="post">
		<input type="submit" value="動物一覧に戻る">
	</form>
	
	<%
		String returnURL = "inputWeight.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>