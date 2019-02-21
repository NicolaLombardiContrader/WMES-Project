<%@ include file="/header.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<style>
/*contenitore in cima dove c'è scritto "Login"*/
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 40px 40px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: white;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>

<%
	UserDTO updateUser = (UserDTO) request.getAttribute("userUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>User Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="/wmesjsp/UserServlet?richiesta=update">

			<%
				String selected = "selected=\"selected\"";
				String adminSelected = "";
				String boSelected = "";
				if (updateUser.getUsertype().equals("admin")) {
					adminSelected = selected;
				} else
					boSelected = selected;
			%>

			User type: <select style="width: 270px;" name="user_type">

				<option <%=adminSelected%> value="<%=updateUser.getUsertype()%>">Admin</option>
				<option <%=boSelected%> value="<%=updateUser.getUsertype()%>">Business owner</option>


			</select>
			<br>
			<input type="hidden" name="user_id" value="<%=updateUser.getId()%>" />
			<br>
			Username: <input type="text" size="40" maxlength="40" name="user_user" value="<%=updateUser.getUsername()%>" />
			<br>
			<br>
			Password: <input type="text" size="40" maxlength="40" name="user_pass" value="<%=updateUser.getPassword()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">

			<br>
			<br>
			<a href="/wmesjsp/UserServlet?richiesta=UserManager"><span class="fs"> Back </span></a>

		</form>

	</div>
</body>
</html>