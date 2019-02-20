<%@ page import="wmes.dto.ClientDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>

<%
	ClientDTO updateClient = (ClientDTO) request.getAttribute("clientUpdate");
%>
</head>

<body>
	<div class="center">
		
		
	
		<h1>------Modifica Cliente------</h1>
		<form method="POST" action="/wmesjsp/ClientServlet?richiesta=update">
<br>
    <input type="hidden" name="client_id" value="<%=updateClient.getId()%>"  /><br>
    UserId: <input type="text" size="40" maxlength="40" name="user_id" value="<%=updateClient.getUserDTO().getId()%>"  /><br> 
    <br>
    ClientName: <input type="text" size="40" maxlength="40" name="client_name" value="<%=updateClient.getClientName()%>"  /><br>
    <br>
    <br>
	<input type="SUBMIT" value="Modifica">
	<br>
    <br>
	<a href="/wmesjsp/ClientServlet?richiesta=indietro">Indietro</a>
</form>  
		
	</div>
</body>
</html>