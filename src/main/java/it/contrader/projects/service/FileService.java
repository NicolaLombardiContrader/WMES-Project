package it.contrader.projects.service;

import it.contrader.projects.service.dto.FileDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing File.
 */
public interface FileService {

    /**
     * Save a file.
     *
     * @param fileDTO the entity to save
     * @return the persisted entity
     */
    FileDTO save(FileDTO fileDTO);

    /**
     * Get all the files.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<FileDTO> findAll(Pageable pageable);


    /**
     * Get the "id" file.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<FileDTO> findOne(Long id);

    /**
     * Delete the "id" file.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
