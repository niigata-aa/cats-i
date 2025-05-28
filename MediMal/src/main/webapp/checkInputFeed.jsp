<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="model.entity.Feed"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食事記録画面（確認画面）</title>
</head>
<body>

	<% Feed inputFeed = (Feed)request.getAttribute("inputFeed"); %>
	
	動物ID　　:　
	<%=inputFeed.getAnimalID() %><br>
	
	食事時間　:　
	<%=inputFeed.getDate() %><br>
	
	食事内容　:　
	<%=inputFeed.getContent() %><br>
	
	食事量　　:　
	<%=inputFeed.getAmount() %><br>
	<%=inputFeed.getUnit() %>
	
	

	<form action="inputFeedCheck" method="post">
	<input type="submit" value="はい">
	</form>
	<form action="inputFeed" method="post">
	<input type="submit" value="いいえ">
	</form>

</body>
</html>