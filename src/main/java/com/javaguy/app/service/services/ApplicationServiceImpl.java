package com.javaguy.app.service.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.javaguy.app.service.models.Application;
import com.javaguy.app.service.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	private ApplicationRepository repository;
	

	@Override
	@CacheEvict(value={"application"}, allEntries = true)
	@Transactional
	public Application updateApplication(Application app) {
		return repository.save(app);
	}

	@Override
	@Cacheable(value="application",key="#id")
	public Application getApplicationById(Long id) {
		return repository.getApplicationById(id);
	}

	@Override
	@Cacheable(value="application")
	public List<Application> getApplicationsByGroupId(Long groupId) {
		return repository.getApplicationsByGroupId(groupId);
	}

	@Override
	@CacheEvict(value={"application"}, allEntries = true) 
	@Transactional
	public void deleteApplicationById(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	@CacheEvict(value={"application"}, allEntries = true)
	public Application saveNewApplication(Application app) {
		return repository.save(app);
	}

}
