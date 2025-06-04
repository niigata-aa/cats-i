<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel ="stylesheet" href="style/styleLogin.css">
</head>
<body>
	
	<div class=ken><h1>ログイン画面</h1>
	
	
	IDとパスワードを入力してください。<br>
	
	<%if(session.getAttribute("Login_failed")!=null){ if((boolean)session.getAttribute("Login_failed")){ %>
	<div class="failed">ID,またはパスワードに誤りがあります </div> 
	
	<%}} %>
	
	<%System.out.println(session.getAttribute("Login")) ;%>
	
	<form action='login' method="post">
	<div class="box">従業員ID: <input type="text" name='LoginID' 
								pattern="[0-9]{6}" placeholder="入力してください" title="正しいIDを入力してください" required></div><br>
	<div class="box">パスワード:<input type="password" name='Password' 
								pattern="[a-zA-Z]{8,20}" placeholder="パスを入力してください" title="正しいパスワードを入力してください" required></div><br>
			 <input type='submit' value='ログイン'>
			
	</form>
	</div>
	<div class="logo">
	<img src="image/MediMal.png"></div>

</body>
</html>