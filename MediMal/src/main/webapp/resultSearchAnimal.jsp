<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物検索結果画面</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<form action="goSearchAnimal" method="post">
		<input type="submit" value="再検索">
	</form>
	
	<%
		request.setCharacterEncoding("UTF-8");
	 %>
	
	<table>
	<tr><th>写真</th><th>詳細情報</th></tr>
	<%
		for(AnimalBean animal : animalListanimalList")){
	%>
	<src=<%=animal.getPhotoURL() %>></td>
	<td><%=animal.getEmpID() %>
		<%=employee.getLastName() %>
		<%=employee.getFirstName() %>
		<%=employee.getAreaName() %>
		
		<!-- 担当動物個体の表示とそこから詳細カルテに飛ぶ方法が分かりません -->
		<!--  =employee.get() %>-->
		<%=employee.getStartWork() %>
		
	
	
	<%
		String  idhead = (String)session.getAttribute("postID");
		if(idhead.equals("10")){
	%>
	<form action="goUpdateKeeper" method="post">
		<input type ="hidden" name="empID" value=<%= employee.getEmpID() %>>
		<input type ="hidden" name="lastName" value=<%= employee.getLastName() %>>
		<input type ="hidden" name="firstName" value=<%= employee.getFirstName() %>>
		<input type ="hidden" name="area" value=<%= employee.getAreaName() %>>
		<input type="submit" value="編集・削除">
	</form>
	
	
	<%
		}
		%>
	</td></tr>
	
	<%	}
	%>
	
</body>
</html>