package cybersoft.java12.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.jsp.model.Customer;
import cybersoft.java12.jsp.service.CustomerService;
import cybersoft.java12.jsp.util.PathUtils;
import cybersoft.java12.jsp.util.UrlUtils;

@WebServlet(name = "customerServlet", urlPatterns = {
		UrlUtils.CUSTOMER_DASHBOARD,
		UrlUtils.CUSTOMER_ADD,
		UrlUtils.CUSTOMER_UPDATE,
		UrlUtils.CUSTOMER_DELETE
})
public class CustomerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
		case UrlUtils.CUSTOMER_DASHBOARD: 
			List<Customer> customers = service.findAllCustomers();
			
			req.setAttribute("customers", customers);
			
			req.getRequestDispatcher(PathUtils.CUSTOMER_DASHBOARD)
				.forward(req, resp);
			break;
			
		case UrlUtils.CUSTOMER_ADD:
			req.getRequestDispatcher(PathUtils.CUSTOMER_ADD)
			.forward(req, resp);
			break;
		
		case UrlUtils.CUSTOMER_UPDATE:
			int codeToUpdate = Integer.parseInt(req.getParameter("code"));
			
			Customer customerToUpdate = service.findCustomerByCode(codeToUpdate);
			
			req.setAttribute("customer", customerToUpdate);
			
			req.getRequestDispatcher(PathUtils.CUSTOMER_UPDATE)
			.forward(req, resp);
			break;
			
		case UrlUtils.CUSTOMER_DELETE:
			int codeToBeDeleted = Integer.parseInt(req.getParameter("code"));
			
			service.deleteCustomerByCode(codeToBeDeleted);
			
			resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
			break;
		
		default:
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
			case UrlUtils.CUSTOMER_ADD:
				Customer newCustomer = new Customer();
//				newCustomer.setCode(Integer.parseInt(req.getParameter("code")));
				newCustomer.setName(req.getParameter("name"));
				newCustomer.setAddress(req.getParameter("address"));
				newCustomer.setEmail(req.getParameter("email"));
				
				service.addNewCustomer(newCustomer);
				
				resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
				break;
			case UrlUtils.CUSTOMER_UPDATE:
				int codeToUpdate = Integer.parseInt(req.getParameter("code"));
				
				Customer customerToUpdate = service.findCustomerByCode(codeToUpdate);
				
				customerToUpdate.setName(req.getParameter("name"));
				customerToUpdate.setAddress(req.getParameter("address"));
				customerToUpdate.setEmail(req.getParameter("email"));
				
				service.update(customerToUpdate, codeToUpdate);
				
				resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
				break;
		} 	
			
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		service = new CustomerService();
	}
}
