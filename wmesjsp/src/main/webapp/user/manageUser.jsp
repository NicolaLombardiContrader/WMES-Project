
<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
<style>
body{
	background-image: url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
}
</style>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
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
	
	<h1>------Gestione Utenti------</h1>

	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>User Type</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (UserDTO user : allUser) {
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=user.getUsertype()%></td>
			<td class="center"><a
				href="/wmesjsp/UserServlet?richiesta=updateRedirect&id=<%=user.getId()%>"><i
					class="fas fa-edit" title="Modifica"></i></a></td>
			<td class="center"><a
				href="/wmesjsp/UserServlet?richiesta=delete&id=<%=user.getId()%>"><i
					class="fas fa-trash-alt" title="Elimina"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
<br>
<br>
	<a href="/wmesjsp/UserServlet?richiesta=insertRedirect">Inserisci nuovo Utente</a>
<br>
<br>
	<a href="/wmesjsp/UserServlet?richiesta=indietro">Indietro</a>

</body>
</html>