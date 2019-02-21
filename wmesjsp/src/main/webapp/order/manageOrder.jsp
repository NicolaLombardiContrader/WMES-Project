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
	<style>
	/*contenitore in cima dove c'è scritto "Login"*/
.pre_contenitore{
	  width:320px;
	  margin:auto;
	  height:50px;
	  border:1px solid black;
	  border-radius: 40px 40px 40px 40px;
	   background-color:rgba(0,0,0,0.9);
	   box-shadow: 20px 30px 20px #000000;
	   padding:20px; 
}

.pre_contenitore p{
     color:white;
     text-align: center;
     font-size: 1.9em;
     font-family: arial;
    line-height:2px;

}
	</style>
	
</head>
<% 
	//modifica
	List<OrderDTO> allOrder = (List<OrderDTO>) request.getAttribute("allOrder");
%>
</head>
<body> 
	<div class="pre_contenitore">

		<p> Gestione Ordini </p>

</div>
<br>
<br>
	

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
		<br>
		<br>
		<a href="/wmesjsp/OrderServlet?richiesta=insertRedirect">Inserisci nuovo Ordine</a>
		<br/>
		<br/>
		<a href="/wmesjsp/OrderServlet?richiesta=indietro"><span class="fs">Indietro </span></a>

</body>
</html>