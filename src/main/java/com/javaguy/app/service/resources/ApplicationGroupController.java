package com.javaguy.app.service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguy.app.service.models.ApplicationGroup;
import com.javaguy.app.service.services.ApplicationGroupService;

@RestController
@RequestMapping("/application-group")
public class ApplicationGroupController {
	@Autowired
	private ApplicationGroupService service;
	
	
	@GetMapping("/group/{groupId}/")
	public ApplicationGroup getApplicationGroup(@PathVariable Long groupId) {
		return service.getApplicationGroup(groupId);
	}
	
	@PostMapping("/new-group")
	public ApplicationGroup saveNewApplicationGroup(@RequestBody ApplicationGroup group) {
		return service.saveNewApplicationGroup(group);
	}
	
	@PutMapping("/update-group")
	public ApplicationGroup updateApplicationGroup(@RequestBody ApplicationGroup group) {
		return service.updateApplicationGroup(group);
	}
}
