<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物情報編集・削除画面</title>
<link rel ="stylesheet" href="style/updateAnimalStyle.css">
</head>
<body>
<%@ include file="headerLink.jsp"%>
<%List<String> allArea = (List<String>)session.getAttribute("area"); %>
<jsp:useBean id="animalrecode" class="model.entity.AnimalBean" scope="session"/>

<div class="A">
<form action = "updateAnimal" method="post" enctype="multipart/form-data">


		<div class="b">動物在籍情報 : <input type = "radio" name="livingNow" value=1  style="transform:scale(2.0);">  在籍
		
		<input type = "radio" name="livingNow" value=0  style="transform:scale(2.0);">  退籍<br></div>
		
		<div class="b">　　　動物ID : <jsp:getProperty property="animalID"  name="animalrecode"/><br></div>
			   

	<div class="b">　　生年月日 : <jsp:getProperty property="birthDay" name="animalrecode"/><br></div>


		<div class="b">　　　　名前 : <jsp:getProperty property="name" name="animalrecode"/><br></div>
			   
			 
		<div class="b">　　　　性別 :  <input type="text" name="sex" class="text" required
				   value= <jsp:getProperty property= "sex" name="animalrecode"/>><br></div>
	
		<div class="b">　エリア情報 : <select name="areaID" class="select"></div>
			<% for (int i = 0 ; i<allArea.size();i ++){ %>
			<option value = <%= i %>> <%=allArea.get(i) %> 
			<%} %>
			</option>
			</select><br>
				   
     
		
	<div class="b">　　　　写真 : <input type="file" name="inputPhoto"  class="text" value = <jsp:getProperty property="photo" name="animalrecode"/> ><br></div>
 	
		<br>
	</div>
		<input type="submit" value="編集" class="ud">
	
	</form>
	

	<form action ="deleteAnimal" method="post">
	<input type="hidden"  name ="animalID" value=<jsp:getProperty property="animalID" name="animalrecode"/>>
		<input type="submit" value="削除" class="ud">
	</form>
	<%
		String returnURL = "updateAnimal.jsp";
		session.setAttribute("returnURL", returnURL);
	%>
</body>
</html>