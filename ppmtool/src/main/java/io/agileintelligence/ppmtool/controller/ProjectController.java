package io.agileintelligence.ppmtool.controller;

import io.agileintelligence.ppmtool.commons.CommonsConstraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.dto.ProjectDto;
import io.agileintelligence.ppmtool.service.ProjectService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> createNewProject(@RequestBody ProjectDto project){

			ProjectDto project1 = projectService.saveProject(project);
			if(project1 == null)
				return new ResponseEntity<String>("Internal server error", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ProjectDto>(project1, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity<?> updateProject(@PathVariable("id") String id, @RequestBody ProjectDto projectDto){
	try {
		if (!id.equals(projectDto.getId().toString())) {
			return new ResponseEntity<>(CommonsConstraints.PATH_ID_NOT_SAME, HttpStatus.BAD_REQUEST);
		}

		ProjectDto projectDto1 = projectService.updateProject(projectDto);
		if (projectDto1 == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CommonsConstraints.ID_NOT_EXIST);
		}
		return ResponseEntity.ok(projectDto1);
	}catch (Exception exception){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CommonsConstraints.SERVER_ERROR);
	}



	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> findProjectById(@PathVariable("id") String id){
		try{ProjectDto project = projectService.findProjectById(id);
			if (project == null){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CommonsConstraints.ID_NOT_EXIST);
			}
			return ResponseEntity.ok(project);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CommonsConstraints.SERVER_ERROR);
		}
	}

	@RequestMapping(method  = RequestMethod.GET, value = "/findAll")
	public ResponseEntity<?> findAllProjects(){
		try{
			List<ProjectDto> projectDtoList = projectService.findAllProjects();
			if (projectDtoList == null || projectDtoList.isEmpty()){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CommonsConstraints.ID_NOT_EXIST);
			}
			return ResponseEntity.ok(projectDtoList);
		}catch (Exception exception){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CommonsConstraints.SERVER_ERROR);
		}

	}

}
