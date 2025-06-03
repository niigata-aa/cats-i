<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.List,model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員在籍情報・削除画面</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	
	<%List<String> allArea = (List<String>)session.getAttribute("area");%>
	<% EmployeeBean updateEmp = (EmployeeBean)session.getAttribute("updateEmployee"); %>
	
	

	<form action = "updateKeeper" method="post" enctype="multipart/form-data" >
		飼育員在籍情報 : <input type = "radio" name="workingNow" value=1 <%if(updateEmp.getWorkingNow() ==1){ %> checked=checked <%} %>>在籍
		
		<input type = "radio" name="workingNow" value=0 <%if(updateEmp.getWorkingNow() ==0){ %> checked=checked <%} %>>退籍
	
		飼育員ID : <input type="text" name="empID"
				   value=<%=updateEmp.getEmpID() %>>
			   
		担当動物種族 : <input type="text" name=""
				   value=><br>

		名前 : <input type="text" name="lastName"
				   value=<%= updateEmp.getLastName() %>>
			   
				<input type="text" name="firstName"
				   value=<%= updateEmp.getFirstName() %>>
		性別 : <select name="gender">
				<option value ="男性" <%if(updateEmp.getGender().equals("男性")) {%> selected <%} %>>男性</option>
				<option value ="女性" <%if(updateEmp.getGender().equals("女性")) {%> selected <%} %>>女性</option>
				<option value = "その他" <%if(updateEmp.getGender().equals("その他")) {%> selected <%} %>>その他</option>
				</select><br>  
		担当エリア : <select name="area">
			<option value="1">rinngo</option> 
			</select>
		写真 : <input type = "file" name = "inputPhoto" class="rk" >
		<br>
		<input type="submit" value="編集">
	</form>
	
	<form action ="deleteKeeper" method="post">
	<input type="hidden" name="empID" value=<%=request.getParameter("empID") %>>
		<input type="submit" value="削除">
	</form>
	<%
		String returnURL = "updateKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>