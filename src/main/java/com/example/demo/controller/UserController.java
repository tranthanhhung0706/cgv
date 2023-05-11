package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.PageMeta;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.User;
import com.example.demo.service.CustomerService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {
	public List<User> users = new ArrayList<User>();
	@Autowired
	UserService userService;

	@Autowired
	CustomerService customerService;
	
	@Autowired
    private ModelMapper modelMapper;
	

	// @PostMapping("/user")
	// public User create(@RequestBody User user) {
	// userService.save(user);
	// return user;
	// }
	@GetMapping("user")
	public List<UserDTO> getAll() {
		return userService.findAllUser();
	}

	@GetMapping("customers")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		List<CustomerDTO> customers = customerService.getAllCustomer();
			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("customer")
	public CustomerDTO getCustomerByUserId(@RequestParam Integer userId) {
		return customerService.findCustomerByUserId(userId);
	}

	@GetMapping("customer/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer id) {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(modelMapper.map(customer, CustomerDTO.class), HttpStatus.OK);
	}
	

	@PutMapping("customer/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDTO customerDTO) {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "User not found", null));
		}
		customer.setName(customerDTO.getName());
		customer.setBirthday(customerDTO.getBirthday());
		customer.setPhone_number(customerDTO.getPhone_number());
		customer.setAddress(customerDTO.getAddress());
		customer = customerService.updateCustomer(customer);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "User updated successfully", modelMapper.map(customer, CustomerDTO.class)));
	}

	@DeleteMapping("customer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable Integer id) {
		Customer customer = customerService.getCustomerById(id);
		if (customer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "User not found", null));
		}
		customerService.deleteCustomer(customer);
		return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "User deleted successfully", null));
	}

	@GetMapping("customer/search")
	public ResponseEntity<List<CustomerDTO>> searchCustomers(@RequestParam("q") String searchTerm) {
		List<CustomerDTO> customers = customerService.searchCustomers(searchTerm);
		if (customers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	@GetMapping("customer-page")
	public ResponseEntity<Object> getAllCustomersByPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(name = "q",   defaultValue = "null") String searchTerm)
	{
		Page<Customer> pageCustomer;
		if (searchTerm.equals("null")) {
			pageCustomer = customerService.getAllCustomersByPage(page-1, size);
		}
		else
		{
			pageCustomer = customerService.getAllCustomersByPageSearch(page-1, size, searchTerm);
		}
		//Page<Customer> pageCustomer = customerService.getAllCustomersByPage(page, size);
		if(pageCustomer == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		PageMeta meta = new PageMeta();
		meta.setPageNumber(page);
		meta.setPageSize(size);
		meta.setTotalPages(pageCustomer.getTotalPages());
		meta.setTotalElements(pageCustomer.getTotalElements());
		ApiResponse res = new ApiResponse();
		res.setStatus(HttpStatus.OK.value());
		res.setData(pageCustomer.getContent());
		res.setMeta(meta);
		return ResponseEntity.ok(res);	
		

	}
	


	

	// @PutMapping("api/customer/{id}")
    // public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer updatedCustomer) {
    //     Customer customer = customerService.findCustomerById(id);
    //     if (customer == null) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    //     customer.setName(updatedCustomer.getName());
    //     customer.setEmail(updatedCustomer.getEmail());
    //     customerService.save(customer);
    //     return new ResponseEntity<>(customer, HttpStatus.OK);
    // }

	// @GetMapping("/user/{id}")
	// public User getUserById(@PathVariable int id) {
	// User hung= userService.FindById(id);
	// try {
	// System.out.println(hung.getUsername());
	// } catch (Exception e) {
	// // TODO: handle exception
	// System.out.println("error");
	// }
	//
	// return userService.FindById(id);
	//
	// }
	// @DeleteMapping("/user/{id}")
	// public List<User> delete(@PathVariable int id) {
	// if (userService.FindById(id).getId()!=null) {
	// userService.delete(id);
	// }
	// return userService.findAll();
	// }
	// @PutMapping("/user/{id}")
	// public User update(@RequestBody User user,@PathVariable int id) {
	// try {
	// if (userService.FindById(id).getId()!=null) {
	// user.setId(id);
	// userService.save(user);
	// }
	// return user;
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// return null;
	// }
	// @GetMapping("/user/{id}")
	// public User getUserById(@PathVariable int id) {
	// 	User hung= userService.FindById(id);
	// 	try {
	// 		System.out.println(hung.getUsername());
	// 	} catch (Exception e) {
	// 		// TODO: handle exception
	// 		System.out.println("error");
	// 	}
		
	// 	return userService.FindById(id);
				
	// }
//	@DeleteMapping("/user/{id}")
//	public List<User> delete(@PathVariable int id) {
//		if (userService.FindById(id).getId()!=null) {
//			userService.delete(id);
//		}
//		return userService.findAll();
//	}
//	@PutMapping("/user/{id}")
//	public User update(@RequestBody User user,@PathVariable int id) {
//		try {
//			if (userService.FindById(id).getId()!=null) {
//				user.setId(id);
//				userService.save(user);
//			}
//			return user;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}
}
