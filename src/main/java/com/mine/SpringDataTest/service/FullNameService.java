package com.mine.SpringDataTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mine.SpringDataTest.Model.FullName;
import com.mine.SpringDataTest.dao.NameRepo;

@Service
public class FullNameService implements IFullNameService {

	@Autowired
	private NameRepo repo; 
	
	public FullNameService() {
	}

	@Override
	public List<FullName> getAllFullName() {
		return repo.findAll(); 
	}

	@Override
	public FullName getFullNameById(int id) {
		FullName name = repo.findById(id)
							.orElse(null);  
		return name; 
	}

	@Override
	public FullName updateFullName(FullName name) {
		return repo.save(name); 
	}

	@Override
	public void deleteFullName(int id) {
		repo.deleteById(id);
	}

	@Override
	public FullName addFullName(FullName name) {
		return repo.save(name); 
	}
	
}
