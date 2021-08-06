package io.agileintelligence.ppmtool.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.agileintelligence.ppmtool.mapper.ProjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
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
	public ProjectDto updateProject(ProjectDto project) {
		try{
			Optional<Project> projectOptional = projectRepository.findById(project.getId().toString());
			if(!projectOptional.isPresent()){
				return null;
			}
			Project project1 = new Project();
			BeanUtils.copyProperties(project1, project);
			return ProjectMapper.entityProjectToDto(projectRepository.save(project1));

		}catch (Exception exception){exception.printStackTrace();}
		return null;
	}

	@Override
	public ProjectDto findProjectById(String id) {
		Optional<Project> project = projectRepository.findById(id);
		if(!project.isPresent()){
			return null;
		}
		return ProjectMapper.entityProjectToDto(project.get());
	}

	@Override
	public List<ProjectDto> findAllProjects() {
		List<Project> projectList= (List<Project>) projectRepository.findAll();
		List<ProjectDto> projectDtoList = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(projectList)) {
			projectList.stream().forEach(project->projectDtoList.add(ProjectMapper.entityProjectToDto(project)));
		}
		return projectDtoList;
	}


}
