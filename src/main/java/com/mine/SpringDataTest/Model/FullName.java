package com.mine.SpringDataTest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name = "FULLNAME")
//@RedisHash("fullname")
public class FullName {

	@Id //this makes the id as primary key 
	@GeneratedValue(strategy=GenerationType.AUTO) //this make the ID autoincrement
	int id; 
	
	@Column(name="FirstName")
	String firstName; 
	
	@Column(name="LastName")
	String lastName; 
	
	public FullName() {
		
	}
	public FullName(int id, String firstName, String lastName) {
		super();
		this.id = id; 
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "FullName [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
