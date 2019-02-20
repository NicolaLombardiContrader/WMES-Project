<%@ page import="wmes.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">

</head>
<body>
<h1>
		Benvenuto
		<%=((UserDTO) request.getSession().getAttribute("utente")).getUsername()%>

</h1>
<br/>
	<a href="UserServlet?richiesta=UserManager"> Gestione Utenti</a>
<br/>
	<p><a href="LogoutServlet" target="self">Logout</a></p>
</body>
</html>