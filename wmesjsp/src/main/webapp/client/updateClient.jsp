<%@ page import="wmes.dto.ClientDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
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
		
		<h2 style="color: red"><%=updateClient%>
		</h2>
	
		<h1>------Modifica Cliente------</h1>
		<form method="POST" action="/wmesjsp/ClientServlet?richiesta=update">

    <input type="hidden" name="client_id" value="<%=updateClient.getId()%>"  /><br>
    UserId: <input type="text" size="40" maxlength="40" name="user_id" value="<%=updateClient.getUserDTO().getId()%>"  /><br> 
    ClientName: <input type="text" size="40" maxlength="40" name="client_name" value="<%=updateClient.getClientName()%>"  /><br>
    
	<input type="SUBMIT" value="Modifica">
	
</form>  
		
	</div>
</body>
</html>