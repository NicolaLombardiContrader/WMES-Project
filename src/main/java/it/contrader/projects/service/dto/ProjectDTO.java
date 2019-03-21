package it.contrader.projects.service.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Project entity.
 */
public class ProjectDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String link;

    private String description;

    private Float addedValue;

    private ZonedDateTime endDate;

    private ZonedDateTime nextCriticalDate;

    private String status;

    private Long fileId;

    private Long programId;

    private Long personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(Float addedValue) {
        this.addedValue = addedValue;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public ZonedDateTime getNextCriticalDate() {
        return nextCriticalDate;
    }

    public void setNextCriticalDate(ZonedDateTime nextCriticalDate) {
        this.nextCriticalDate = nextCriticalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProjectDTO projectDTO = (ProjectDTO) o;
        if (projectDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", link='" + getLink() + "'" +
            ", description='" + getDescription() + "'" +
            ", addedValue=" + getAddedValue() +
            ", endDate='" + getEndDate() + "'" +
            ", nextCriticalDate='" + getNextCriticalDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", file=" + getFileId() +
            ", program=" + getProgramId() +
            ", person=" + getPersonId() +
            "}";
    }
}
