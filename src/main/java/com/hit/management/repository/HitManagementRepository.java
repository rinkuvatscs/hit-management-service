package com.hit.management.repository;

import org.springframework.data.repository.CrudRepository;

import com.hit.management.domain.HitManagement;

public interface HitManagementRepository extends CrudRepository<HitManagement, String> {

	HitManagement findByClientId(String clientId);
}
