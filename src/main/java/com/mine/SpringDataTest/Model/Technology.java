package com.mine.SpringDataTest.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Entity
@Table(name = "TECHNOLOGY")
@XmlRootElement 
//@RedisHash("technology")
public class Technology implements java.io.Serializable {
		
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) //this make the ID autoincrement
	@Column(name = "id")
	int technologyId;	
	
	@Column 
	String technologyType;
	
	@Column
	String category;
		
	public Technology() {
	}
	
	public Technology(int technologyId, String technologyType, String category) {
		super();
		this.technologyId = technologyId;
		this.technologyType = technologyType;
		this.category = category;
	}
	
	public int getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}
	public String getTechnologyType() {
		return technologyType;
	}
	public void setTechnologyType(String technologyType) {
		this.technologyType = technologyType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
