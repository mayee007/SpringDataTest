package com.mine.SpringDataTest.client;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FullNameClientController {

	String url = "http://localhost:8085/api/names"; 
	//String url = "http://192.168.22.10:8000/api/names"; 
	private Logger logger = LoggerFactory.getLogger(FullNameClientController.class);
	
	@RequestMapping("/clientnames")
	public ModelAndView getAllNames2() {
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] objs = restTemplate.getForObject(url, Object[].class); 
		
		logger.info(objs.toString());
		
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("allNames", objs); 
        mv.setViewName("allNames"); 
        
        return mv; 
	}

	/*@RequestMapping("/names")
	public ModelAndView getAllNames() {
		RestTemplate restTemplate = new RestTemplate();
		 
		logger.info("inside getAllNames");
        // Send request with GET method and default Headers. (WORKING) 
        String result = restTemplate.getForObject(url, String.class);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FullName[]> entity = new HttpEntity<FullName[]>(headers);
        ResponseEntity<FullName[]> response = restTemplate.exchange(url, 
                HttpMethod.GET, entity, FullName[].class);
        
        logger.info("response from method 2" + response.toString());
        
        
        ModelAndView mv = new ModelAndView(); 
        mv.addObject("allNames", result); 
        mv.setViewName("allNames"); 
        
        logger.info("going to call view name");
        return mv; 
	}
   */ 
	
		
}
