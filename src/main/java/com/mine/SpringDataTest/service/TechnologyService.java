package com.mine.SpringDataTest.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mine.SpringDataTest.Model.Technology;
import com.mine.SpringDataTest.dao.TechnologyRepo;
import com.mine.SpringDataTest.service.interfaces.ITechnologyService;

@Service
public class TechnologyService implements ITechnologyService {

	@Autowired
	private TechnologyRepo repo; 
	private Logger logger = LoggerFactory.getLogger(TechnologyService.class);
	
	public TechnologyService() {
	}

	@Override
	public List<Technology> getAllTechnology() {
		return repo.findAll(); 
	}

	@Override
	public Technology getTechnologyById(int id) {
		Technology tech = repo.findById(id)
							.orElse(null);  
		return tech; 
	}

	@Override
	public Technology updateTechnology(Technology tech) {
		return repo.save(tech); 
	}

	@Override
	public void deleteTechnology(int id) {
		logger.info("TechnologyService::deleteTechnology, id = " + id);
		repo.deleteById(id);
	}

	@Override
	public Technology addTechnology(Technology tech) {
		return repo.save(tech); 
	}
	
}
