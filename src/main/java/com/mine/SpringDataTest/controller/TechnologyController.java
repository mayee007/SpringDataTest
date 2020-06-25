package com.mine.SpringDataTest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mine.SpringDataTest.Model.Technology;
import com.mine.SpringDataTest.service.TechnologyService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/techs")
@Log4j2
public class TechnologyController {

	@Autowired 
	TechnologyService service; 

	private Logger logger = LoggerFactory.getLogger(TechnologyController.class);
	
	@GetMapping(produces = { "application/json" })
    public @ResponseBody List<Technology> getAllTechnologys() {
		logger.warn("inside techController().getAllTechnologys()");
		return service.getAllTechnology();
    } 
	
	@GetMapping("/{id}")
    public @ResponseBody Technology getTechnologyById(@PathVariable int id) {
		logger.info("inside techController().getTechnologyById()");
		return service.getTechnologyById(id); 
    }
	
	@PostMapping(produces = { "application/json" })
    public @ResponseBody Technology addTechnology(@RequestBody Technology tech) {
		logger.info("inside techController().addTechnology(), tech is "+tech);
		return service.addTechnology(tech); 
    }
	
	@DeleteMapping("/{id}")
    public @ResponseBody void deleteTechnology(@PathVariable int id) {
		logger.info("inside techController().deleteTechnology(), id is "+id);
		service.deleteTechnology(id);
    }
	
	@PutMapping("/{id}")
    public @ResponseBody Technology updateTechnology(@PathVariable int id, 
    		@RequestBody Technology tech) {
		logger.info("inside techController().updateTechnology(), tech is "+tech);
		return service.updateTechnology(tech); 
    } 
}
