<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員在籍情報・削除画面</title>
</head>
<body>
	<jsp:useBean id="employee" class="model.entity.EmployeeBean" scope="session"/>

	<form action = "updateKeeper" method="post">
		飼育員在籍情報 : <input type = "radio" name="employee" property="livingNow"
		value="<jsp:getProperty name="employee" property="livingNow"/>">在籍
		
		<input type = "radio" name="employee" property="livingNow"
		value="<jsp:getProperty name="employee" property="livingNow"/>">退籍
	
		飼育員ID : <input type="text" name="emdID"
				   value="<jsp:getProperty name="employee" property="empID" />">
			   
		担当動物種族 : <input type="text" name=""
				   value="<jsp:getProperty name="employee" property="" />"><br>

		名前 : <input type="text" name="lastname"
				   value="<jsp:getProperty name="employee" property="lastname" />">
			   
				<input type="text" name="firstname"
				   value="<jsp:getProperty name="employee" property="firstname" />">
	
		性別 : <input type="text" name="gender"
				   value="<jsp:getProperty name="employee" property="gender" />"><br>
			   
		担当エリア : <input type="text" name="area"
				   value="<jsp:getProperty name="employee" property="area" />">
	
		写真 : 
	
		<br>
	
		<input type="submit" value="編集">
	
	</form>
	
	<form actoin ="deleteKeeper" method="post">
		<input type="submit" value="削除">
	</form>
	
</body>
</html>