package com.mine.SpringDataTest.controller;

import java.util.List;

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

	@GetMapping(produces = { "application/json" })
    public @ResponseBody List<FullName> getAllFullNames() {
		return service.getAllFullName();
    }
	
	@GetMapping("/{id}")
    public @ResponseBody FullName getFullNameById(@PathVariable int id) {
		return service.getFullNameById(id); 
    }
	
	@PostMapping(produces = { "application/json" })
    public @ResponseBody FullName addFullName(@PathVariable FullName name) {
		return service.addFullName(name); 
    }
	
	@DeleteMapping("/{id}")
    public @ResponseBody void deleteFillName(@PathVariable int id) {
		service.deleteFullName(id);
    }
	
	@PutMapping(produces = { "application/json" })
    public @ResponseBody FullName updateFullName(@PathVariable FullName name) {
		return service.updateFullName(name); 
    }
}
