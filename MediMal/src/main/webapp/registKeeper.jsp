<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員登録画面</title>
</head>
<body>
	
	<form action = "registKeeper" method = "post">
	
	従業員ID:
	<input type = "text" name = "inputEmpID"><br>
	パスワード:
	<input type = "password" name = "inputEmpPass"><br>
	名字:
	<input type = "text" name = "inputLastName"><br>
	名前:
	<input type = "text" name = "inputFirstName"><br>
	性別:
	<input type = text name = "inputGender"><br>
	業務種別:
	<input type = "number" name = "inputPostID"><br>
	エリアID:
	<input type = "number" name = "inputAreaID"><br>
	業務開始日:
	<input type = "date" name = "inputStartWork"><br>
	 
	写真:
	<input type = "text" name = "inputPhoto"><br>


	<input type = "submit" value = "登録">


	</form>
	</body>
</html>
