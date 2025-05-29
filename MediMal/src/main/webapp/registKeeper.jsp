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
	<input type = "text" name = "empID"><br>
	パスワード:
	<input type = text name = “empPass”><br>
	名字:
	<input type = "text" name = "lastName"><br>
	名前:
	<input type = "text" name = “firstName”><br>
	性別:
	<input type = text name = "gender"><br>
	業務種別:
	<input type = "number" name = "postID"><br>
	エリアID:
	<input type = "number" name = "areaID"><br>
	業務開始日:
	<input type = "date" name = "startWork"><br>
	 
	写真:
	<input type = "text" name = "photo"><br>


	<input type = "submit" value = "登録">


	</form>
	</body>
</html>
