package cybersoft.java12.jsp.service;

import java.util.LinkedList;
import java.util.List;

import cybersoft.java12.jsp.model.Customer;
import cybersoft.java12.jsp.repository.CustomerRepository;

public class CustomerService {
	private List<Customer> customers;
	private CustomerRepository repository;
	
	public CustomerService() {
		repository = new CustomerRepository();
		customers = new LinkedList<Customer>();
		
		customers.add(new Customer(1, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(2, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(3, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(4, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(5, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(6, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(7, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(8, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		customers.add(new Customer(9, "VIP CUSTOMER", "police@gov.kt", "ISIS HQ"));
		
	}
	
	public List<Customer> findAllCustomers(){
		return repository.findAllCustomer();
	}
	
	public Customer findCustomerByCode(int code) {
		
		return repository.findCustomerByCode(code);
	}
	
	public void deleteCustomerByCode(int code) {
		int result = repository.deleteCustomerByCode(code);
		if(result == 1) {
			System.out.println("deleteCustomerByCode completed !!!");
		}else {
			System.out.println("Don't can deleteCustomerByCode");
		}	
	}
	
	public void addNewCustomer(Customer customer) {
		int result = repository.addNewCustomer(customer);
		if(result == 1) {
			System.out.println("addNewCustomer completed !!!");
		}else {
			System.out.println("Don't can addNewCustomer");
		}	
	}
	


	public void update(Customer customerToUpdate, int codeToUpdate) {
		int result = repository.updateCustomer(customerToUpdate);
		if(result == 1) {
			System.out.println("customerToUpdate completed !!!");
		}else {
			System.out.println("Don't can customerToUpdate");
		}	
	}
}
