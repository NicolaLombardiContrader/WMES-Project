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

<form method="POST" action="../UserServlet?richiesta=insert">

 
    Username: <input type="text" size="40" maxlength="40" name="user_user"  /><br> 
    Password: <input type="text" size="40" maxlength="40" name="user_pass"  /><br> 
    User Type: <input type="text" size="40" maxlength="40" name="user_type"  /><br>
    
	<input type="SUBMIT" value="Inserisci">
	
</form>  
</body>
</html>