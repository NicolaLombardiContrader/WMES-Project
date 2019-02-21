package wmes.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wmes.dto.UserDTO;
import wmes.dto.TaskDTO;
import wmes.service.TaskServiceDTO;


public class TaskServlet extends HttpServlet {

	private TaskServiceDTO taskServiceDTO = new TaskServiceDTO();
	private List<TaskDTO> allTasks = new ArrayList<TaskDTO>();
	private List<TaskDTO> filteredTasks = new ArrayList<TaskDTO>();
	private UserDTO userLogged;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String scelta = request.getParameter("richiesta");
		final HttpSession session = request.getSession(true);
		this.userLogged = (UserDTO) session.getAttribute("utente");

		switch (scelta) {

		case "TaskManager":
			showAllTask(request, response);
			break;

		case "insertRedirect":
			response.sendRedirect("task/insertTask.jsp");
			break;

		case "insert":
			final String taskDescription = request.getParameter("task_description");
			final String taskAction = request.getParameter("task_action");
			final String taskInput = request.getParameter("task_input");
			final String taskOutput = request.getParameter("task_output");
			final String taskResource = request.getParameter("task_resource");
			final int taskTime = Integer.parseInt(request.getParameter("task_time"));
			final int taskState = Integer.parseInt(request.getParameter("task_state"));
			

			final TaskDTO taskInsert = new TaskDTO(userLogged, taskDescription, taskAction, taskInput, taskOutput, taskResource, taskTime, taskState);
			taskServiceDTO.insertTask(taskInsert);
			showAllTask(request, response);
			break;

		case "updateRedirect":
			int id = Integer.parseInt(request.getParameter("id"));
			TaskDTO taskUpdate = new TaskDTO(this.userLogged,"","","","","",0,0);
			taskUpdate.setId(id);

			taskUpdate = this.taskServiceDTO.readTask(taskUpdate);
			request.setAttribute("taskUpdate", taskUpdate);
			getServletContext().getRequestDispatcher("/task/updateTask.jsp").forward(request, response);

			break;

		case "update":
			final Integer taskIdUpdate = Integer.parseInt(request.getParameter("task_id"));
			// final Integer userIdUpdate =
			// Integer.parseInt(request.getParameter("user_id"));
			final String taskDescriptionUpdate = request.getParameter("task_description");
			final String taskActionUpdate = request.getParameter("task_action");
			final String taskInputUpdate = request.getParameter("task_input");
			final String taskOutputUpdate = request.getParameter("task_output");
			final String taskResourceUpdate = request.getParameter("task_resource");
			final int taskTimeUpdate = Integer.parseInt(request.getParameter("task_time"));
			final int taskStateUpdate = Integer.parseInt(request.getParameter("task_state"));

			final TaskDTO taskDTO = new TaskDTO(userLogged, taskDescriptionUpdate, taskActionUpdate,taskInputUpdate,taskOutputUpdate,
					taskResourceUpdate,taskTimeUpdate,taskStateUpdate);
			taskDTO.setId(taskIdUpdate);
			taskServiceDTO.updateTask(taskDTO);
			showAllTask(request, response);
			break;

		case "delete":
			final Integer taskIdDelete = Integer.parseInt(request.getParameter("id"));

			final TaskDTO taskdelete = new TaskDTO(userLogged,"","","","","",0,0);
			taskdelete.setId(taskIdDelete);
			taskServiceDTO.deleteTask(taskdelete);
			showAllTask(request, response);
			break;

		case "indietro":
			response.sendRedirect("homeBO.jsp");
			break;

		case "logsMenu":
			response.sendRedirect("index.jsp");
			break;

		}

	}
	
	// Show all client for user logged
	private void showAllTask(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		allTasks.clear();
		filteredTasks.clear();
		allTasks = this.taskServiceDTO.getAllTask();
		HttpSession session = request.getSession(true);
		UserDTO userLogged=(UserDTO) session.getAttribute("utente");
		
		for (TaskDTO taskDTO:allTasks) {
			if (taskDTO.getUserDTO().getId()==userLogged.getId())
				filteredTasks.add(taskDTO);
		}
			
		request.setAttribute("allTask", filteredTasks);
		getServletContext().getRequestDispatcher("/task/manageTask.jsp").forward(request, response);
	}
}