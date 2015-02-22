package com.billapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "cost")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cost implements Serializable{
	@Id
	@Column(name = "id")
	private long costId;

	@Column(name = "customer_id")
	private long contractorId;
	
	@Column(name = "item_id")
	private long itemId;
	
	@Column(name = "unit_cost")
	private double unitCost;
	
	
	
	/*@JoinColumn(name = "item_id")
	private Item item;
	
	@JoinColumn(name = "customer_id")
	private Contractor contractor; 
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Contractor getContractor() {
		return contractor;
	}
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}*/
	
	public long getCostId() {
		return costId;
	}
	public void setCostId(long costId) {
		this.costId = costId;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	
	public long getContractorId() {
		return contractorId;
	}
	public void setContractorId(long contractorId) {
		this.contractorId = contractorId;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	
	
}
