<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Benvenuto in WMES</title>
</head>
<body>
<h1>Inserisci</h1>

<form method="POST" action="InsertUser.do">

    Id: <input type="text" size="40" maxlength="40" name="nome" /><br>
    User: <input type="text" size="40" maxlength="40" name="user"  /><br> 
    Password: <input type="text" size="40" maxlength="40" name="password"  /><br> 
    Type: <input type="text" size="40" maxlength="40" name="password"  /><br>
    
	<input type="SUBMIT" value="Inserisci">
	
</form>  
</body>
</html>