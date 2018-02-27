package com.hit.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.management.domain.PlanManagement;
import com.hit.management.service.PlanManagementService;

@RestController
public class PlanManagementController {

	@Autowired
	private PlanManagementService planManagementService;

	@RequestMapping(value = "/plan")
	public PlanManagement getPlanByPlanId(String planId) {
		return planManagementService.findPlanByPlanId(planId);
	}

	@RequestMapping(value = "/plans")
	public List<PlanManagement> getPlans() {
		return planManagementService.findAllPlans();
	}

	@RequestMapping(value = "/plan", method = RequestMethod.PUT)
	public PlanManagement updatePlan(PlanManagement planManagement) {
		return planManagementService.updatePLan(planManagement);
	}

	@RequestMapping(value = "/plan", method = RequestMethod.POST)
	public PlanManagement addPlan(@RequestBody PlanManagement planManagement) {
		return planManagementService.addPlan(planManagement);
	}

	@RequestMapping(value = "/plan", method = RequestMethod.DELETE)
	public PlanManagement deletePlan(String planId) {
		return planManagementService.deletePlanManagment(planId);
	}

}
