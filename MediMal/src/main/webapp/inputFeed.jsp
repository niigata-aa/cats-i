<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import= "model.entity.Feed"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>食事記録画面</title>
</head>
<body>
	<%@include file="headerLink.jsp" %>
	<form action="inputFeed" method="post">
	動物ID　:　
	<input type="text" name="animalID"><br> 
<!--	動物ID　:　-->
<!--	<%=request.getParameter("animalID")%><br>-->
	食事時間　:　
	<input type="datetime-local" name = "date"><br>
	従業員ID　:　
	<input type="text" name="empID"><br>
	食事内容　:　
	<input type="text" name="feedContent"><br>
	食事量　　:　
	<input type="number" name="feedAmount">
	
	
	<select name="feedUnit">
		<option value="g">g
		<option value="kg">kg
	</select><br>
	
	
	<input type="submit" value="記録">
	</form>
	
</body>
</html>