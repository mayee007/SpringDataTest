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
import com.mine.SpringDataTest.dao.TechnologyRepo;
import com.mine.SpringDataTest.service.interfaces.ITechnologyService;

@Service
public class TechnologyService implements ITechnologyService {

	@Autowired
	private TechnologyRepo repo; 
	private Logger logger = LoggerFactory.getLogger(TechnologyService.class);
	private RedisTemplate<String, Technology> redisTemplate; 
	private HashOperations ops; 
	private String KEY = "TECH";
	
	public TechnologyService(RedisTemplate<String, Technology> redisTemplate) {
		this.redisTemplate = redisTemplate;
		ops = redisTemplate.opsForHash();
	}

	@Override
	public List<Technology> getAllTechnology() {
		//return repo.findAll(); 
		//return repo.findAllOrderByCategory(); 
		List<Technology> techs = new ArrayList<Technology>(); 
		for (Technology tech: repo.findAllOrderByCategory()) { 
			techs.add(tech); 
			ops.put(KEY, tech.getTechnologyId(), tech);
		}
		return techs;  
	}

	@Override
	public Technology getTechnologyById(int id) {
		logger.info("inside TechnologyService::getTechnologyById(), ID is "+id);
		if (ops.hasKey(KEY, id)) { 
			logger.info("key "+ id +" exists in redis"); 
			return (Technology) ops.get(KEY, id); 
		}
		Technology tech = null; 
		if (repo.findById(id).isPresent()) { 
			tech = repo.findById(id).get();
		}
		
		return tech; 
	}

	@Override
	public Technology updateTechnology(Technology tech) {
		logger.info("TechnologyService::updateTechnology() "+ tech);
		Technology newTech = repo.save(tech); 
		ops.put(KEY, newTech.getTechnologyId(), newTech);
		return newTech;
	}

	@Override
	public void deleteTechnology(int id) {
		logger.info("TechnologyService::deleteTechnology, id = " + id);
		Technology tech = repo.findById(id).get(); 
		ops.delete(KEY, tech.getTechnologyId()); 
		repo.delete(tech);
	}

	@Override
	public Technology addTechnology(Technology tech) {
		logger.info("TechnologyService::addTechnology() "+ tech);
		Technology newTech = repo.save(tech); 
		logger.info("adding record "+ tech.getTechnologyId() + " to redis");
		ops.put(KEY, newTech.getTechnologyId(), newTech);
		return newTech;
	}
	
}
