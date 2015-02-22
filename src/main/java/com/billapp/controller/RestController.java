package com.billapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billapp.model.Contractor;
import com.billapp.model.Cost;
import com.billapp.model.Customer;
import com.billapp.model.Employee;
import com.billapp.model.Item;
import com.billapp.model.Price;
import com.billapp.model.PriceBk;
import com.billapp.model.Status;
import com.billapp.service.model.CostVO;
import com.billapp.service.model.PriceVO;
import com.billapp.services.DataServices;

@Controller
@RequestMapping("/rest")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = RestURIConstants.CREATE_EMP, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Employee employee) {
		try {
			dataServices.addEntity(employee);
			return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = RestURIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody
	Employee getEmployee(@PathVariable("id") long id) {
		Employee employee = null;
		try {
			employee = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@RequestMapping(value = RestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody
	List<Employee> getEmployee() {

		List<Employee> employeeList = null;
		try {
			employeeList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	@RequestMapping(value = RestURIConstants.DELETE_EMP, method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployee(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Employee deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = RestURIConstants.GET_ALL_ITEM, method = RequestMethod.GET)
	public @ResponseBody
	List<Item> getAllItems() {

		List<Item> itemList = null;
		try {
			itemList = dataServices.getItems();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return itemList;
	}
	
	
	@RequestMapping(value = RestURIConstants.GET_ALL_CUSTOMER, method = RequestMethod.GET)
	public @ResponseBody
	List<Customer> getAllCustomers() {

		List<Customer> custList = null;
		try {
			custList = dataServices.getCustomers();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return custList;
	}
	
	
	@RequestMapping(value = RestURIConstants.GET_ALL_CONTRACTOR, method = RequestMethod.GET)
	public @ResponseBody
	List<Contractor> getAllContractors() {

		List<Contractor> contractorList = null;
		try {
			contractorList = dataServices.getContractors();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return contractorList;
	}
	
	@RequestMapping(value = RestURIConstants.GET_ALL_COST, method = RequestMethod.GET)
	public @ResponseBody
	List<CostVO> getAllCost() {
		List<Cost> costList = null;
		List<CostVO> costVoList = new ArrayList<CostVO>();
		try {
			costList = dataServices.getCost();
			for(Cost cost : costList){
				CostVO costVo = new CostVO();
				costVo.setContractorId(cost.getContractorId());
				costVo.setCostid(cost.getCostId());
				costVo.setItemId(cost.getItemId());
				costVo.setUnitCost(cost.getUnitCost());
				Item item = getItem(cost.getItemId());
				costVo.setItemName(item.getItemName());
				Contractor contracor = getContById(cost.getContractorId());
				costVo.setContractorName(contracor.getEmailId());
				costVo.setItem(item);
				costVo.setContracor(contracor);
				costVoList.add(costVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return costVoList;
	}
	
	@RequestMapping(value = RestURIConstants.GET_ALL_PRICE, method = RequestMethod.GET)
	public @ResponseBody
	List<PriceBk> getAllPrice() {
		List<PriceBk> priceList = null;
		try {
			priceList = dataServices.getPrice();
			//priceList = dataServices.getPrices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceList;
	}
	/****
	 * working
	 * @return
	 */
	/*@RequestMapping(value = RestURIConstants.GET_ALL_PRICES, method = RequestMethod.GET)
	public @ResponseBody
	List<Price> getAllPrices() {
		List<Price> priceList = null;
		List<Price> prices = new ArrayList<Price>();
		try {
			//priceList = dataServices.getPrice();
			priceList = dataServices.getPrices();
			
			for(Price price : priceList){
				Customer customer = getCustById(price.getCustId());
				Item item = getItem(price.getItemId());
				price.setCustomer(customer);
				price.setItem(item);
				prices.add(price);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prices;
	}*/
	
	@RequestMapping(value = RestURIConstants.GET_ALL_PRICES, method = RequestMethod.GET)
	public @ResponseBody
	List<PriceVO> getAllPrices() {
		
		List<Price> priceList = null;
		List<PriceVO> prices = new ArrayList<PriceVO>();
		try {
			//priceList = dataServices.getPrice();
			priceList = dataServices.getPrices();
			for(Price price : priceList){
				PriceVO priceVO = new PriceVO();
				priceVO.setCustId(price.getCustId());
				priceVO.setItemId(price.getItemId());
				priceVO.setPriceId(price.getId());
				priceVO.setUnitPrice(price.getUnitPrice());
				Customer customer = getCustById(price.getCustId());
				Item item = getItem(price.getItemId());
				priceVO.setItemName(item.getItemName());
				priceVO.setCustomerName(customer.getCustName());
				priceVO.setCustomer(customer);
				priceVO.setItem(item);
				prices.add(priceVO);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prices;
	}
	
	@RequestMapping(value = RestURIConstants.GET_CUSTOMER, method = RequestMethod.GET)
	public @ResponseBody
	Customer getCustById(@PathVariable("id") long id) {
		Customer customer = null;
		try {
			customer = dataServices.getCustomerById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	@RequestMapping(value = RestURIConstants.GET_ITEM, method = RequestMethod.GET)
	public @ResponseBody
	Item getItem(@PathVariable("id") long id) {
		Item item = null;
		try {
			item = dataServices.getItemById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	@RequestMapping(value = RestURIConstants.GET_CONTRACTOR, method = RequestMethod.GET)
	public @ResponseBody
	Contractor getContById(@PathVariable("id") long id) {
		Contractor contracor = null;
		try {
			contracor = dataServices.getContractorById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contracor;
	}
	
	@RequestMapping(value = RestURIConstants.CREATE_PRICE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status createPrice(@RequestBody Price price) {
		logger.info("inside create method =" +price.toString());
		try {
			dataServices.addPrice(price);
			return new Status(1, "Price added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}
	}
	
	@RequestMapping(value = RestURIConstants.DELETE_PRICE, method = RequestMethod.DELETE)
	public @ResponseBody
	Status removePrice(@PathVariable("id") long id) {
        logger.info("inside delete = " +id);
		try {
			
			dataServices.deletePrice(id);
			return new Status(1, "Price deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
	
	@RequestMapping(value = RestURIConstants.EDIT_PRICE, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status editPrice(@RequestBody Price price) {
        logger.info("inside update = " +price.toString());
		try {
			
			dataServices.updatePrice(price);
			return new Status(1, "Price deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
}
