<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.entity.Feed"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食事記録画面（確認画面）</title>
</head>
<body>
<%@include file="header.jsp" %>


<p>※以下の内容で食事履歴を記録しますか？</p>
	
	<%request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id ="inputFeed" scope = "session" class ="model.entity.Feed"/>
	
	動物ID　:　<jsp:getProperty name = "inputFeed" property = "animalID"/><br>
	
	食事時間　:　<jsp:getProperty name = "inputFeed" property = "feedTime"/><br>
	
	飼育員ID　:　<jsp:getProperty name = "inputFeed" property = "empID"/><br>
	
	食事内容　:　<jsp:getProperty name = "inputFeed" property = "feedContent"/>
	
	食事量　　:　<jsp:getProperty name = "inputFeed" property = "feedAmount"/>
	
	<jsp:getProperty name="inputFeed" property="feedUnit"/>
	
	

	<form action="inputFeedCheck" method="post">
	<input type="submit" value="はい">
	</form>
	<form action="inputFeed" method="post">
	<input type="submit" value="いいえ">
	</form>

</body>
</html>