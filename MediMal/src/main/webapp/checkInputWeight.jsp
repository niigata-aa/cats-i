<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.Weight" %>
   <%@page  %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体重記録画面(確認画面)</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<p>※以下の内容で体重を記録しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="inputWeight" scope = "session" class ="model.entity.Weight"/>
	
	動物ID　:　<jsp:getProperty name = "inputWeight" property = "animalID"/><br>
	
	
	日　付　:　<jsp:getProperty name = "inputWeight" property = "inputTime"/><br>
	
	飼育員ID　:　<jsp:getProperty name = "inputWeight" property = "empID"/><br>
	
	今日の体重:　<jsp:getProperty name = "inputWeight" property = "weight"/>
	
	<jsp:getProperty name="inputWeight" property="weightUnit"/>
	
	
	
	<form action="inputWeightCheck" method="post">
	<input type="submit" value="はい">
	</form>
	<form action="inputWeight.jsp" method="post">
	<input type="submit" value="いいえ">
	</form>
	
	
</body>
</html>