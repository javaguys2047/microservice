package com.javaguy.app.service.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javaguy.app.service.models.Application;
import com.javaguy.app.service.models.ApplicationGroup;
import com.javaguy.app.service.repository.ApplicationGroupRepository;

@Service
@CacheConfig(cacheNames={"application_group"})
public class ApplicationGroupServiceImpl  implements ApplicationGroupService {
	@Autowired
	private ApplicationGroupRepository repository;

	@Override
	public ApplicationGroup saveNewApplicationGroup(ApplicationGroup group) {
		return repository.save(group);
	}

	@Override
	@Cacheable(value="application_group",key="#id")
	public ApplicationGroup getApplicationGroup(Long id) {
		return repository.getApplicationGroupById(id);
	}

	@Override
	public List<Application> getApplications(Long id) {
		return repository.getApplicationsById(id);
	}

	@Override
	@CachePut(value="application_group",key="#id")
	public ApplicationGroup updateApplicationGroup(ApplicationGroup group) {
		return repository.save(group);
	}
}
