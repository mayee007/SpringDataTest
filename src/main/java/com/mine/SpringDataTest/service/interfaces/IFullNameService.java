package com.mine.SpringDataTest.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.mine.SpringDataTest.Model.FullName;

public interface IFullNameService {
	List<FullName> getAllFullName();

	FullName getFullNameById(int id);
	
	FullName updateFullName(FullName name); 
	
	void deleteFullName(int id); 
	
	FullName addFullName(FullName name); 
}
