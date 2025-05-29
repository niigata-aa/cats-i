<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員情報編集・削除確認画面1</title>
</head>
<body>

	<!--参考コピペしてるだけです -->
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	
	以下の内容で飼育員情報を編集・削除しますか？<br>
	<jsp:useBean id="employee" scope="session" class="model.entity.EmployeeBean" />
	
	<jsp:setProperty name="employee" property="name" param="name" />
	<jsp:setProperty name="employee" property="age" param="age" />
	<jsp:setProperty name="employee" property="section" param="section" />
	
	コード：<jsp:getProperty name="employee" property="code" /><br>
	氏名：<jsp:getProperty name="employee" property="name" /><br>
	年齢：<jsp:getProperty name="employee" property="age" /><br>
	部署：<jsp:getProperty name="employee" property="section" /><br>

	<form action="employee-alter-servlet" method="POST">
		<input type="submit" value="はい">
	</form>

	<form action="employee-alter-form-servlet" method="POST">
		<input type="submit" value="いいえ">
	</form>
</body>
</html>