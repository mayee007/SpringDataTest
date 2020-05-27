package com.mine.SpringDataTest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mine.SpringDataTest.Model.FullName;
import com.mine.SpringDataTest.controller.FullNameController;
import com.mine.SpringDataTest.dao.NameRepo;
import com.mine.SpringDataTest.service.interfaces.IFullNameService;

@Service
public class FullNameService implements IFullNameService {

	@Autowired
	private NameRepo repo; 
	private Logger logger = LoggerFactory.getLogger(FullNameController.class);
	
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
		logger.info("FullNameService::deleteFullName, id = " + id);
		repo.deleteById(id);
	}

	@Override
	public FullName addFullName(FullName name) {
		return repo.save(name); 
	}
	
}
