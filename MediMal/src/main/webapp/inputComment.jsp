<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント記入画面</title>
</head>
<body>

	<form action="inputComment">
	入れる情報?
	<%-- String animalID = wroteComment.getAnimalID();
			String date = wroteComment.getDate();
			String empID = wroteComment.empID();
			String content = wroteComment.content();--%>
			
		
	
	
	※コメントを記入してください
	<br>
	
	<textarea  name="content" id="content" rows="10" cols="70"></textarea>
	<br>
	
	
	
	<input type="submit" value="記入">
	</form>

</body>
</html>