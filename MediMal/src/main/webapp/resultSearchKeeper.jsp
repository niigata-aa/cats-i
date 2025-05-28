<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員検索結果画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<form action="goSearchKeeper" method="post">
		<input type="submit" value="再検索">
	</form>
	
	<%
		List<EmployeeBean> employeeList
		= (List<EmployeeBean>)request.getAttribute("employeeList");
	%>
	
	<table>
	<tr><th>写真</th><th>詳細情報</th></tr>
	<%
		for(EmployeeBean employee : employeeList){
	%>
	<tr><td><%=employee.getPhoto() %></td>
	<td><%=employee.getEmpID() %>
		<%=employee.getLastName() %>
		<%=employee.getFirstName() %>
		<%=employee.getArea() %>
		<%=employee.get() %>
		<%=employee.getStartWork() %></td></tr>
	</table>
	<%
		String  idhead = (String)session.getAttribute("IDhead");
		if(idhead.equals("10")){
	%>
	<form action="goUpdateKeeper" method="post">
		<input type="submit" value="編集・削除">
	</form>
	<%
		} }
	%>
	
</body>
</html>