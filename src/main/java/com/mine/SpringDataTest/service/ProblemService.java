package com.mine.SpringDataTest.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mine.SpringDataTest.Model.Problem;
import com.mine.SpringDataTest.dao.ProblemRepo;
import com.mine.SpringDataTest.service.interfaces.IProblemService;

@Service
public class ProblemService implements IProblemService {

	@Autowired
	private ProblemRepo repo; 
	private Logger logger = LoggerFactory.getLogger(ProblemService.class);
	
	public ProblemService() {
	}

	@Override
	public List<Problem> getAllProblem() {
		return repo.findAllOrderByModifiedDate(); 
	}

	@Override
	public Problem getProblemById(int id) {
		Problem tech = repo.findById(id)
							.orElse(null);  
		return tech; 
	}

	@Override
	public Problem updateProblem(Problem tech) {
		return repo.save(tech); 
	}

	@Override
	public void deleteProblem(int id) {
		logger.info("ProblemService::deleteProblem, id = " + id);
		repo.deleteById(id);
	}

	@Override
	public Problem addProblem(Problem tech) {
		return repo.save(tech); 
	}
	
}
