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
		List<AnimalBean> animalList = (List<AnimalBean>)request.getAttribute("animalList");
	 %>
	
	<table>
	<tr><th>写真</th><th>詳細情報</th></tr>
	<%
		for(AnimalBean animal : animalList){
	%>
	<tr><td><img src=<%=animal.getPhoto() %>></td>
	
	<td><%=animal.getAnimalID() %>
		<%=animal.getName() %>
		<%=animal.getAnimalType() %>
		<%=animal.getArea() %>
		
		
		<!-- 担当動物個体の表示とそこから詳細カルテに飛ぶ方法が分かりません -->
		<!--  =employee.get() %>-->
		<%=animal.getBirthDay() %>
		
	
	
	<%
		String  idhead = (String)session.getAttribute("postID");
		if(idhead.equals("20")){
	%>
	<form action="goUpdateAnimal" method="post">
		<input type ="hidden" name="animalID" value=<%=animal.getAnimalID() %>>
		<input type ="hidden" name="Name" value=<%=animal.getName() %>>
		<input type ="hidden" name="animalType" value=<%= animal.getAnimalType() %>>
		<input type ="hidden" name="area" value=<%= animal.getArea() %>>
		<input type ="hidden" name="livingNow" value=<%= animal.getLivingNow()  %>>
		<input type="submit" value="編集・削除">
	</form>
	
	<form action="goKarteDetail" method="post">
		<input type ="hidden" name="animalID" value=<%=animal.getAnimalID() %>>
		<input type ="hidden" name="Name" value=<%=animal.getName() %>>
		<input type ="hidden" name="animalType" value=<%= animal.getAnimalType() %>>
		<input type ="hidden" name="area" value=<%= animal.getArea() %>>
		<input type ="hidden" name="livingNow" value=<%= animal.getLivingNow()  %>>
		<input type="submit" value="詳細カルテへ">
	</form>
	
	<%
		}
		%>
	</td>
	</tr>
	
	<%	
	}
	%>
	</table>
	
</body>
</html>