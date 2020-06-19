package com.javaguy.app.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javaguy.app.service.models.Application;
import com.javaguy.app.service.models.ApplicationGroup;

public interface ApplicationGroupRepository extends CrudRepository<ApplicationGroup, Long>{
	public ApplicationGroup getApplicationGroupById(Long id);
	public List<Application> getApplicationsById(Long id);
}
