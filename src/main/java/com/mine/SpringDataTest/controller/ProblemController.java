package com.mine.SpringDataTest.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mine.SpringDataTest.Model.Problem;
import com.mine.SpringDataTest.service.ProblemService;

@RestController
@RequestMapping("/problems")
public class ProblemController {

	@Autowired 
	ProblemService service; 

	private Logger logger = LoggerFactory.getLogger(ProblemController.class);
	
	@GetMapping(produces = { "application/json" })
    public @ResponseBody List<Problem> getAllProblems() {
		logger.info("inside problemController().getAllProblems()");
		return service.getAllProblem();
    }
	
	@GetMapping("/{id}")
    public @ResponseBody Problem getProblemById(@PathVariable int id) {
		logger.info("inside problemController().getProblemById()");
		return service.getProblemById(id); 
    }
	
	@PostMapping(produces = { "application/json" })
    public @ResponseBody Problem addProblem(@RequestBody Problem problem) {
		logger.info("inside problemController().addProblem(), problem is "+problem);
		return service.addProblem(problem); 
    }
	
	@DeleteMapping("/{id}")
    public @ResponseBody void deleteProblem(@PathVariable int id) {
		logger.info("inside problemController().deleteProblem(), id is "+id);
		service.deleteProblem(id);
    }
	
	@PutMapping("/{id}")
    public @ResponseBody Problem updateProblem(@PathVariable int id, 
    		@RequestBody Problem problem) {
		logger.info("inside problemController().updateProblem(), problem is "+problem);
		return service.updateProblem(problem); 
    }
}
