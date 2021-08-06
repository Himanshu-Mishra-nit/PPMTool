package io.agileintelligence.ppmtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.dto.ProjectDto;
import io.agileintelligence.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	
	@PostMapping("/add")
	public ResponseEntity<ProjectDto> createNewProject(@RequestBody ProjectDto project){
			ProjectDto project1 = projectService.saveProject(project);
		return new ResponseEntity<ProjectDto>(project1, HttpStatus.CREATED);
	} 

}
