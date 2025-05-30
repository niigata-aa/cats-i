<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物情報編集・削除画面</title>
</head>
<body>
<form action = "UpdateAnimal" method="post">
		動物在籍情報 : <input type = "radio" name="animal" value=1>在籍
		
		<input type = "radio" name="employee" value=0>退籍<br>
	
		動物ID : <input type="text" name="animalID"
				   value=<%=request.getParameter("animalID") %>>
			   
		生年月日 : <input type="data" name="birthDay"
				   value=<%=request.getParameter("birthID")%>><br>

		名前 : <input type="text" name="name"
				   value=<%= request.getParameter("name") %>>
			   
		出身　: <input type="text" name="country"
				   value=<%=request.getParameter("country") %>><br>
			   
		種族 : <input type="text" name="animalKind"
				   value=<%=request.getParameter("animalKind")%>>
	
		性別 :  <input type="text" name="sex"
				   value=<%=request.getParameter("sex")%>><br>
	
		エリア情報 : <input type="text" name="area"
				   value=<%=request.getParameter("area")%>>
				   
		担当飼育員 : <br>
		
		写真 : <input type = "text" name = "photo"><br>
 	
		<br>
	
		<input type="submit" value="編集">
	
	</form>
	
	<form actoin ="DeleteAnimal" method="post">
	<input type="hidden" value=<%=request.getParameter("AnimalID") %>>
		<input type="submit" value="削除">
	</form>

</body>
</html>