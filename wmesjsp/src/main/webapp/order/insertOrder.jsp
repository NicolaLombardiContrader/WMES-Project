<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo ordine</title>
</head>
<body>
<h1>Inserisci</h1>

<form method="POST" action="/wmesjsp/OrderServlet?richiesta=insert">

 
    UserId: <input type="text" size="40" maxlength="40" name="user_id"  /><br> 
    ClientId: <input type="text" size="40" maxlength="40" name="client_id"  /><br> 
    Description: <input type="text" size="40" maxlength="40" name="order_description"  /><br>
    
	<input type="SUBMIT" value="Inserisci">
	
</form>  
</body>
</html>