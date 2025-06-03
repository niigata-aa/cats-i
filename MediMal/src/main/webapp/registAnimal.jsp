<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.entity.AnimalBean , java.util.List,java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動物登録画面</title>
<link rel="stylesheet" href="style/registAnimalStyle.css">
</head>
<body>
	<%@ include file="headerLink.jsp"%>
	<%
	List<String> allArea = (List<String>) session.getAttribute("area");
	%>
	<%
	Map<String, String> allTypes = (Map<String, String>) session.getAttribute("Alltype");
	%>
	<div class="test-con">
		<form action="registAnimal" method="post"
			enctype="multipart/form-data">

			<table style="margin-left: auto; margin-right: auto;">
				<tr align="right">
					<td>動物ID :</td>
					<td align="left"><input type="text" name="animalID" class="ra" 
					pattern="[0-9]{8}" placeholder= "8桁の数字で入力してください" required>
					</td>
					<td>生年月日 :
					<td align="left"><input type="date" name="birthDay" class="ra" placeholder= "入力してください" required>
					</td>
				</tr>
				<tr align="right">
					<td>名前 :</td>
					<td align="left"><input type="text" name="name" class="ra" placeholder= "入力してください" required>
					</td>
					<td>出身地 :</td>
					<td align="left"><input type="text" name="country" class="ra">
					</td>
				</tr>
				<tr align="right">
					<td>種族 :</td>
					<td align="left"><select name="typeName" class="Animal-ra">
							<option value="">動物の種類を選んでください</option>
							<%
							for (Map.Entry<String, String> entry : allTypes.entrySet()) {
							%>

							<option value=<%=entry.getKey()%>><%=entry.getValue()%>
							</option>

							<%
							}
							%>

					</select></td>
					<td>性別 :</td>

					<td align="left"><select name="sex" class="ra">
							
							<option value="オス">オス</option>
							<option value="メス">メス</option>
							<option value="その他">その他</option>
					</select></td>
				</tr>
				<tr align="right">
					<td>担当エリア :</td>
					<td align="left"><select name="areaName" class="Keeper-ra">
							<%
							for (int i = 0; i < allArea.size(); i++) {
							%>
							<option value=<%=i%>>
								<%=allArea.get(i)%>
							</option>
							<%
							}
							%>
					</select></td>
					<td>写真 :</td>
					<td align="left"><input type="file" name="photo" class="ra">
					</td>
				</tr>

				



				<!--		担当飼育員:-->
				<!--		<input type = "text" name = "keepers"><br>-->

			</table>
			<input type="submit" value="登録" class="rs">


		</form>
	</div>

	<%
	//リターンようのURLの取得
	String returnURL = "registAnimal.jsp";
	session.setAttribute("returnURL", returnURL);
	%>

</body>
</html>