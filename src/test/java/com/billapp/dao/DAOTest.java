package com.billapp.dao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.billapp.dao.DataDao;
import com.billapp.dao.DataDaoImpl;
import com.billapp.model.Price;


public class DAOTest {

	public static void main(String[] args) {
		
		/*try {

			URL url = new URL(
					"http://localhost:8080/billapp/rest/api/price/list");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
			
		}

	}
*/
	
		/*ClassPathResource classPathResource = new ClassPathResource("//Users/vijay.ramasamy/Desktop/workspace/Test/src/test/java/com/billapp/dao/spring-config.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(classPathResource);
		DataDao impl=   (DataDaoImpl) beanFactory.getBean("dataDao");
		try{
			List<Price>  priceList = impl.getPrice();
			
			for(Price price : priceList){
				StringBuilder print = new StringBuilder();
				print.append("Cust Id"+ price.getCustId()+"\n");
				//print.append("Cust Name"+ price.getCustomer().getCustName()+"\n");
				print.append(price.getUnitPrice()+"\n");
				//print.append("Item Name"+price.getItem().getItemName()+"\n");
				print.append("Item Id"+price.getItemId()+"\n");
				System.out.println(print.toString());
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
	}
	

}
