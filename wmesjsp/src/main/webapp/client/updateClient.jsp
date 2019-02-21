<%@ page import="wmes.dto.ClientDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">

<style>
/*contenitore in cima dove c'è scritto "Login"*/
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 40px 40px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: white;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>

<%
	ClientDTO updateClient = (ClientDTO) request.getAttribute("clientUpdate");
%>
</head>
<br>
<body>
	<div class="center">



		<div class="pre_contenitore">

			<p>Client Update</p>

		</div>
		<form method="POST" action="/wmesjsp/ClientServlet?richiesta=update">
			<br>

			<br>
			<input type="hidden" name="client_id" value="<%=updateClient.getId()%>" /> Client Name: <input type="text" size="40" maxlength="40"
				name="client_name" value="<%=updateClient.getClientName()%>" />
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
			<br>
			<br>
			<a href="/wmesjsp/ClientServlet?richiesta=ClientManager"><span class="fs"> Back </span></a>
		</form>

	</div>
</body>
</html>