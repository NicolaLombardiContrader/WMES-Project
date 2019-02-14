<%@ page import="com.virtualpairprogrammers.domain.Utente" %>

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="RecruiterServlet" method="post">
    Valutazione<input type="text" name="valutazione">
    Commento<input type="text" name="commento">
    Id<input type="text" name="id">
    <input type="submit" value="Commenta e valuta candidato" name="richiesta">
</form>
<a href="homeRecruiter.jsp">Home</a>
</body>
</html>