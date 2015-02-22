package com.billapp.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.billapp.dao.DataDao;
import com.billapp.dao.DataDaoImpl;
import com.billapp.model.Contractor;
import com.billapp.model.Cost;
import com.billapp.model.Customer;
import com.billapp.model.Employee;
import com.billapp.model.Item;
import com.billapp.model.Price;
import com.billapp.model.PriceBk;

public class DataServicesImpl implements DataServices {

	private static final Logger log = Logger.getLogger(DataServicesImpl.class);
	@Autowired
	DataDao dataDao;
	
	
	public boolean addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	
	public Employee getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}


	public List<Item> getItems() throws Exception {
		
		return dataDao.getItems();
	}


	public List<Customer> getCustomers() throws Exception {
		
		return dataDao.getCustomers();
	}


	public List<Contractor> getContractors() throws Exception {
		
		return dataDao.getContractors();
	}


	public boolean addCost(Cost cost) throws Exception {

       return dataDao.addCost(cost);
	}


	public Cost getCostById(long id) throws Exception {
		
		return dataDao.getCostById(id);
	}


	public List<Cost> getCost() throws Exception {
		
		return dataDao.getCost();
	}


	public boolean deleteCost(long id) throws Exception {
		
		return dataDao.deleteCost(id);
	}


	public boolean updateCost(Cost cost) throws Exception {
		return dataDao.updateCost(cost);
	}


	public boolean addPrice(Price price) throws Exception {
		return dataDao.addPrice(price);
	}


	public Price getPriceById(long id) throws Exception {
		return dataDao.getPriceById(id);
	}


	public List<PriceBk> getPrice() throws Exception {
		return dataDao.getPrice();
	}


	public boolean deletePrice(long id) throws Exception {
		return dataDao.deletePrice(id);
	}


	public boolean updatePrice(Price price) throws Exception {
		return dataDao.updatePrice(price);
	}


	public List<Price> getPrices() throws Exception {
		
		return dataDao.getPrices();
	}


	public Customer getCustomerById(long id) throws Exception {
		// TODO Auto-generated method stub
		return dataDao.getCustomerById(id);
	}


	public Item getItemById(long id) throws Exception {
		//log.info("item id = " +id);
		return dataDao.getItemById(id);
	}


	public Contractor getContractorById(long id) throws Exception {
		
		return dataDao.getContractorById(id);
	}

}
