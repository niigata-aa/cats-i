<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.AnimalBean , java.util.List,java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録画面</title>
</head>
<body>
	<%@ include file="headerLink.jsp"%>
<%List<String> allArea = (List<String>)session.getAttribute("area");  %>	
<%Map<String,String> allTypes =(Map<String,String>) session.getAttribute("Alltype");  %>

	<form action = "registAnimal" method = "post" enctype="multipart/form-data">
	
		動物ID　:　
		<input type = "text" name = "animalID"><br>
		名前　:　
		<input type = "text" name = "name"><br>
		種族 :
		<select name="typeName"class="Animal">
			<option value ="">動物の種類を選んでください</option>
			<% for (Map.Entry<String, String> entry : allTypes.entrySet()){ %>
				
				<option value = <%=entry.getKey() %>><%=entry.getValue() %> </option>
				
			<%} %>
		
		</select><br>
		品種　:　
		<input type = "number" name="kindID"><br>
		担当エリア :
		<select name="areaName" class="Keeper">
			<% for (int i = 0 ; i<allArea.size();i ++){ %>
			<option value = <%= i %>> <%=allArea.get(i) %> </option> 
			<%} %>
		</select><br>
		生年月日　:　
		<input type = "date" name = "birthDay"><br>
		出身地　:　
		<input type = "text" name = "country"><br>
		性別　:　
		<input type = "text" name = "sex"><br>
<!--		担当飼育員:-->
<!--		<input type = "text" name = "keepers"><br>-->
		写真　:　
		<input type = "file" name = "photo"><br>


		<input type = "submit" value = "登録">


	</form>
	
	<%
		//リターンようのURLの取得
		String returnURL = "registAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>