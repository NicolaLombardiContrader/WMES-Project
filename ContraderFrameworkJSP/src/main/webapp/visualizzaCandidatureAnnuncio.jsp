

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<% List<String> nominativi = (List<String>) session.getAttribute("listCandidatiAnnuncio");%>

    </head>
    <body>
    <table>
        <tr>

            <th>
            Nominativo
            </th>
        </tr>

    <%for (String nominativo : nominativi) { %>
        <tr>

            <td>
                <%= nominativo%>
            </td>

         </tr>
         <% }%>
       </table>
      <a href="homeRecruiter.jsp">Home</a>

      </body>
      </html>