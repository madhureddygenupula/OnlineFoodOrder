package com.ty.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.CustomerDao;
import com.ty.dto.Customer;
import com.ty.dto.Orders;
import com.ty.service.OrderService;

@RestController
public class CustomerController {

	CustomerDao customerDao=new CustomerDao();
	
	@RequestMapping("createcustomer")
	public ModelAndView createCustomer(){
	ModelAndView andView=new ModelAndView();
	andView.addObject("customer",new Customer());
	andView.setViewName("createcustomer.jsp");
	return andView;
		
	}
	
	@RequestMapping(value = "/savecustomer")
	public ModelAndView saveCustomer(HttpServletRequest request,@ModelAttribute Customer customer) throws FileNotFoundException {
		customerDao.saveCustomer(customer);
		
		Orders  orders=(Orders) request.getSession().getAttribute("orders");
		orders.setCustomer(customer);
		orders.setCustomername(customer.getName());
	     new OrderService().orderBill(orders);
		request.getSession().setAttribute("orders", orders);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("bill.jsp");
		mv.addObject("order",orders);
		return mv;
	}
	
}

