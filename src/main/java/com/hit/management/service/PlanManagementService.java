package com.hit.management.service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hit.management.domain.PlanManagement;
import com.hit.management.repository.PlanManagementRepository;

@Service
public class PlanManagementService {

	// Map<String, PlanManagement> planManagementCache = new ConcurrentHashMap<>();

	@Autowired
	private PlanManagementRepository planManagementRepository;

	public PlanManagement findPlanByPlanId(String planId) {

		/*
		 * if (planManagementCache.containsKey(planId)) { return
		 * planManagementCache.get(planId); }
		 */

		PlanManagement planManagement = planManagementRepository.findByPlanId(planId);
		if (planManagement == null) {
			throw new RuntimeException("No Plan found for given plan Id");
		}
		return planManagement;
	}

	public PlanManagement addPlan(PlanManagement planManagement) {
		if (planManagementRepository.findByPlanId(planManagement.getPlanId()) != null) {
			throw new RuntimeException("Plan Exists");
		}
		planManagement.setCreateDate(Calendar.getInstance().getTime());
		return planManagementRepository.save(planManagement);
		// planManagementCache.put(planManagement.getPlanid(), planManagement);

		// return planManagement;
	}

	public List<PlanManagement> findAllPlans() {
		// return planManagementCache.values().stream().collect(Collectors.toList());
		return (List<PlanManagement>) planManagementRepository.findAll();
	}

	public PlanManagement updatePLan(PlanManagement planManagement) {

		PlanManagement tempPlanManagement = findPlanByPlanId(planManagement.getPlanId());

		tempPlanManagement.setPlanName(planManagement.getPlanName());
		tempPlanManagement.setTotalHits(planManagement.getTotalHits());
		tempPlanManagement.setUpdatedDate(Calendar.getInstance().getTime());
		// planManagementCache.put(planManagement.getPlanid(), tempPlanManagement);
		return planManagementRepository.save(tempPlanManagement);
	}

	public PlanManagement deletePlanManagment(String planId) {
		PlanManagement planManagement = findPlanByPlanId(planId);
		if (planManagement == null) {
			throw new RuntimeException("No Plan found for given plan Id");
		}
		// planManagementCache.remove(planId);
		planManagementRepository.delete(planManagement);
		return planManagement;

	}

}
