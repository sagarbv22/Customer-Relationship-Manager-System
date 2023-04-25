package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/list")
	public String getCustomerList(Map<String, Object> model) {

		List<Customer> customers = service.getCustomers();
		customers.forEach(System.out::println);
		model.put("customers", customers);

		return "list-customer";
	}

	@GetMapping("showForm")
	public String showForm(Map<String, Object> model) {
		Customer customer = new Customer();
		model.put("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		System.out.println(customer);
		service.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam Integer customerId, Map<String, Object> model) {

		Customer customer = service.getCustomerById(customerId);
		model.put("customer", customer);

		return "customer-form";

	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam Integer customerId) {
		System.out.println(customerId);
		service.deleteCustomerById(customerId);

		return "redirect:/customer/list";

	}

}
