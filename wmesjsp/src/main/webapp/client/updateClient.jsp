<%@ page import="wmes.dto.ClientDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<style>
.center {
	margin: auto;
	width: 80%;
	text-align: left
}

table, th, td {
	border: 1px solid black;
}
</style>

<%
	ClientDTO updateClient = (ClientDTO) request.getAttribute("clientUpdate");
%>
</head>

<body>
	<div class="center">
		
		
	
		<h1>------Modifica Cliente------</h1>
		<form method="POST" action="/wmesjsp/ClientServlet?richiesta=update">
<br>
     
    <br>
    <input type="hidden" name="client_id" value="<%=updateClient.getId()%>"  />
    ClientName: <input type="text" size="40" maxlength="40" name="client_name" value="<%=updateClient.getClientName()%>"  /><br>
    <br>
    <br>
	<input type="SUBMIT" value="Modifica">
	<br>
    <br>
	<a href="/wmesjsp/ClientServlet?richiesta=indietro"><span class="fs"> Indietro </span></a>
</form>  
		
	</div>
</body>
</html>