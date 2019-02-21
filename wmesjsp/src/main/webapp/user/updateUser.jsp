<%@ include file ="/header.jsp"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<style>
	/*contenitore in cima dove c'è scritto "Login"*/
.pre_contenitore{
	  width:320px;
	  margin:auto;
	  height:50px;
	  border:1px solid black;
	  border-radius: 40px 40px 40px 40px;
	   background-color:rgba(0,0,0,0.9);
	   box-shadow: 20px 30px 20px #000000;
	   padding:20px; 
}

.pre_contenitore p{
     color:white;
     text-align: center;
     font-size: 1.9em;
     font-family: arial;
    line-height:2px;

}
	</style>

<%
	UserDTO updateUser = (UserDTO) request.getAttribute("userUpdate");
%>
</head>

<body>
	<div class="center">
		
		<div class="pre_contenitore">

		<p> Modifica Utente</p>

</div>
<br>
<br>
		<form method="POST" action="/wmesjsp/UserServlet?richiesta=update">

    <input type="hidden" name="user_id" value="<%=updateUser.getId()%>"  /><br>
    Username: <input type="text" size="40" maxlength="40" name="user_user" value="<%=updateUser.getUsername()%>"  /><br> 
    <br>
    Password: <input type="text" size="40" maxlength="40" name="user_pass" value="<%=updateUser.getPassword()%>"  /><br> 
    <br>
    User type: <select name="user_type">
			<option value="admin">Amministratore</option>
			<option value="bo">Business Owner</option>
		</select>
    <br>
    <br>
	<input type="SUBMIT" value="Modifica">
	
	<br>
<br>
	<a href="/wmesjsp/UserServlet?richiesta=indietro"><span class="fs"> Indietro </span></a>
	
</form>  
		
	</div>
</body>
</html>