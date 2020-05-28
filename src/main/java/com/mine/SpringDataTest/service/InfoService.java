package com.mine.SpringDataTest.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mine.SpringDataTest.Model.Info;
import com.mine.SpringDataTest.dao.InfoRepo;
import com.mine.SpringDataTest.service.interfaces.IInfoService;

@Service
public class InfoService implements IInfoService {

	@Autowired
	private InfoRepo repo; 
	private Logger logger = LoggerFactory.getLogger(InfoService.class);
	
	public InfoService() {
	}

	@Override
	public List<Info> getAllInfo() {
		return repo.findAllOrderByModifiedDate(); 
	}

	@Override
	public Info getInfoById(int id) {
		Info tech = repo.findById(id)
							.orElse(null);  
		return tech; 
	}

	@Override
	public Info updateInfo(Info tech) {
		return repo.save(tech); 
	}

	@Override
	public void deleteInfo(int id) {
		logger.info("InfoService::deleteInfo, id = " + id);
		repo.deleteById(id);
	}

	@Override
	public Info addInfo(Info tech) {
		return repo.save(tech); 
	}
	
}
