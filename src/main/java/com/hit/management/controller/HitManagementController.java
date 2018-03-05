package com.hit.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hit.management.domain.HitManagement;
import com.hit.management.service.HitManagementService;

@RestController
public class HitManagementController {

	@Autowired
	private HitManagementService hitManagementService;

	@RequestMapping(value = "/checkhits")
	public boolean checkHits(String clientId) {
		return hitManagementService.hasLimit(clientId);
	}

	@RequestMapping(value = "/hit", method = RequestMethod.POST)
	public HitManagement addHitManagement(@RequestBody HitManagement hitManagement) {
		return hitManagementService.addHitManagement(hitManagement);
	}

	
	@RequestMapping(value = "/hit", method = RequestMethod.PUT)
	public HitManagement updateHitManagement(@RequestBody HitManagement hitManagement) {
		return hitManagementService.updateHitManagement(hitManagement);
	}
	
	@RequestMapping(value = "/hit", method = RequestMethod.GET)
	public HitManagement getHitManagement(String clientId) {
		HitManagement hitManagement =  hitManagementService.findHitManagmentByClientId(clientId);
		if(hitManagement != null) {
			return hitManagement ;
		}
		throw new RuntimeException("Invaild client Id");
	}
	
}

