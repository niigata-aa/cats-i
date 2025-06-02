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
	
	<form action='login' method="post">
	<div class="box">従業員ID: <input type="text" name='LoginID'></div><br>
	<div class="box">パスワード:<input type="password" name='Password'></div><br>
			 <input type='submit' value='ログイン'>
			
	</form>
	</div>
	<div class="logo">MediMal</div>
	

</body>
</html>