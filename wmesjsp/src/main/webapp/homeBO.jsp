<%@ page import="wmes.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Business Owner</title>
<style>
body{
	background-image: url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
	</style>
</head>
<body>
<h1>
		Benvenuto
		<%=((UserDTO) request.getSession().getAttribute("utente")).getUsername()%>

</h1>

<br>
	<a href="ClientServlet?richiesta=ClientManager"> Gestione Clienti</a>
<br>
<br>
	<a href="OrderServlet?richiesta=OrderManager"> Gestione Ordini</a>
<br>	
<br>	
	<p><a href="LogoutServlet" target="self">Logout</a></p>
	
</body>
</html>