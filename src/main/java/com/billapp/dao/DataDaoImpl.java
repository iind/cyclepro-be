package com.billapp.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.billapp.model.Contractor;
import com.billapp.model.Cost;
import com.billapp.model.Customer;
import com.billapp.model.Employee;
import com.billapp.model.Item;
import com.billapp.model.Price;
import com.billapp.model.PriceBk;



public class DataDaoImpl implements DataDao {

	private static final Logger log = Logger.getLogger(DataDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	
	public boolean addEntity(Employee employee) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return false;
	}

	
	public Employee getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}

	@SuppressWarnings("unchecked")
	
	public List<Employee> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Employee> employeeList = session.createCriteria(Employee.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Employee.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItems() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Item> itemList = session.createCriteria(Item.class).setMaxResults(25).list();
		tx.commit();
		session.close();
		return itemList;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Customer> customerList = session.createCriteria(Customer.class).setMaxResults(25)
				.list();
		tx.commit();
		session.close();
		return customerList;
	}

	@SuppressWarnings("unchecked")
	public List<Contractor> getContractors() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		
		List<Contractor> contractorList = session.createCriteria(Contractor.class).setMaxResults(25)
				.list();
		tx.commit();
		session.close();
		return contractorList;
	}


	public boolean addCost(Cost cost) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(cost);
		tx.commit();
		session.close();
		return false;
	}


	public Cost getCostById(long id) throws Exception {
		session = sessionFactory.openSession();
		Cost cost = (Cost) session.load(Cost.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return cost;
	}

	@SuppressWarnings("unchecked")
	public List<Cost> getCost() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		/*List<Cost> costList = session.createSQLQuery("SELECT {item.*}, {cust.*},{cost.*} FROM ITEM i, Customer cust,Cost c WHERE "
				+ " c.item_id = i.item_id and c.customer_id = cust.customer_id")
		 .addEntity("item", Item.class)
		 .addEntity("cust", Customer.class)
		 .addEntity("cost", Cost.class).list();*/
		List<Cost> costList = session.createCriteria(Cost.class).setMaxResults(200).list();
		tx.commit();
		session.close();
		return costList;
	}


	public boolean deleteCost(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Cost.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}


	public boolean updateCost(Cost cost) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(cost);
		tx.commit();
		session.close();
		return false;
	}


	public boolean addPrice(Price price) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(price);
		tx.commit();
		session.close();
		return false;
	}


	public Price getPriceById(long id) throws Exception {
		session = sessionFactory.openSession();
		Price price = (Price) session.load(Price.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return price;
	}

	@SuppressWarnings("unchecked")
	public List<PriceBk> getPrice() throws Exception {
		log.info("get all price info");
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		//SELECT i.id as itemid,i.name as itemname, c.id as custid,c.name as custname,p.id as priceid,p.unit_price as price
		// FROM ITEM i, Customer c,Price p WHERE 
		//  p.item_id = i.id and c.id = p.customer_id;                  
		List<PriceBk> costList = session.createSQLQuery("SELECT itemid as {item.id}, itemname as {item.name},  custid as {cust.id}, "
				+ "custname as {cust.name}, priceid as {price.id},price as {price.unitPrice} FROM ITEM i, Customer c,Price p WHERE "
				+ " p.item_id = i.id and c.id = p.customer_id")
		 .addEntity("item", Item.class)
		 .addEntity("cust", Customer.class)
		 .addEntity("price", Price.class).setMaxResults(200).list();
		log.info("after query execution");
		for(PriceBk price : costList){
			StringBuilder print = new StringBuilder();
			print.append("Cust Id"+ price.getCustId()+"\n");
			//print.append("Cust Name"+ price.getCustomer().getCustName()+"\n");
			print.append(price.getUnitPrice()+"\n");
			//print.append("Item Name"+price.getItem().getItemName()+"\n");
			print.append("Item Id"+price.getItemId()+"\n");
			System.out.println(print.toString());
		}
		tx.commit();
		session.close();
		return costList;
	}


	public boolean deletePrice(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Price.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}


	public boolean updatePrice(Price price) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(price);
		tx.commit();
		session.close();
		return false;
	}

	/*@SuppressWarnings("unchecked")
	public List<Price> getPrices() throws Exception {
		//System.out.println("Inside testing");
		log.info("inside get Prices");
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		//TODO need to change the max limit
		
		List<Price> contractorList = session.createCriteria(Price.class).list();
		//Criteria criteria = session.createCriteria(Price.class).setMaxResults(200);
		//List<Price> contractorList =  criteria.list();
		/*Query query = session.createQuery("from price");
		query.setMaxResults(200);
		List<Price> contractorList =  query.list();*/
		//tx.commit();
		//session.close();
		//log.info("Price List" +contractorList.size());
		//return contractorList;
	//}
	
	@SuppressWarnings("unchecked")
	public List<Price> getPrices() throws Exception {
		//System.out.println("Inside testing");
		log.info("inside get Prices.........");
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		//TODO need to change the max limit
		
		List<Price> contractorList = session.createCriteria(Price.class).setMaxResults(15).list();
		//Criteria criteria = session.createCriteria(Price.class).setMaxResults(200);
		//List<Price> contractorList =  criteria.list();
		/*Query query = session.createQuery("from price");
		query.setMaxResults(200);
		List<Price> contractorList =  query.list();*/
		tx.commit();
		session.close();
		log.info("Price List" +contractorList.size());
		return contractorList;
	}


	public Customer getCustomerById(long id) throws Exception {
		log.info("getCustomerById =" +id);
		session = sessionFactory.openSession();
		Customer customer = (Customer) session.load(Customer.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return customer;
	}


	public Item getItemById(long id) throws Exception {
		log.info("getItemById =" +id);
		session = sessionFactory.openSession();
		Item item = (Item) session.load(Item.class,
				new Long(id));
		//log.info("item id" +item.getItemId() + "name =" + item.getItemName());
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return item;
	}


	public Contractor getContractorById(long id) throws Exception {
		log.info("getContractorById =" +id);
		session = sessionFactory.openSession();
		Contractor contractor = (Contractor) session.load(Contractor.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return contractor;
	}

}
