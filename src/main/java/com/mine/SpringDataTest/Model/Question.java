package com.mine.SpringDataTest.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "QUESTION")
@XmlRootElement 
public class Question implements java.io.Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) //this make the ID autoincrement
	@Column(name = "id")
	int questionId;
	
	@Column 
	String description;
	
	public Question() {
	}

	
	public Question(int questionId, String description) {
		super();
		this.questionId = questionId;
		this.description = description;
	}


	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
