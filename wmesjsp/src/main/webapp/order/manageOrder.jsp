<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Ordini</title>
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

	<br/>
	<br />
	
		<table>
			<tr>
				
				<th>Client</th>
				<th>Description</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<%
				for (OrderDTO order : allOrder) {
			%>
			<tr>
				<!-- 
				<td><%=order.getId()%></td>
				<td><%=order.getUserDTO().getId()%></td>
				 -->
				<td><%=order.getClientDTO().getId()%></td>
				<td><%=order.getDescription()%></td>

				<td><a
				href="/wmesjsp/OrderServlet?richiesta=updateRedirect&id=<%=order.getId()%>">
				<i class="fas fa-edit" title="Modifica"></i></a></td>
				<td><a
				href="/wmesjsp/OrderServlet?richiesta=delete&id=<%=order.getId()%>"><i
					class="fas fa-trash-alt" title="Elimina"></i></a></td> 
			</tr>
			<%
				} 
			%>
		</table>
		
		<br/>
		<br/>
		<a href="/wmesjsp/OrderServlet?richiesta=indietro">Indietro</a>

</body>
</html>