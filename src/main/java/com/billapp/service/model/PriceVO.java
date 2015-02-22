package com.billapp.service.model;

import java.io.Serializable;

import com.billapp.model.Customer;
import com.billapp.model.Item;

public class PriceVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long priceId;
	private long custId;
	private long itemId;
	private double unitPrice;
	private String itemName;
	private String customerName; 
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private Item item;
	private Customer customer;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/*@ManyToMany
    @JoinTable(name="item", joinColumns = @JoinColumn(name="id"), inverseJoinColumns=@JoinColumn(name="item_id"))
    
	
	@ManyToMany
    @JoinTable(name="customer", joinColumns = @JoinColumn(name="id"), inverseJoinColumns=@JoinColumn(name="customer_id"))
    
	*/
	public long getPriceId() {
		return priceId;
	}
	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
