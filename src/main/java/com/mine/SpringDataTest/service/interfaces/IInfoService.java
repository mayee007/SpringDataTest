package com.mine.SpringDataTest.service.interfaces;

import java.util.List;

import com.mine.SpringDataTest.Model.Info;

public interface IInfoService {
	List<Info> getAllInfo();

	Info getInfoById(int id);
	
	Info updateInfo(Info name); 
	
	void deleteInfo(int id); 
	
	Info addInfo(Info name); 
}
