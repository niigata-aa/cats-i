<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" 
	import="java.util.List,java.util.ArrayList,
			model.entity.AnimalBean,model.dao.AnimalDAO,
			model.entity.KarteBean,model.entity.Weight,
			model.entity.Birth,model.entity.Drug,
			model.entity.Feed,model.entity.MedicalExamBean,
			model.entity.AnimalComment,
			java.sql.SQLException,java.io.IOException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カルテ詳細画面</title>
<link rel ="stylesheet" href="style/karteDetailStyle.css">
</head>
<body>

	<%@include file="headerLink.jsp" %>
	<h1>カルテ詳細画面</h1>
	<div class="animal_info">
	
	<% AnimalBean Animal = (AnimalBean) session.getAttribute("animalrecode");
		int living = Animal.getLivingNow(); %>
	
	<div class="kihonnjouhou">　　  ●基本情報●</div>

	
	<jsp:useBean id="animalrecode" class="model.entity.AnimalBean" scope="session"/>
	　　動物ID　:　<jsp:getProperty property="animalID" name="animalrecode"/><br>
	　　　名前　:　<jsp:getProperty property="name" name="animalrecode"/><br>
	
	　　　写真　:　<img src="/MediMal/image/<jsp:getProperty property="photo" name="animalrecode"/>" width="100" height="100"><br>
	　生年月日　:　<jsp:getProperty property="birthDay" name="animalrecode"/><br>
	　　　性別　:　<jsp:getProperty property="sex" name="animalrecode"/><br>
	　　　種族　:　<jsp:getProperty property="animalType" name="animalrecode"/><br>
	動物エリア　:　<jsp:getProperty property="area" name="animalrecode"/><br>
	　在籍情報　:　<%if(living==1){ %>
		<jsp:getProperty property="area" name="animalrecode"/>で元気にしています。
	<%}else{ %>
		現在、園内にいません。
		<%} %>
	<br>
	
	
	
	<%
	KarteBean Karte = (KarteBean)session.getAttribute("KarteInfo");
	String idhead = (String) session.getAttribute("postID");
	if (idhead.equals("20")) {
	%>
	<div class="btn">
	<form action="goUpdateAnimal" method="post">
		<input type="submit" value="動物情報編集・削除" >
	</form>
	</div>
	<%
	}
	%>
	
	</div>
	
                 
                 
    <%--縦向きのスクロールテーブル --%>
	<div class= "weight_h1">●体重記録●</div>
	<div class="weight">
	<table>
		<tr><th>日付</th><th>体重</th></tr>
	<% if (Karte.getWeightLog()!=null){%>
		<%for (Weight weight:Karte.getWeightLog()){%>
                 <tr><td><%=weight.getInputTime() %></td>
                     <td><%=weight.getWeight()%><%=weight.getWeightUnit() %></td></tr>
        <%} }else{%>
        <tr><td>記録が存在していません。</td><td></td></tr>
		<%} %>
		</table>
          </div>
          
          <% if(idhead.equals("20")||idhead.equals("30")){ %>
		<form action="goInputWeight" method="post">
		<input type="submit" value="体重記録ボタン" class="weight_btn">
		</form>
	<%} %>
        
    

	
	<%-- この辺は横向きのスクロールテーブルがいいです --%>
	
	<div class="feed_h1">●食事記録●</div>
	<div class="feed">
	
	<table>
	<tr class=”pin”><th>日付</th><th>食事内容</th><th>量</th></tr>
	<% if (Karte.getFeedLog().size()!=0){%>
		<%for (Feed feed : Karte.getFeedLog()){%>
			<tr><td><%= feed.getFeedTime() %> </td>
				<td><%=feed.getFeedContent()%></td>
				<td><%=feed.getFeedAmount() %><%=feed.getFeedUnit() %></td></tr>
	
	<%} }else{%>
	<tr><td>記録が存在していません。</td><td></td><td></td>
				</tr>
	<%} %>
	</table>
	</div>
	
	<% if(idhead.equals("20")||idhead.equals("30")){ %>
		<form action="goInputFeed" method="post">
		<input type="submit" value="食事記録ボタン" class="feed_btn">
		</form>
	<%} %>
		
	
	
	
	

	<%-- この辺は横向きのスクロールテーブルがいいです --%>
	
	<div class="drug_h1">●投薬履歴●</div>
	<div class="drug">
	
	<table>
	<tr class="pin"><th>日付</th><th>薬名</th><th>投薬量</th></tr>
	<% if (Karte.getDrugLog().size()!=0){%>
	
	<% 	for (Drug drug : Karte.getDrugLog()) {%>
		<tr><td><%= drug.getDate() %></td>
			<td><%=drug.getMedicineName() %></td>
			<td><%= drug.getMedicineAmount() %> g</td></tr>
	
	<% }}else{ %>
	<tr><td>記録が存在していません。</td>
			<td></td>
			<td></td></tr>
		
	<%} %>
	</table>
	</div>
	<% if(idhead.equals("30")){ %>
		<form action="goInputKarte" method="post">
		<input type="submit" value="投薬・出産記録ボタン" class="drug_btn">
		</form>
	<%} %>
	
	
	
	
	
	
	
	<%-- この辺は縦向きのスクロールテーブル(普通の)がいいです --%>
	
	<div class="comment_h1">●所見●</div>
	<div class="comment">
	
	<table>
	<tr><th>日付</th><th>記録者</th><th>内容</th></tr>
	<% if (Karte.getCommentLog().size()!=0){%>
	
	<% for (AnimalComment comment : Karte.getCommentLog()) {%>
	<tr><td><%= comment.getCommentTime() %></td>
		<td><%=comment.getEmpID() %></td>
		<td><%= comment.getContent() %></td><tr>
		
	<% }}else{ %>
	<tr><td>記録が存在していません</td>
		<td></td>
		<td></td><tr>
	
	<%} %>
	</table>

	
	</div>
	<% if(idhead.equals("20")||idhead.equals("30")){ %>
		<form action="goInputComment" method="post">
	<input type="submit" value="コメント記入ボタン" class="comment_btn">
	</form>
	<%} %>
	
	
	

	
</body>
</html>