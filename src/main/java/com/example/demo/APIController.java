package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class APIController {

	public String getTopStories() {
		String topStoriesUrl = "https://hacker-news.firebaseio.com/v0/topstories.json";
    	RestTemplate restTemplate = new RestTemplate();
    	String result = restTemplate.getForObject(topStoriesUrl, String.class);

        return result;
	}

	public String requestStoryDetail(String id) {
		String storyDetailURL = "https://hacker-news.firebaseio.com/v0/item/" + id + ".json";
    	RestTemplate restTemplate = new RestTemplate();
    	String result = restTemplate.getForObject(storyDetailURL, String.class);

    	return result;
	}

	@RequestMapping("/api/{id}")
	@ResponseBody
	public String storyDetail(@PathVariable("id") String id) {
		String result = requestStoryDetail(id);

		return result;
	}

	@RequestMapping("/api")
	@ResponseBody
	public String index() {
		String result = getTopStories();

		return result;
	}

}