<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo cliente</title>
<style>
body{
	background-image: url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
}
</style>
</head>
<body>
<h1>Inserisci Cliente</h1>

<form method="POST" action="/wmesjsp/ClientServlet?richiesta=insert">

    Nome cliente: <input type="text" size="40" maxlength="40" name="client_name" /><br>
    
	<input type="SUBMIT" value="Inserisci">
		
</form>  
</body>
</html>