<%@ include file ="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Clienti</title>
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
	List<ClientDTO> allClient = (List<ClientDTO>) request.getAttribute("allClient");
%>
</head>
<body>
	
<h1>------Gestione Clienti------</h1>
<br>



<br/>
	<table>
		<tr>
			<th>Client ID</th>
			<th>User ID</th>
			<th>Client Name</th>
		
		</tr>
		<%
			for (ClientDTO client : allClient) {
		%>
		<tr>
			<td><%=client.getId()%></td>
			<td><%=client.getUserDTO().getId()%></td>
			<td><%=client.getClientName()%></td>
			

			<td><a
				href="/wmesjsp/ClientServlet?richiesta=updateRedirect&id=<%=client.getId()%>"><i
					class="fas fa-edit" title="Modifica"></i></a></td>
			<td><a
				href="/wmesjsp/ClientServlet?richiesta=delete&id=<%=client.getId()%>"><i
					class="fas fa-trash-alt" title="Elimina"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
<br>
<br>
<a href="/wmesjsp/ClientServlet?richiesta=insertRedirect">Inserisci nuovo Cliente</a>
<br>
<br>
<a href="/wmesjsp/ClientServlet?richiesta=indietro">Indietro</a>

</body>
</html>