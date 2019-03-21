package it.contrader.projects.service.mapper;

import it.contrader.projects.domain.*;
import it.contrader.projects.service.dto.ProjectDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Project and its DTO ProjectDTO.
 */
@Mapper(componentModel = "spring", uses = {FileMapper.class, ProgramMapper.class, PersonMapper.class, TaskMapper.class})
public interface ProjectMapper extends EntityMapper<ProjectDTO, Project> {

    @Mapping(source = "file.id", target = "fileId")
    @Mapping(source = "program.id", target = "programId")
    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "currentTask.id", target = "currentTaskId")
    ProjectDTO toDto(Project project);

    @Mapping(source = "fileId", target = "file")
    @Mapping(source = "programId", target = "program")
    @Mapping(source = "personId", target = "person")
    @Mapping(target = "tasks", ignore = true)
    @Mapping(source = "currentTaskId", target = "currentTask")
    Project toEntity(ProjectDTO projectDTO);

    default Project fromId(Long id) {
        if (id == null) {
            return null;
        }
        Project project = new Project();
        project.setId(id);
        return project;
    }
}
