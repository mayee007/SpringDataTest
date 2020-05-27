package com.mine.SpringDataTest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.mine.SpringDataTest.Model.Problem;

public interface IProblemService {
	List<Problem> getAllProblem();

	Problem getProblemById(int id);
	
	Problem updateProblem(Problem name); 
	
	void deleteProblem(int id); 
	
	Problem addProblem(Problem name); 
}
