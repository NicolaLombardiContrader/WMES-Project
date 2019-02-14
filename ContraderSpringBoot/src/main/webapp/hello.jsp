<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--
  Created by IntelliJ IDEA.
  User: lorenzovalente
  Date: 10/12/17
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>

${saluto}
${face}<br>
<c:url var="url1" value="/happy"/>
<form action="${url1}" method="post">
<input type="submit" value="Be happy">
</form>

</body>
</html>
