package com.mine.SpringDataTest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.mine.SpringDataTest.Model.Technology;

public interface ITechnologyService {
	List<Technology> getAllTechnology();

	Technology getTechnologyById(int id);
	
	Technology updateTechnology(Technology name); 
	
	void deleteTechnology(int id); 
	
	Technology addTechnology(Technology name); 
}
