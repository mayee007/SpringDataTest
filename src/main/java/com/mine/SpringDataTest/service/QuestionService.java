package com.mine.SpringDataTest.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mine.SpringDataTest.Model.Question;
import com.mine.SpringDataTest.dao.QuestionRepo;
import com.mine.SpringDataTest.service.interfaces.IQuestionService;

@Service
public class QuestionService implements IQuestionService {

	@Autowired
	private QuestionRepo repo; 
	private Logger logger = LoggerFactory.getLogger(QuestionService.class);
	
	public QuestionService() {
	}

	@Override
	public List<Question> getAllQuestion() {
		return repo.findAll(); 
	}

	@Override
	public Question getQuestionById(int id) {
		Question question = repo.findById(id)
							.orElse(null);  
		return question; 
	}

	@Override
	public Question updateQuestion(Question question) {
		return repo.save(question); 
	}

	@Override
	public void deleteQuestion(int id) {
		logger.info("QuestionService::deleteQuestion, id = " + id);
		repo.deleteById(id);
	}

	@Override
	public Question addQuestion(Question question) {
		return repo.save(question); 
	}
	
}
