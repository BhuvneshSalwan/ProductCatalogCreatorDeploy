package com.xplank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fb_campaign", schema = "api_data")
public class Campaign {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "client_id")
	private	int clientId;
	
	@Column(name = "objective")
	private String objective;
	
	@Column(name = "status")
	private	String status;
	
	@Column(name = "created_at")
	private	String createdAt;
	
	@Column(name = "updated_at")
	private	String updatedAt;
	
	@Column(name = "referrer")
    private String referrer;
	
	@Column(name = "type")
    private String type;
	
	@Column(name = "is_catalog_created")
    private String isCatalogCreated;
	
	@Column(name = "is_updated")
	private String isUpdated;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsCatalogCreated() {
		return isCatalogCreated;
	}

	public void setIsCatalogCreated(String isCatalogCreated) {
		this.isCatalogCreated = isCatalogCreated;
	}
	
	public String getIsUpdated() {
		return isUpdated;
	}

	public void setIsUpdated(String isUpdated) {
		this.isUpdated = isUpdated;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

}
