<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo utente</title>

<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
</head>
<body>
	<h1>------Inserisci nuovo Utente------</h1>

	<form method="POST" action="/wmesjsp/UserServlet?richiesta=insert">


		Username: <input type="text" size="40" maxlength="40" name="user_user" /><br>
		<br>
		Password:  <input type="text" size="40" maxlength="40" name="user_pass" /><br>
		<br>
		User type: <select name="user_type">
			<option value="admin">Amministratore</option>
			<option value="bo">Business Owner</option>
		</select>
	<!-- 	User Type: <input type="text" size="40" maxlength="40"
			name="user_type" /><br> 
			-->
		<br>
		<br>	
		<br>			
<input type="SUBMIT" value="Inserisci">
<br>	
<br>
<a href="/wmesjsp/UserServlet?richiesta=indietro">Indietro</a>

</form>
</body>
</html>