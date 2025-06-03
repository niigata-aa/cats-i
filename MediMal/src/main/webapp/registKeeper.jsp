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
<h1>飼育員登録画面</h1>
	<div class="test-con">
	<form action = "registKeeper" method = "post" enctype="multipart/form-data">
	
	<table style="margin-left :auto; margin-right: auto;">
	<tr align="right"><td>従業員ID:</td>
	<td><input type = "text" name = "inputEmpID" class="rk" pattern="[0-9]{6}" required placeholder="6桁の数字で入力してください"></td>
	<td>性別:</td>
	<td align="left"><input type = text name = "inputGender" class="rk"></td></tr>
	<tr align="right"><td>パスワード:</td>
	<td><input type = "password" name = "inputEmpPass" class="rk" pattern="[a-zA-Z]{8,20}" required placeholder="アルファベット8文字以上で入力してください"></td>
	<td align="right">業務種別:</td>
	<td align="left"><input type = "number" name = "inputPostID" class="rk"></td></tr>
	<tr align="right"><td>名字:</td>
	<td><input type = "text" name = "inputLastName" class="rk" required></td><td>担当エリア :</td>
		<td align="left"><select name="inputAreaID" class="rk">
			<% for (int i = 0 ; i<allArea.size();i ++){ %>
			<option value = <%= i %>> <%=allArea.get(i) %> </option> 
			<%} %>
		</select></td></tr>
	<tr align="right"><td>名前:</td>
	<td><input type = "text" name = "inputFirstName" class="rk" required></td>
	<td>業務開始日:</td>
	<td align="left"><input type = "date" name = "inputStartWork" class="rk"></td></tr>
	<tr align="right"><td>性別:</td>
	<td><select name = "inputGender" class="rk">
		
		<option value ="男性">男性</option>
		<option value ="女性">女性</option>
		<option value = "その他">その他</option>
		</select>
	</td>
	<td>写真:</td>
	<td><input type = "file" name = "inputPhoto" class="rk"></td></tr>
	
	</table>
	<input type = "submit" value = "登録" class="rs">


	</form></div>
	
	</body>
</html>
