<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.entity.AnimalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物情報編集・削除画面</title>

</head>
<body>
<%@ include file="headerLink.jsp"%>
<%List<String> allArea = (List<String>)session.getAttribute("area"); %>
<jsp:useBean id="animalrecode" class="model.entity.AnimalBean" scope="session"/>
<%AnimalBean recode = (AnimalBean)session.getAttribute("animalrecode"); %>

<form action = "updateAnimal" method="post">
		動物在籍情報 : <input type = "radio" name="livingNow" value=1>在籍
		
		<input type = "radio" name="livingNow" value=0>退籍<br>
		
		動物ID : <jsp:getProperty property="animalID" name="animalrecode"/><br>
			   

		生年月日 : <jsp:getProperty property="birthDay" name="animalrecode"/><br>


		名前 : <jsp:getProperty property="name" name="animalrecode"/><br>
			   
			 
		性別 :  <select name="gender">
				
				<option value ="オス" <% if(recode.getSex().equals("オス")){ %> selected <%} %>>オス</option>
				<option value ="メス" <% if(recode.getSex().equals("メス")) {%> selected <%} %>>メス</option>
				<option value = "その他" <%if(recode.getSex().equals("その他")) {%> selected <%} %>>その他</option>
				</select>
				   value= ><br>
	
		エリア情報 : <select name="areaID">
			<% for (int i = 0 ; i<allArea.size();i ++){ %>
			<option value = <%= i %>> <%=allArea.get(i) %> </option> 
			<%} %>
			
			</select>
				   
		担当飼育員 : <br>
		
		写真 : <input type = "text" name = "photo" value = <jsp:getProperty property="photo" name="animalrecode"/> ><br>
 	
		<br>
	
		<input type="submit" value="編集">
	
	</form>
	

	<form action ="deleteAnimal" method="post">
	<input type="hidden"  name ="animalID" value=<jsp:getProperty property="animalID" name="animalrecode"/>>
		<input type="submit" value="削除">
	</form>
	<%
		String returnURL = "updateAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>