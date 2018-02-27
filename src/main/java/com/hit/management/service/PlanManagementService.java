package com.hit.management.service;

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

	//Map<String, PlanManagement> planManagementCache = new ConcurrentHashMap<>();

	@Autowired
	private PlanManagementRepository planManagementRepository;

	public PlanManagement findPlanByPlanId(String planId) {

	/*	if (planManagementCache.containsKey(planId)) {
			return planManagementCache.get(planId);
		}*/

		PlanManagement planManagement = planManagementRepository.findByPlanid(planId);
		if (planManagement == null) {
			throw new RuntimeException("No Plan found for given plan Id");
		}
		return planManagement;
	}

	public PlanManagement addPlan(PlanManagement planManagement) {
		if (planManagementRepository.findByPlanid(planManagement.getPlanid()) != null) {
			throw new RuntimeException("Plan Exists");
		}
		return planManagementRepository.save(planManagement);
		//planManagementCache.put(planManagement.getPlanid(), planManagement);

		//return planManagement;
	}

	public List<PlanManagement> findAllPlans() {
		//return planManagementCache.values().stream().collect(Collectors.toList());
		return (List<PlanManagement>) planManagementRepository.findAll();
	}

	public PlanManagement updatePLan(PlanManagement planManagement) {

		PlanManagement tempPlanManagement = findPlanByPlanId(planManagement.getPlanid());

		tempPlanManagement.setPlanname(planManagement.getPlanname());
		tempPlanManagement.setTotalhits(planManagement.getTotalhits());

	//	planManagementCache.put(planManagement.getPlanid(), tempPlanManagement);
		return planManagementRepository.save(tempPlanManagement);
	}

	public PlanManagement deletePlanManagment(String planId) {
		PlanManagement planManagement = findPlanByPlanId(planId);
		if (planManagement == null) {
			throw new RuntimeException("No Plan found for given plan Id");
		}
	//	planManagementCache.remove(planId);
		planManagementRepository.delete(planManagement);
		return planManagement;

	}

}
