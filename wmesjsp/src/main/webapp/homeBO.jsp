<%@ page import="wmes.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Business Owner</title>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
</head>
<body>
<h1>
		Benvenuto
		<%=((UserDTO) request.getSession().getAttribute("utente")).getUsername()%>

</h1>

<br>
	<a href="ClientServlet?richiesta=ClientManager"><span class="fs"> Gestione Clienti </span></a>
<br>
<br>
	<a href="OrderServlet?richiesta=OrderManager"><span class="fs"> Gestione Ordini </span></a>
<br>	
<br>	
	<p><a href="LogoutServlet" target="self"><span class="fs"> Logout </span></a></p>
	
</body>
</html>