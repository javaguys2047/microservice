package com.javaguy.app.service.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguy.app.service.models.Application;
import com.javaguy.app.service.services.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
	@Autowired
	private ApplicationService service;
	
	
	@GetMapping("/detail/{appId}/")
	public Application getApplication(@PathVariable(name="appId") long appId) {
		return service.getApplicationById(appId);
	}
	
	@GetMapping("/all-app/{groupId}/")
	public List<Application> getAllApplication(@PathVariable(name="groupId") long groupId) {
		return service.getApplicationsByGroupId(groupId);
	}
	
	@PostMapping("/new-application")
	public Application saveNewApplication(@RequestBody Application app) {
		return service.saveNewApplication(app);
	}
	
	@PutMapping("/update-application")
	public Application updateApplication(@RequestBody Application app) {
		return service.updateApplication(app);
	}
	
	@DeleteMapping("/delete-application/{appId}/")
	public String deleteApplication(@PathVariable(name="appId") long appId) {
		service.deleteApplicationById(appId);
		
		return "deleted";
	}
}
