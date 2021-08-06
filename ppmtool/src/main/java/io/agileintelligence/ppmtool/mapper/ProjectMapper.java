package io.agileintelligence.ppmtool.mapper;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.dto.ImmutableProjectDto;
import io.agileintelligence.ppmtool.dto.ProjectDto;

import java.util.UUID;

public interface ProjectMapper {
	
	
	public static ProjectDto entityProjectToDto(Project project) {
		return ImmutableProjectDto.builder()
				.id(UUID.fromString(project.getId()))
				.name(project.getName())
				.identifier(project.getIdentifier())
				.description(project.getDescription())
				.start_date(project.getStart_date())
				.end_date(project.getEnd_date())
				.created_At(project.getCreated_At())
				.updated_At(project.getUpdated_At())
				.build();
	}

}
