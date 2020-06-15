package com.mine.SpringDataTest.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name = "QUESTION")
@XmlRootElement 
//@RedisHash("question")
public class Question implements java.io.Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) //this make the ID autoincrement
	@Column(name = "id")
	int questionId;
	
	@Column 
	String question;
	
	public Question() {
	}

	public Question(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
		
}
