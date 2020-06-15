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

import com.mine.SpringDataTest.Model.Info;
import com.mine.SpringDataTest.service.InfoService;

@RestController
@RequestMapping("/infos")
public class InfoController {

	@Autowired 
	InfoService service; 

	private Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	@GetMapping(produces = { "application/json" })
    public @ResponseBody List<Info> getAllInfos() {
		logger.info("inside infoController().getAllInfos()");
		return service.getAllInfo();
    }
	
	@GetMapping("/{id}")
    public @ResponseBody Info getInfoById(@PathVariable int id) {
		logger.info("inside infoController().getInfoById()");
		return service.getInfoById(id); 
    }
	
	@PostMapping(produces = { "application/json" })
    public @ResponseBody Info addInfo(@RequestBody Info info) {
		logger.info("inside infoController().addInfo(), info is "+info);
		return service.addInfo(info); 
    }
	
	@DeleteMapping("/{id}")
    public @ResponseBody void deleteInfo(@PathVariable int id) {
		logger.info("inside infoController().deleteInfo(), id is "+id);
		service.deleteInfo(id);
    }
	
	@PutMapping("/{id}")
    public @ResponseBody Info updateInfo(@PathVariable int id, 
    		@RequestBody Info info) {
		logger.info("inside infoController().updateInfo(), info is "+info);
		return service.updateInfo(info); 
    } 
}
