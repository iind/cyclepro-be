

import org.springframework.web.client.RestTemplate;

import com.billapp.model.Employee;

//import com.billapp.controller.EmpRestURIConstants;


public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:8080/SpringRestCrud/employee/";
	
	public static void main(String args[]){
		
		/*testGetDummyEmployee();
		System.out.println("*****");
		
		System.out.println("*****");*/
		//testGetEmployee();
		System.out.println("*****");
		//testGetAllEmployee();
		testCreateEmployee();
	}

	
	private static void testCreateEmployee() {
		System.out.println("inside create");
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee();
		emp.setId(4);
		emp.setFirstName("Sumathi");
		emp.setLastName("Vijay");
		restTemplate.postForObject(SERVER_URI+"create", emp, Employee.class);
		System.out.println("after create");
	}
	private static void testGetAllEmployee() {
		
		/*RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.GET_ALL_EMP, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}*/
	}

	/*private static void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		EmployeeVO emp = new EmployeeVO();
		emp.setId(1);emp.setName("Pankaj Kumar");
		EmployeeVO response = restTemplate.postForObject(SERVER_URI+EmpRestURIConstants.CREATE_EMP, emp, EmployeeVO.class);
		printEmpData(response);
	}

	private static void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		EmployeeVO emp = restTemplate.getForObject(SERVER_URI+"/rest/emp/1", EmployeeVO.class);
		printEmpData(emp);
	}

	private static void testGetDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		EmployeeVO emp = restTemplate.getForObject(SERVER_URI+EmpRestURIConstants.DUMMY_EMP, EmployeeVO.class);
		printEmpData(emp);
	}
	
	public static void printEmpData(EmployeeVO emp){
		System.out.println("ID="+emp.getId()+",Name="+emp.getName()+",CreatedDate="+emp.getCreatedDate());
	}*/
}
