package com.hit.management.domain;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("hitmanagement")
public class HitManagement implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private String clientId;

	private Integer currentCount;

	private String planId;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public Integer getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}

}
