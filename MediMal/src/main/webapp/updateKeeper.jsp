<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員在籍情報・削除画面</title>
</head>
<body>
	<jsp:useBean id="" class="model.entity.EmployeeBean" scope="session"/>

	<form action = "updateKeeper" method="post">
	飼育員在籍情報 : <jsp:getProperty name="employee" property="">

</body>
</html>