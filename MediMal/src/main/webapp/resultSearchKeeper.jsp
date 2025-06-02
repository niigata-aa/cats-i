<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.List,model.entity.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員検索結果画面</title>
<link rel ="stylesheet" href="style/resultSearchStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp" %>
	
	<form action="goSearchKeeper" method="post" class="btn">
		<input type="submit" value="再検索">
	</form>
	
	<%
		List<EmployeeBean> employeeList = (List<EmployeeBean>)request.getAttribute("employeeList");
	%>
	
	<div class="result">
	<table>
	<tr>
	<th>写真</th>
	<th>詳細情報</th>
	<th></th>
	</tr>
	<%
		for(EmployeeBean employee : employeeList) {
		
	%>
	<tr>
	<td><img src=<%=employee.getPhotoURL() %>></td>
	<td><%=employee.getEmpID() %>
		<%=employee.getLastName() %>
		<%=employee.getFirstName() %>
		<%=employee.getAreaName() %>
		
		<!-- 担当動物個体の表示とそこから詳細カルテに飛ぶ方法が分かりません -->
		<!--  =employee.get() %>-->
		<%=employee.getStartWork() %>
		
	</td>
	<td>
	<%
		String  idhead = (String)session.getAttribute("postID");
		if(idhead.equals("10")){
	%>
	
	<form action="goUpdateKeeper" method="post">
		<input type ="hidden" name="empID" 		value=<%= employee.getEmpID() %>>
		<input type ="hidden" name="lastName" 	value=<%= employee.getLastName() %>>
		<input type ="hidden" name="firstName" 	value=<%= employee.getFirstName() %>>
		<input type ="hidden" name="area" 		value=<%= employee.getAreaName() %>>
		<input type	="hidden" name="workingNow" value=<%= employee.getWorkingNow() %>>
		<input type="submit" value="編集・削除">
	</form>
	
	
	<%
		}
		%>
		</td>
		</tr>
	
	<%	}
	%>
	</table>
	</div>
	<%
		String returnURL = "resultSearchKeeper.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>
