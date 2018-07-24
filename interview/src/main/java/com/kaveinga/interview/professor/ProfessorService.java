package com.kaveinga.interview.professor;

import java.util.List;

public interface ProfessorService {

	Professor create(Professor professor);
	Professor update(Professor professor);
	Professor getById(Long id);
	List<Professor> getAll();
}
