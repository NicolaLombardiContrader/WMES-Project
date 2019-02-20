<%@ include file ="/header.jsp"%>
<html>
<head>
<style>
.center {
	margin: auto;
	width: 80%;
	text-align: left
}

table, th, td {
	border: 1px solid black;
}
</style>
<%
	UserDTO updateUser = (UserDTO) request.getAttribute("userUpdate");
%>
</head>

<body>
	<div class="center">
		
		<h2 style="color: red"><%=updateUser%>
		</h2>
	
		<h1>------Modifica Utente------</h1>
		<form method="POST" action="/wmesjsp/UserServlet?richiesta=update">

    <input type="hidden" name="user_id" value="<%=updateUser.getId()%>"  /><br>
    Username: <input type="text" size="40" maxlength="40" name="user_user" value="<%=updateUser.getUsername()%>"  /><br> 
    Password: <input type="text" size="40" maxlength="40" name="user_pass" value="<%=updateUser.getPassword()%>"  /><br> 
    User Type: <input type="text" size="40" maxlength="40" name="user_type" value="<%=updateUser.getUsertype()%>"  /><br>
    
	<input type="SUBMIT" value="Modifica">
	
</form>  
		
	</div>
</body>
</html>