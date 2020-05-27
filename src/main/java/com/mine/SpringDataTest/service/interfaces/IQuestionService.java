package com.mine.SpringDataTest.service.interfaces;

import java.util.List;

import com.mine.SpringDataTest.Model.Question;

public interface IQuestionService {
	List<Question> getAllQuestion();

	Question getQuestionById(int id);
	
	Question updateQuestion(Question question); 
	
	void deleteQuestion(int id); 
	
	Question addQuestion(Question question); 
}
