<%@ page import="wmes.dto.UserDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
</head>
<%
	List<UserDTO> allUser = (List<UserDTO>) request.getAttribute("allUser");
%>
</head>
<body>
	<h1>
		Benvenuto
		<%=((UserDTO) request.getSession().getAttribute("utente")).getUsername()%></h1>
	<br>

	<a href="UserServlet?richiesta=insertRedirect">Inserisci nuovo
		Utente</a>

	<br />
	
		<table border="2">
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Password</th>
				<th>User Type</th>
			</tr>
			<%
				for (UserDTO user : allUser) {
			%>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getUsername()%></td>
				<td><%=user.getPassword()%></td>
				<td><%=user.getUsertype()%></td>

				<td><a href="UserServlet?richiesta=updateRedirect">Modifica</a>
				</td>
				<td>
			
				<a	href="UsersServlet?richiesta=delete"=<%=user.getId()%>">Elimina</a>
				
				</td>
			</tr>
			<%
				}
			%>
		</table>

		<a href="UserServlet?richiesta=indietro">Indietro</a>

</body>
</html>