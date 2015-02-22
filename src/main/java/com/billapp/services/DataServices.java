package com.billapp.services;

import java.util.List;

import com.billapp.model.Contractor;
import com.billapp.model.Cost;
import com.billapp.model.Customer;
import com.billapp.model.Employee;
import com.billapp.model.Item;
import com.billapp.model.Price;
import com.billapp.model.PriceBk;

public interface DataServices {
	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public List<Item> getItems() throws Exception;
	public List<Customer> getCustomers() throws Exception;
	public List<Contractor> getContractors() throws Exception;
	
	public boolean addCost(Cost cost) throws Exception;
	public Cost getCostById(long id) throws Exception;
	public List<Cost> getCost() throws Exception;
	public boolean deleteCost(long id) throws Exception;
	public boolean updateCost(Cost cost) throws Exception;
	
	public boolean addPrice(Price price) throws Exception;
	public Price getPriceById(long id) throws Exception;
	public List<PriceBk> getPrice() throws Exception;
	public boolean deletePrice(long id) throws Exception;
	public boolean updatePrice(Price price) throws Exception;
	public List<Price> getPrices() throws Exception;
	
	
	public Customer getCustomerById(long id) throws Exception;
	public Item getItemById(long id) throws Exception;
	public Contractor getContractorById(long id) throws Exception;
	
	//public boolean addPrice(Price price) throws Exception;
	
}
