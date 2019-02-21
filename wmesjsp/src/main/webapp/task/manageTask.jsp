<%@ include file ="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Clienti</title>

<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
	<style>

.pre_contenitore{
	  width:320px;
	  margin:auto;
	  height:50px;
	  border:1px solid black;
	  border-radius: 40px 40px 4px 40px;
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
<%
	List<TaskDTO> allTask = (List<TaskDTO>) request.getAttribute("allTask");
%>
</head>
<body>
	
<div class="pre_contenitore">

		<p> Task Management </p>

</div>
<br>



<br/>
	<table>
		<tr>
			
			<th>Description</th>
			<th>Action</th>
			<th>Input</th>
			<th>Output</th>
			<th>Resource</th>
			<th>Time</th>
			<th>State</th>
		
		</tr>
		<%
			for (TaskDTO task : allTask) {
		%>
		<tr>

			<td><%=task.getTaskDescription()%></td>
			

			<td><a
				href="/wmesjsp/TaskServlet?richiesta=updateRedirect&id=<%=task.getId()%>"><i
					class="fas fa-edit" title="Update"></i></a></td>
			<td><a
				href="/wmesjsp/TaskServlet?richiesta=delete&id=<%=task.getId()%>"><i
					class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
<br>
<br>
<a href="/wmesjsp/TaskServlet?richiesta=insertRedirect"><span class="fs"> New Task </span></a>
<br>
<br>
<a href="/wmesjsp/TasktServlet?richiesta=indietro"><span class="fs"> Back </span></a>

</body>
</html>