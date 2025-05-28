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
	<p>※以下の内容で体重を記録しますか？</p>
	
	
	<% Weight inputWeight = (Weight)request.getAttribute("inputWeight"); %>
	
	動物ID　:　
	<%=inputWeight.getAnimalID() %><br>
	
	日　付　:　
	<%=inputWeight.getInputDate() %><br>
	
	今日の体重:
	<%=inputWeight.getMeasureWeight() %><br>
	<%=inputWeight.getUnit() %>
	
	

	<form action="inputWeightCheck" method="post">
	<input type="submit" value="はい">
	</form>
	<form action="inputWeight" method="post">
	<input type="submit" value="いいえ">
	</form>
	
	
</body>
</html>