<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo task</title>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
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
</head>
<br>

<body>
	<div class="pre_contenitore">

		<p>New Task</p>

	</div>
	<br>
	<br>
	<br>

	<form method="POST" action="/wmesjsp/TaskServlet?richiesta=insert">


		Description: <input type="text" size="40" maxlength="40" name="task_description" />
		<br>
		<br>
		Action: <input type="text" size="40" maxlength="40" name="task_action" />
		<br>
		<br>
		Input: <input type="text" size="40" maxlength="40" name="task_input" />
		<br>
		<br>
		Output: <input type="text" size="40" maxlength="40" name="task_output" />
		<br>
		<br>

		Resource: <input type="text" size="40" maxlength="40" name="task_resource" />
		<br>
		<br>
		Time (minutes): <input type="number" size="40" maxlength="40" name="task_time" />
		<br>
		<br>
		State: <select style="width: 275px;" name="task_state">
			<option value="0">Pending</option>
			<option value="1">In progress</option>
			<option value="2">Completed</option>

		</select>
		<br>
		<input type="SUBMIT" value="Add">
	</form>


	<br>
	<br>
	<a href="/wmesjsp/TaskServlet?richiesta=TaskManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>





</body>
</html>