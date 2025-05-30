<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員在籍情報・削除画面</title>
</head>
<body>
	

	<form action = "updateKeeper" method="post">
		飼育員在籍情報 : <input type = "radio" name="employee" value=1>在籍
		
		<input type = "radio" name="employee" value=0>退籍
	
		飼育員ID : <input type="text" name="empID"
				   value=<%=request.getParameter("empID") %>>
			   
		担当動物種族 : <input type="text" name=""
				   value=><br>

		名前 : <input type="text" name="lastName"
				   value=<%= request.getParameter("lastName") %>>
			   
				<input type="text" name="firstName"
				   value=<%=request.getParameter("firstName") %>>
	
		性別 : <input type="text" name="gender"
				   value=<%=request.getParameter("gender") %>><br>
			   
		担当エリア : <input type="number" name="areaID"
				   value=<%=request.getParameter("areaID")%>>
	
		写真 : 
	
		<br>
	
		<input type="submit" value="編集">
	
	</form>
	
	<form action ="deleteKeeper" method="post">
	<input type="hidden" value=<%=request.getParameter("empID") %>>
		<input type="submit" value="削除">
	</form>
	
</body>
</html>