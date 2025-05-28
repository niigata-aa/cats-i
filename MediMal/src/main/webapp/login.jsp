<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン画面</h1>
	IDとパスワードを入力してください。<br>
	
	<form action='login' method="post">
	従業員ID: <input type="text" name='LoginID'><br>
	パスワード:	 <input type="password" name='PassWord'><br>
			 <input type='submit' value='ログイン'>
	</form>
	

</body>
</html>