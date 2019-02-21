<%@ page import="wmes.dto.TaskDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">

<style>
/*contenitore in cima dove c'è scritto "Login"*/
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 40px 40px;
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

<%
	TaskDTO updateTask = (TaskDTO) request.getAttribute("taskUpdate");
%>
</head>
<br>
<body>
	<div class="center">



		<div class="pre_contenitore">

			<p>Task Update</p>

		</div>
		<form method="POST" action="/wmesjsp/TaskServlet?richiesta=update">
			<br>
			<br>
			<input type="hidden" name="task_id" value="<%=updateTask.getId()%>" /> Description: <input type="text" size="40" maxlength="40"
				name="task_description" value="<%=updateTask.getTaskDescription()%>" />
			<br>
			<br>
			<br>
			Action: <input type="text" size="40" maxlength="40" name="task_action" value="<%=updateTask.getTaskAction()%>" />
			<br>
			<br>
			<br>
			Input: <input type="text" size="40" maxlength="40" name="task_input" value="<%=updateTask.getTaskInput()%>" />
			<br>
			<br>
			<br>
			Output: <input type="text" size="40" maxlength="40" name="task_output" value="<%=updateTask.getTaskOutput()%>" />
			<br>
			<br>
			<br>
			Resource: <input type="text" size="40" maxlength="40" name="task_resource" value="<%=updateTask.getTaskResource()%>" />
			<br>
			<br>
			<br>
			Time: <input type="text" size="40" maxlength="40" name="task_time" value="<%=updateTask.getTaskTime()%>" />
			<br>
			<br>
			<br>
			State: <input type="text" size="40" maxlength="40" name="task_state" value="<%=updateTask.getTaskState()%>" />
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		</form>

		<br>
		<br>
		<a href="/wmesjsp/TaskServlet?richiesta=ClientManager"><span class="fs"> Back </span></a>

	</div>
</body>
</html>