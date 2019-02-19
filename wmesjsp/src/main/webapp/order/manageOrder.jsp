<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Ordini</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
<body>
<h1>Gestione Ordini</h1>

<table style="width:100%; border:1px solid black;">
  <tr>
    <th>ID Cliente</th> 
    <th>Descrizione Ordine</th> 
  </tr>
  <tr>
    <td>1</td>
    <td>Bicicletta</td>
    <td><a href="updateClient.jsp"><i class="far fa-edit" title="Modifica"></i></a></td>
    <td><a href="deleteClient.jsp"><i class="fas fa-trash-alt" title="Cancella"></i></a></td>
  </tr>
  <tr>
    <td>2</td>
    <td>Monopattino</td>
    <td><a href="updateClient.jsp"><i class="far fa-edit"title="Modifica"></i></a></td>
    <td><a href="deleteClient.jsp"><i class="fas fa-trash-alt" title="Cancella"></i></a></td>
  </tr>
</table>
<br/>
	<a href="insertOrder.jsp"> Inserisci nuovo ordine</a>
</body>
</html>