package com.javaguy.app.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javaguy.app.service.models.Application;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
	public Application getApplicationById(Long id);
	public List<Application> getApplicationsByGroupId(Long groupId);
}
