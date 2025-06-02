<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>飼育員在籍情報・削除画面</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	
	<%List<String> allArea = (List<String>)session.getAttribute("area"); %>

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
			   
		担当エリア : <select name="areaID">
			<% for (int i = 0 ; i<allArea.size();i ++){ %>
			<option value = <%= i %>> <%=allArea.get(i) %> </option> 
			<%} %>
			
			</select>
	
		写真 : 
	
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