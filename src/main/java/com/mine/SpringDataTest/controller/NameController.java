package com.mine.SpringDataTest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mine.SpringDataTest.Model.FullName;
import com.mine.SpringDataTest.service.FullNameService;

@RestController
@RequestMapping("/names")
public class NameController {

	@Autowired 
	FullNameService service; 

	private Logger logger = LoggerFactory.getLogger(NameController.class);
	
	@GetMapping(produces = { "application/json" })
    public @ResponseBody List<FullName> getAllFullNames() {
		logger.info("inside NameController().getAllFullNames()");
		return service.getAllFullName();
    }
	
	@GetMapping("/{id}")
    public @ResponseBody FullName getFullNameById(@PathVariable int id) {
		logger.info("inside NameController().getFullNameById()");
		return service.getFullNameById(id); 
    }
	
	@PostMapping(produces = { "application/json" })
    public @ResponseBody FullName addFullName(@PathVariable FullName name) {
		logger.info("inside NameController().getFullNameById(), name is "+name);
		return service.addFullName(name); 
    }
	
	@DeleteMapping("/{id}")
    public @ResponseBody void deleteFullName(@PathVariable int id) {
		logger.info("inside NameController().deleteFullName(), id is "+id);
		service.deleteFullName(id);
    }
	
	@PutMapping(produces = { "application/json" })
    public @ResponseBody FullName updateFullName(@PathVariable FullName name) {
		logger.info("inside NameController().updateFullName(), name is "+name);
		return service.updateFullName(name); 
    }
}
