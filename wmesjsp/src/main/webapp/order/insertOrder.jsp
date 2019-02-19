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

<form method="POST" action="insertOrder.do">

    ID Cliente: <input type="text" size="40" maxlength="40" name="idcliente" /><br>
    Descrizione Ordine: <input type="text" size="40" maxlength="40" name="descrizione" /><br>
    
	<input type="SUBMIT" value="Inserisci">
		
</form>  
</body>
</html>