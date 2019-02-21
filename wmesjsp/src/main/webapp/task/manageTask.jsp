<%@ include file="/header.jsp"%>
<%!private String convertState(int taskState) {

		switch (taskState) {

		case 0:
			return "Pending";
		case 1:
			return "In Progress";
		case 2:
			return "Completed";
		default:
			return "Pending";
		}

	}%>
<!DOCTYPE html>
<html>
<head>
<title>Gestione Task</title>

<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 4px 40px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: orange;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>
</head>
<%
	List<TaskDTO> allTask = (List<TaskDTO>) request.getAttribute("allTask");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Task Management</p>

	</div>
	<br>

	<br />
	<table>
		<tr>

			<th>Description</th>
			<th>Action</th>
			<th>Input</th>
			<th>Output</th>
			<th>Resource</th>
			<th>Time</th>
			<th>State</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
		<%
			for (TaskDTO task : allTask) {
		%>
		<tr>

			<td><%=task.getTaskDescription()%></td>
			<td><%=task.getTaskAction()%></td>
			<td><%=task.getTaskInput()%></td>
			<td><%=task.getTaskOutput()%></td>
			<td><%=task.getTaskResource()%></td>
			<td><%=task.getTaskTime()%></td>
			<td><%=convertState(task.getTaskState())%></td>



			<td><a href="/wmesjsp/TaskServlet?richiesta=updateRedirect&id=<%=task.getId()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td><a href="/wmesjsp/TaskServlet?richiesta=delete&id=<%=task.getId()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/wmesjsp/TaskServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Task</i></a>
	<br>
	<br>
	<a href="/wmesjsp/TaskServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

</body>
</html>