<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="model.entity.EmployeeBean , java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員登録画面</title>
<link rel ="stylesheet" href="style/registKeeperStyle.css">
</head>
<body>
<%@ include file="headerLink.jsp"%>
<%List<String> allArea = (List<String>)session.getAttribute("area");  %>	
	
	<form action = "registKeeper" method = "post" >
	<div class="test-con">
	<table style="margin-left :auto; margin-right: auto;">
	<tr align="right"><td>従業員ID:</td>
	<td><input type = "text" name = "inputEmpID"></td></tr>
	<tr align="right"><td>パスワード:</td>
	<td><input type = "password" name = "inputEmpPass"></td></tr>
	<tr align="right"><td>名字:</td>
	<td><input type = "text" name = "inputLastName"></td></tr>
	<tr align="right"><td>名前:</td>
	<td><input type = "text" name = "inputFirstName"></td></tr>
	<tr align="right"><td>性別:</td>
	<td><input type = text name = "inputGender"></td></tr>
	<tr align="right"><td>業務種別:</td>
	<td><input type = "number" name = "inputPostID"></td></tr>
	<tr align="right"><td>担当エリア :</td>
		<td><select name="inputAreaID" class="Keeper">
			<% for (int i = 0 ; i<allArea.size();i ++){ %>
			<option value = <%= i %>> <%=allArea.get(i) %> </option> 
			<%} %>
		</select></td></tr>
	<tr align="right"><td>業務開始日:</td>
	<td><input type = "date" name = "inputStartWork"></td></tr>
	 
	<tr align="right"><td>写真:</td>
	<td><input type = "file" name = "inputPhoto"></td></tr>
	</table>
	<input type = "submit" value = "登録">


	</form>
	</body>
</html>
