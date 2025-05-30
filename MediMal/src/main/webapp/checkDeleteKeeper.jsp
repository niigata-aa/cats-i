<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員削除（確認画面）</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<p>※【確認】従業員情報を削除しますか？</p>


	<%request.setCharacterEncoding("utf-8"); %>
	
<!--	<jsp:useBean id ="deleteEmployee" scope = "session" class ="model.entity.EmployeeBean"/>-->
	
	
<!--	従業員ID : <jsp:getProperty name = "deleteEmployee" property = "empID"/><br>-->


	<form action="deleteKeeperCheck" method="post">
		<input type="submit" value="はい">
	</form>

	<form action="updateKeeper.jsp" method="post">
		<input type="submit" value="いいえ">
	</form>

</body>
</html>