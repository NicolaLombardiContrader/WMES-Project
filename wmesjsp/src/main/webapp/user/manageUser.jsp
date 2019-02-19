<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Utenti</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>
<body>
<h1>Gestione Utenti</h1>

<table style="width:100%; border:1px solid black;">
  <tr>
    <th>Username</th> 
    <th>Password</th>
    <th>User Type</th> 
    
  </tr>
  <tr>
    <td>Bobo</td>
    <td>123</td> 
    <td>Admin</td>
    <td><a href="updateUser.jsp"><i class="far fa-edit"  title="Modifica"></i></a></td>
    <td><a href="deleteUser.jsp"> <i class="fas fa-trash-alt"  title="Cancella"></i></a></td>
  </tr>
  <tr>
    <td>Carlo</td>
    <td>456</td> 
    <td>Business Owner</td>
    <td><a href="updateUser.jsp"> <i class="far fa-edit"  title="Modifica"></i> </a></td>
    <td><a href="deleteUser.jsp"><i class="fas fa-trash-alt"  title="Cancella"></i></a></td>
  </tr>
</table>
<br/>
	<a href="insertUser.jsp"> Inserisci nuovo utente</a>

</body>
</html>