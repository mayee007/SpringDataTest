package com.mine.SpringDataTest.service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.mine.SpringDataTest.Model.Technology;
import com.mine.SpringDataTest.controller.TechnologyController;
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
		//return repo.findAll(); 
		logger.info("inside TechnologyService::getAllTechnology()");
		return repo.findAllOrderByCategory(); 
	}

	@Override
	public Technology getTechnologyById(int id) {
		logger.info("inside TechnologyService::getTechnologyById(), ID is "+id);

		return repo.findById(id).get(); 
	}

	@Override
	public Technology updateTechnology(Technology tech) {
		logger.info("TechnologyService::updateTechnology() "+ tech);
		Technology newTech = repo.save(tech); 
		return newTech;
	}

	@Override
	public void deleteTechnology(int id) {
		logger.info("TechnologyService::deleteTechnology, id = " + id);
		Technology tech = repo.findById(id).get(); 
		repo.delete(tech);
	}

	@Override
	public Technology addTechnology(Technology tech) {
		logger.info("TechnologyService::addTechnology() "+ tech);
		Technology newTech = repo.save(tech); 
		logger.info("adding record "+ tech.getTechnologyId() + " to redis");
		return newTech;
	}
	
}
