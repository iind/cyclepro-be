package com.billapp.service.model;

import java.io.Serializable;

import javax.persistence.Column;

import com.billapp.model.Contractor;
import com.billapp.model.Item;

public class CostVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long costid;
	private long contractorId;
	private long itemId;
	private double unitCost;
	private String itemName;
	private String contractorName;
	private Item item;
	private Contractor contracor;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getContractorName() {
		return contractorName;
	}
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	
	public long getCostid() {
		return costid;
	}
	public void setCostid(long costid) {
		this.costid = costid;
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
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Contractor getContracor() {
		return contracor;
	}
	public void setContracor(Contractor contracor) {
		this.contracor = contracor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
