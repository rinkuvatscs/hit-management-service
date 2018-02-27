package com.hit.management.domain;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("planmanagement")
public class PlanManagement {

	
	@PrimaryKey
	private String planid ;
	
	private String planname;
	
	private Integer totalhits ;

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public String getPlanname() {
		return planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public Integer getTotalhits() {
		return totalhits;
	}

	public void setTotalhits(Integer totalhits) {
		this.totalhits = totalhits;
	}


	
	
}
