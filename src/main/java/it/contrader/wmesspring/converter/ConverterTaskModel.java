package it.contrader.wmesspring.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.wmesspring.dto.TaskModelDTO;
import it.contrader.wmesspring.model.TaskModel;

public class ConverterTaskModel {

	public static TaskModelDTO toDTO(TaskModel taskModel) {
		TaskModelDTO taskModelDTO = null;
		if (taskModel != null) {
			taskModelDTO = new TaskModelDTO();

			taskModelDTO.setTaskModelId(taskModel.getTaskModelId());
			taskModelDTO.setUserDTO(ConverterUser.toDTO(taskModel.getUser()));
			taskModelDTO.setResourceDTO(ConverterResource.toDTO(taskModel.getResource()));
			taskModelDTO.setTaskModelAction(taskModel.getTaskModelAction());
			taskModelDTO.setTaskModelDescription(taskModel.getTaskModelDescription());
			// taskModelDTO.setTaskModelInput(taskModel.getTaskModelInput());
			// taskModelDTO.setTaskModelOutput(taskModel.getTaskModelOutput());
			taskModelDTO.setTaskModelTime(taskModel.getTaskModelTime());
			taskModelDTO.setTaskModelState(taskModel.getTaskModelState());

			taskModelDTO.setItemsDTO(ConverterItem.toListDTO(taskModel.getItems()));	

		}
		return taskModelDTO;
	}

	public static TaskModel toEntity(TaskModelDTO taskModelDTO) {
		TaskModel taskModel = null;
		if (taskModelDTO != null) {
			taskModel = new TaskModel();
			taskModel.setTaskModelId(taskModelDTO.getTaskModelId());
			taskModel.setUser(ConverterUser.toEntity(taskModelDTO.getUserDTO()));
			taskModel.setResource(ConverterResource.toEntity(taskModelDTO.getResourceDTO()));
			taskModel.setTaskModelAction(taskModelDTO.getTaskModelAction());
			taskModel.setTaskModelDescription(taskModelDTO.getTaskModelDescription());
			// taskModel.setTaskInput(taskModelDTO.getTaskInput());
			// taskModel.setTaskOutput(taskModelDTO.getTaskOutput());
			taskModel.setTaskModelTime(taskModelDTO.getTaskModelTime());
			taskModel.setTaskModelState(taskModelDTO.getTaskModelState());
			taskModel.setItems(ConverterItem.toListEntity(taskModelDTO.getItemsDTO()));	
		}
		return taskModel;
	}

	public static List<TaskModelDTO> toListDTO(List<TaskModel> list) {
		List<TaskModelDTO> listTaskModelDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (TaskModel taskModel : list) {
				listTaskModelDTO.add(ConverterTaskModel.toDTO(taskModel));
			}
		}
		return listTaskModelDTO;
	}

	public static List<TaskModel> toListEntity(List<TaskModelDTO> listTaskModelDTO) {
		List<TaskModel> list = new ArrayList<>();
		if (!listTaskModelDTO.isEmpty()) {
			for (TaskModelDTO taskModelDTO : listTaskModelDTO) {
				list.add(ConverterTaskModel.toEntity(taskModelDTO));
			}
		}
		return list;
	}

}
