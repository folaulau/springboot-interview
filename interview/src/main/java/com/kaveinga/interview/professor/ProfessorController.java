package com.kaveinga.interview.professor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "professors",produces = "Rest API for professor operations", tags = "Professor Controller")
@RequestMapping("professors")
@RestController
public class ProfessorController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProfessorService professorService;
	
	
	@ApiOperation(value = "Get All")
	@GetMapping
	public ResponseEntity<List<Professor>> getAll() {
		log.info("getAll()");
		List<Professor> professors = professorService.getAll();
		
		return new ResponseEntity<>(professors, HttpStatus.OK);
	}
}
