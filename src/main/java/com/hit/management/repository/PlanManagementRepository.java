package com.hit.management.repository;

import org.springframework.data.repository.CrudRepository;

import com.hit.management.domain.PlanManagement;

public interface PlanManagementRepository  extends CrudRepository<PlanManagement,String>{

	PlanManagement findByPlanid(String plainId);
}
