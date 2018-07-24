package com.kaveinga.interview.professor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImp implements ProfessorService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public Professor create(Professor professor) {
		log.info("create(..)");
		return professorRepository.saveAndFlush(professor);
	}

	@Override
	public Professor update(Professor professor) {
		log.info("update(..)");
		return professorRepository.saveAndFlush(professor);
	}

	@Override
	public Professor getById(Long id) {
		log.info("getById({})", id);
		return professorRepository.getOne(id);
	}

	@Override
	public List<Professor> getAll() {
		log.info("getAll()");
		return professorRepository.findAll();
	}

}
