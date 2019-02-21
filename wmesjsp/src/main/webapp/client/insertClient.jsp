<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo cliente</title>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
</head>
<body>
	<h1>Inserisci Cliente</h1>

	<form method="POST" action="/wmesjsp/ClientServlet?richiesta=insert">

		Nome cliente: <input type="text" size="40" maxlength="40"
			name="client_name" /><br> <br> <input
			type="SUBMIT" value="Inserisci"> <br> <br> <a
			href="/wmesjsp/ClientServlet?richiesta=indietro"><span class="fs">
				Indietro </span></a>

	</form>
</body>
</html>