package io.agileintelligence.ppmtool.service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

	public ProjectDto saveProject(ProjectDto project);
	
	public ProjectDto updateProject(ProjectDto project);

	public ProjectDto findProjectById(String id);

	public List<ProjectDto> findAllProjects();
}
