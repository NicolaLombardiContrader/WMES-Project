package it.contrader.projects.service.mapper;

import it.contrader.projects.domain.*;
import it.contrader.projects.service.dto.ProgramDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Program and its DTO ProgramDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProgramMapper extends EntityMapper<ProgramDTO, Program> {



    default Program fromId(Long id) {
        if (id == null) {
            return null;
        }
        Program program = new Program();
        program.setId(id);
        return program;
    }
}
