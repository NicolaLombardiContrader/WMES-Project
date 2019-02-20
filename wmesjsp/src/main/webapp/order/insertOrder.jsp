<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo ordine</title>
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
<h1>Inserisci</h1>

<form method="POST" action="/wmesjsp/OrderServlet?richiesta=insert">

 
    UserId: <input type="text" size="40" maxlength="40" name="user_id"  /><br> 
    ClientId: <input type="text" size="40" maxlength="40" name="client_id"  /><br> 
    Description: <input type="text" size="40" maxlength="40" name="order_description"  /><br>
    
	<input type="SUBMIT" value="Inserisci">
	
</form>  
</body>
</html>