package it.contrader.projects.service.mapper;

import it.contrader.projects.domain.*;
import it.contrader.projects.service.dto.TaskDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Task and its DTO TaskDTO.
 */
@Mapper(componentModel = "spring", uses = {ProjectMapper.class})
public interface TaskMapper extends EntityMapper<TaskDTO, Task> {

    @Mapping(source = "project.id", target = "projectId")
    TaskDTO toDto(Task task);

    @Mapping(source = "projectId", target = "project")
    Task toEntity(TaskDTO taskDTO);

    default Task fromId(Long id) {
        if (id == null) {
            return null;
        }
        Task task = new Task();
        task.setId(id);
        return task;
    }
}
