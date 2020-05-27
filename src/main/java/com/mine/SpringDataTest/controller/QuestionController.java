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

import com.mine.SpringDataTest.Model.Question;
import com.mine.SpringDataTest.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired 
	QuestionService service; 

	private Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@GetMapping(produces = { "application/json" })
    public @ResponseBody List<Question> getAllQuestions() {
		logger.info("inside QuestionController().getAllQuestions()");
		return service.getAllQuestion();
    }
	
	@GetMapping("/{id}")
    public @ResponseBody Question getQuestionById(@PathVariable int id) {
		logger.info("inside QuestionController().getQuestionById()");
		return service.getQuestionById(id); 
    }
	
	@PostMapping(produces = { "application/json" })
    public @ResponseBody Question addQuestion(@RequestBody Question question) {
		logger.info("inside QuestionController().addQuestion(), Question is "+question);
		return service.addQuestion(question); 
    }
	
	@DeleteMapping("/{id}")
    public @ResponseBody void deleteQuestion(@PathVariable int id) {
		logger.info("inside QuestionController().deleteQuestion(), id is "+id);
		service.deleteQuestion(id);
    }
	
	@PutMapping("/{id}")
    public @ResponseBody Question updateQuestion(@PathVariable int id, 
    		@RequestBody Question question) {
		logger.info("inside QuestionController().updateQuestion(), Question is "+question);
		return service.updateQuestion(question); 
    }
}
