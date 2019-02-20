<%@ page import="wmes.dto.OrderDTO"%>
<%@ page import="wmes.dto.ClientDTO"%>
<%@ page import="wmes.dto.UserDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Ordini</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
</head>
<%
	List<OrderDTO> allOrder = (List<OrderDTO>) request.getAttribute("allOrder");
%>
</head>
<body> 
	<h1>
		Benvenuto
		<%=((OrderDTO) request.getSession().getAttribute("utente")).getUser().getUsername()%></h1>
	<br>

	<a href="UserServlet?richiesta=insertRedirect">Inserisci nuovo
		Ordine</a>

	<br />
	
		<table border="2">
			<tr>
				<th>ID</th>
				<th>User</th>
				<th>Client</th>
				<th>Description</th>
			</tr>
			<%
				for (OrderDTO order : allOrder) {
			%>
			<tr>
				<td><%=order.getId()%></td>
				<td><%=order.getUser().getUserId()%></td>
				<td><%=order.getClient().getClientId()%></td>
				<td><%=order.getDescription()%></td>

				<td><a href="UserServlet?richiesta=updateRedirect">Modifica</a>
				</td>
				<td>
			
				<a	href="UsersServlet?richiesta=delete"=<%=order.getId()%>">Elimina</a>
				
				</td> 
			</tr>
			<%
				}
			%>
		</table>

		<a href="UserServlet?richiesta=indietro">Indietro</a>

</body>
</html>