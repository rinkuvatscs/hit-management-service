package com.hit.management.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.PrimaryKey;
/*import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;*/
//import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.cassandra.mapping.Table;

@Table("hitManagement")
//@Document(collection = "hitManagement")
public class HitManagement implements Serializable {

	private static final long serialVersionUID = 1L;

	/*@Id
	private String id;
	*/
	@PrimaryKey
	private String clientId;

	private Integer currentCount;

	private String planId;
	
	private Date createDate ;
	
	private Date updatedDate ;
	

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

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
