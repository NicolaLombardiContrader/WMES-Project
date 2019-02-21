<%@ include file ="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Clienti</title>

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
	List<ClientDTO> allClient = (List<ClientDTO>) request.getAttribute("allClient");
%>
</head>
<body>
	
<div class="pre_contenitore">

		<p> Gestione Clienti </p>

</div>
<br>



<br/>
	<table>
		<tr>
			<th>Client Name</th>
			<th>Update</th>
			<th>Delete</th>
		
		</tr>
		<%
			for (ClientDTO client : allClient) {
		%>
		<tr>

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
<a href="/wmesjsp/ClientServlet?richiesta=insertRedirect"><span class="fs"> Inserisci nuovo Cliente </span></a>
<br>
<br>
<a href="/wmesjsp/ClientServlet?richiesta=indietro"><span class="fs"> Indietro </span></a>

</body>
</html>