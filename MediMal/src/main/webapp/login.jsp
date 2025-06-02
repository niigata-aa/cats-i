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
	<div class="box">従業員ID: <input type="text" name='LoginID' pattern="[0-9]+" placeholder="IDを入力してください" title="数字で入力してください"></div><br>
	<div class="box">パスワード:<input type="password" name='Password' pattern="[a-z]+" placeholder="パスワードを入力してください" title="半角英数字で入力してください"></div><br>
			 <input type='submit' value='ログイン'>
			
	</form>
	</div>
	<div class="logo">
	<img src="image/MediMal.png"></div>

</body>
</html>