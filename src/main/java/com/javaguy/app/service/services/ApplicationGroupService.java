package com.javaguy.app.service.services;

import java.util.List;

import com.javaguy.app.service.models.Application;
import com.javaguy.app.service.models.ApplicationGroup;

public interface ApplicationGroupService {
	public ApplicationGroup saveNewApplicationGroup(ApplicationGroup group);
	public ApplicationGroup updateApplicationGroup(ApplicationGroup group);
	public ApplicationGroup getApplicationGroup(Long id);
	public List<Application> getApplications(Long id);
}
