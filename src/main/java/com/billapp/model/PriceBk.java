package com.billapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "price")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PriceBk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private long priceId;
	
	@Column(name = "customer_id")
	private long custId;
	
	@Column(name = "item_id")
	private long itemId;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@JoinColumn(name = "item_id")
	private Item item;
	
	@JoinColumn(name = "customer_id")
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
