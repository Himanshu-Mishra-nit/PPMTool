package io.agileintelligence.ppmtool.service.impl;

import java.util.UUID;

import io.agileintelligence.ppmtool.mapper.ProjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.dto.ProjectDto;
import io.agileintelligence.ppmtool.repository.ProjectRepository;
import io.agileintelligence.ppmtool.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	

	@Override
	public ProjectDto saveProject(ProjectDto project) {
		try {
			Project projectEntity = new Project();
			BeanUtils.copyProperties(projectEntity, project);
			projectEntity.setId(UUID.randomUUID().toString());
			return ProjectMapper.entityProjectToDto(projectRepository.save(projectEntity));
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public ProjectDto updateProject(ProjectDto project, String id) {
		
		return null;
	}
	
}
