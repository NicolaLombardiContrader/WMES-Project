package it.contrader.projects.service.impl;

import it.contrader.projects.service.ProjectService;
import it.contrader.projects.domain.Project;
import it.contrader.projects.repository.ProjectRepository;
import it.contrader.projects.service.dto.ProjectDTO;
import it.contrader.projects.service.mapper.ProjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/**
 * Service Implementation for managing Project.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    /**
     * Save a project.
     *
     * @param projectDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        log.debug("Request to save Project : {}", projectDTO);
        Project project = projectMapper.toEntity(projectDTO);
        project = projectRepository.save(project);
        return projectMapper.toDto(project);
    }

    /**
     * Get all the projects.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProjectDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Projects");
        return projectRepository.findAll(pageable)
            .map(projectMapper::toDto);
    }



    /**
     *  get all the projects where CurrentTask is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<ProjectDTO> findAllWhereCurrentTaskIsNull() {
        log.debug("Request to get all projects where CurrentTask is null");
        return StreamSupport
            .stream(projectRepository.findAll().spliterator(), false)
            .filter(project -> project.getCurrentTask() == null)
            .map(projectMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one project by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProjectDTO> findOne(Long id) {
        log.debug("Request to get Project : {}", id);
        return projectRepository.findById(id)
            .map(projectMapper::toDto);
    }

    /**
     * Delete the project by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Project : {}", id);
        projectRepository.deleteById(id);
    }
}
