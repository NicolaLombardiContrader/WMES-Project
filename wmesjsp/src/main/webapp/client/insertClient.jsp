<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo cliente</title>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
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
<br>

<body>
	<div class="pre_contenitore">

		<p> New Client </p>

</div>
<br>
<br>
<br>
	<form method="POST" action="/wmesjsp/ClientServlet?richiesta=insert">

		Client Name: <input type="text" size="40" maxlength="40"
			name="client_name" /><br> <br> <input
			type="SUBMIT" value="Inserisci"> <br> <br> <a
			href="/wmesjsp/ClientServlet?richiesta=indietro"><span class="fs">Back </span></a>

	</form>
</body>
</html>