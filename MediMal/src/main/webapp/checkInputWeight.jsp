<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.Weight" %>
   <%@page  %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体重記録画面(確認画面)</title>
<link rel ="stylesheet" href="style/insertStyle.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<div class="A">
	<h3>＜体重記録＞</h3>
	
	<p>※以下の内容で体重を記録しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="inputWeight" scope = "session" class ="model.entity.Weight"/>
	
	　　動物ID　:　<jsp:getProperty name = "inputWeight" property = "animalID"/><br>
	
	
	　　日　付　:　<jsp:getProperty name = "inputWeight" property = "inputTime"/><br>
	
	　飼育員ID　:　<jsp:getProperty name = "inputWeight" property = "empID"/><br>
	
	今日の体重　:　<jsp:getProperty name = "inputWeight" property = "weight"/>
	
	<jsp:getProperty name="inputWeight" property="weightUnit"/>
	
	</div>
	
	<form action="inputWeightCheck" method="post"  >
	<input type="submit" value="はい" class="btn_left">
	</form>
	<form action="inputWeight.jsp" method="post">
	<input type="submit" value="いいえ" class="btn_right">
	</form>
	
	
</body>
</html>