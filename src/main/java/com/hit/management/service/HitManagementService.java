package com.hit.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.management.domain.HitManagement;
import com.hit.management.domain.PlanManagement;
import com.hit.management.repository.HitManagementRepository;

@Service
public class HitManagementService {

	@Autowired
	private HitManagementRepository hitManagementRepository;

	@Autowired
	private PlanManagementService planManagementService;

	public HitManagement findHitManagmentByClientId(String clientId) {
		return hitManagementRepository.findByClientId(clientId);
	}

	public boolean hasLimit(String clientId) {
		HitManagement hitManagement = findHitManagmentByClientId(clientId);

		PlanManagement planManagement = planManagementService.findPlanByPlanId(hitManagement.getPlanId());
		if (planManagement == null) {
			throw new RuntimeException("Please set Plan First");
		}
		if (planManagement.getTotalhits() >= hitManagement.getCurrentCount() + 1) {
			hitManagement.setCurrentCount(hitManagement.getCurrentCount() + 1);
			updateHitManagementCounter(hitManagement);
			return true;
		}
		return false;
	}

	public HitManagement updateHitManagementCounter(HitManagement hitManagement) {
		return hitManagementRepository.save(hitManagement);
	}

	public HitManagement addHitManagement(HitManagement hitManagement) {
		if (findHitManagmentByClientId(hitManagement.getClientId()) != null) {
			throw new RuntimeException("No Client Id exists");
		}
		return updateHitManagementCounter(hitManagement);
	}

}
