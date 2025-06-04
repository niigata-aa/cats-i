<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.List,model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員在籍情報・削除画面</title>
<link rel ="stylesheet" href="style/updateKeeperStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	
	<%List<String> allArea = (List<String>)session.getAttribute("area");%>
	<% EmployeeBean updateEmp = (EmployeeBean)session.getAttribute("updateEmployee"); %>
	
	
<div class="A">
	<form action = "updateKeeper" method="post" enctype="multipart/form-data" >
		<div class="b">飼育員在籍情報 : <input type = "radio" name="workingNow" value=1 style="transform:scale(2.0);" <%if(updateEmp.getWorkingNow() ==1){ %> checked=checked <%} %>>在籍
		
		<input type = "radio" name="workingNow" value=0 style="transform:scale(2.0);" <%if(updateEmp.getWorkingNow() ==0){ %> checked=checked <%} %>>退籍<br></div>
	
		<div class="b">　　　飼育員ID : <input type="text" name="empID" class="text" pattern="[0-9]{6}" required
				   value=<%=updateEmp.getEmpID() %> placeholder="6桁の数字で入力してください"><br></div>
			   
		<div class="b">　担当動物種族 : <input type="text" name="" class="text"
				   value=><br></div>

		<div class="b">　　　　　名前 : <input type="text" name="lastName" class="text" required
				   value=<%= updateEmp.getLastName() %>>
			   
				<input type="text" name="firstName" class="text" required
				   value=<%= updateEmp.getFirstName() %>><br></div>
		<div class="b">　　　　　性別 : <select name="gender" class="select">
				<option value ="男性" <%if(updateEmp.getGender().equals("男性")) {%> selected <%} %>>男性</option>
				<option value ="女性" <%if(updateEmp.getGender().equals("女性")) {%> selected <%} %>>女性</option>
				<option value = "その他" <%if(updateEmp.getGender().equals("その他")) {%> selected <%} %>>その他</option>
				</select><br>  </div>
		<div class="b">　　担当エリア : <select name="area" class="select">
			<% for (int i = 0 ; i<allArea.size();i ++){ %>
			<option value = <%= i %>> <%=allArea.get(i) %> </option> 
			<%} %>
			
			</select><br></div>
		<div class="b">　　　　　写真 : <input type = "file" name = "photo" class="rk" >
		<br></div></div>
		<input type="submit" value="編集" class="pro">
	</form>
	
	<form action ="deleteKeeper" method="post">
	<input type="hidden" name="empID" value=<%=request.getParameter("empID") %>>
		<input type="submit" value="削除"  class="pro">
	</form>
	<%
		String returnURL = "updateKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>