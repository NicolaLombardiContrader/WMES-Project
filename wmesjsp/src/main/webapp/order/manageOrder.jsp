<%@ page import="wmes.dto.OrderDTO"%>
<%@ page import="wmes.dto.ClientDTO"%>
<%@ page import="wmes.dto.UserDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Ordini</title>
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
	//modifica
	List<OrderDTO> allOrder = (List<OrderDTO>) request.getAttribute("allOrder");
%>
</head>
<body> 
	<h1>
		<h1>------Gestione Ordini------</h1></h1>
	<br>

	<a href="/wmesjsp/OrderServlet?richiesta=insertRedirect">Inserisci nuovo Ordine</a>


	<br />
	
		<table border="2">
			<tr>
				<th>Order ID</th>
				<th>User ID</th>
				<th>Client ID</th>
				<th>Description</th>
			</tr>
			<%
				for (OrderDTO order : allOrder) {
			%>
			<tr>
				<td><%=order.getId()%></td>
				<td><%=order.getUserDTO().getId()%></td>
				<td><%=order.getClientDTO().getId()%></td>
				<td><%=order.getDescription()%></td>

				<td><a
				href="/wmesjsp/OrderServlet?richiesta=updateRedirect&id=<%=order.getId()%>"><i
					class="fas fa-edit" title="Modifica"></i></a></td>
				<td><a
				href="/wmesjsp/OrderServlet?richiesta=delete&id=<%=order.getId()%>"><i
					class="fas fa-trash-alt" title="Elimina"></i></a></td> 
			</tr>
			<%
				}
			%>
		</table>

		<a href="/wmesjsp/OrderServlet?richiesta=indietro">Indietro</a>

</body>
</html>