package com.hit.management.domain;

import org.springframework.data.annotation.Id;
/*import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;*/
import org.springframework.data.mongodb.core.mapping.Document;

//@Table("planmanagement")
@Document(collection = "planmanagement")
public class PlanManagement {

	@Id
	private String id;
	
	//@PrimaryKey
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
