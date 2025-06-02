<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="style/headerStyle.css">
</head>
<body>
	<div class=head><img src="image/MediMal.png">
	<div class=head3><%=session.getAttribute("LoginName")%>さんようこそ。</div>
	<div class=head1><form action="goMenu" method="post">
		<input type="image" name="submit" src="image/home.png" title="メニュー画面" value="menu"  width="60" hight="60">
	</form></div>
	
	<div class=head2><form action="checkLogout" method="post">
		<input type="image" name="submit" src="image/door.png" title="ログアウト" value="logout"   width="40" hight="20">
	</form></div></div>
</body>
</html>
