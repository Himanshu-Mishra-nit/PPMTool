package io.agileintelligence.ppmtool.service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.dto.ProjectDto;

public interface ProjectService {

	public ProjectDto saveProject(ProjectDto project);
	
	public ProjectDto updateProject(ProjectDto project, String id);
	
}
