<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo ordine</title>
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

<body>
<div class="pre_contenitore">

		<p> Inserisci Ordine </p>

</div>
<br>
<br>
<form method="POST" action="/wmesjsp/OrderServlet?richiesta=insert">

 
    UserId: <input type="text" size="40" maxlength="40" name="user_id"  /><br> 
    <br>
    ClientId: <input type="text" size="40" maxlength="40" name="client_id"  /><br> 
    <br>
    Description: <input type="text" size="40" maxlength="40" name="order_description"  /><br>
    <br>
	<input type="SUBMIT" value="Inserisci">
	
		<br/>
		<br/>
		<a href="/wmesjsp/OrderServlet?richiesta=indietro"><span class="fs"> Indietro </span></a>
	
</form>  
</body>
</html>