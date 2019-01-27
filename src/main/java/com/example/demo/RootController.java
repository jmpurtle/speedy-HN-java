package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RestController
public class RootController {

    @RequestMapping("/")
    public String index() {
    	// Retrieves the top 100 stories
    	
    	String topStoriesUrl = "https://hacker-news.firebaseio.com/v0/topstories.json";
    	RestTemplate restTemplate = new RestTemplate();
    	String result = restTemplate.getForObject(topStoriesUrl, String.class);

        return result;
    }

}