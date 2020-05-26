package com.mine.SpringDataTest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FULLNAME2")
public class FullName2 {

	@Id //this makes the id as primary key 
	@GeneratedValue(strategy=GenerationType.AUTO) //this make the ID autoincrement
	long Id; 
	
	@Column(name="FirstName")
	String firstName; 
	
	@Column(name="LastName")
	String lastName; 
	
	public FullName2() {
		
	}
	public FullName2(int id, String firstName, String lastName) {
		super();
		this.Id = id; 
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
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		this.Id = id;
	}
	@Override
	public String toString() {
		return "FullName [id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
