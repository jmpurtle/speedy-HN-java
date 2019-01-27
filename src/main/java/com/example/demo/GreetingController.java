package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class GreetingController {

	public String requestStoryDetail(String id) {
		String storyDetailURL = "https://hacker-news.firebaseio.com/v0/item/" + id + ".json";
    	RestTemplate restTemplate = new RestTemplate();
    	String result = restTemplate.getForObject(storyDetailURL, String.class);

    	return result;
	}

	@RequestMapping(value="/greeting/{id}", headers="Accept=application/json")
	@ResponseBody
	public String storyDetail(@PathVariable("id") String id) {
		return requestStoryDetail(id);
	}

	@RequestMapping("/greeting/{id}")
	public String index(@PathVariable("id") String id, Model model) {
		String result = requestStoryDetail(id);

		model.addAttribute("result", result);
		return "greeting";
	}

	@RequestMapping()
	public String defaultMethod(Model model) {
		String result = requestStoryDetail("19011301");

		model.addAttribute("result", result);
		return "greeting";
	}

}