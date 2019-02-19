<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo utente</title>
</head>
<body>
<h1>Inserisci</h1>

<form method="POST" action="userAdded.jsp">

 
    Username: <input type="text" size="40" maxlength="40" name="username"  /><br> 
    Password: <input type="text" size="40" maxlength="40" name="password"  /><br> 
    User Type: <input type="text" size="40" maxlength="40" name="type"  /><br>
    
	<input type="SUBMIT" value="Inserisci">
	
</form>  
</body>
</html>