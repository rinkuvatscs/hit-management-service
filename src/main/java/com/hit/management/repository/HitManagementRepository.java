package com.hit.management.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hit.management.domain.HitManagement;

public interface HitManagementRepository extends CrudRepository<HitManagement, String> {

	HitManagement findByClientId(String clientId);

	@Query("update HitManagement SET currentCount=currentCount+1 WHERE clientId = ?0;")
	Object updateCounter(String clientId);

}
