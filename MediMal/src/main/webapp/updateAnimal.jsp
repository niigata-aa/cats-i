<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物情報編集・削除画面</title>

</head>
<body>

<jsp:useBean id="animalrecode" class="model.entity.AnimalBean" scope="session"/>

<form action = "updateAnimal" method="post">
		動物在籍情報 : <input type = "radio" name="livingNow" value=1>在籍
		
		<input type = "radio" name="livingNow" value=0>退籍<br>
		
		動物ID : <jsp:getProperty property="animalID" name="animalrecode"/><br>
			   

		生年月日 : <jsp:getProperty property="birthDay" name="animalrecode"/><br>


		名前 : <jsp:getProperty property="name" name="animalrecode"/><br>
			   
			 
		性別 :  <input type="text" name="sex"
				   value= <jsp:getProperty property= "sex" name="animalrecode"/>><br>
	
		エリア情報 : <jsp:getProperty property="area" name="animalrecode"/>>
				   
		担当飼育員 : <br>
		
		写真 : <input type = "text" name = "photo" value = <jsp:getProperty property="photo" name="animalrecode"/> ><br>
 	
		<br>
	
		<input type="submit" value="編集">
	
	</form>
	

	<form action ="deleteAnimal" method="post">
	<input type="hidden"  name ="animalID" value=<jsp:getProperty property="animalID" name="animalrecode"/>>
		<input type="submit" value="削除">
	</form>

</body>
</html>