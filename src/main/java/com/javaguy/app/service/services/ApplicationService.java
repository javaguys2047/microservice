package com.javaguy.app.service.services;

import java.util.List;

import com.javaguy.app.service.models.Application;

public interface ApplicationService {
	public Application saveNewApplication(Application app);
	public Application updateApplication(Application app);
	public Application getApplicationById(Long id);
	public List<Application> getApplicationsByGroupId(Long groupId);
	public void deleteApplicationById(Long id);
}
