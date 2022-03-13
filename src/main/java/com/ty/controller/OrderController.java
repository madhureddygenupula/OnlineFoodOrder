package com.ty.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.OrderDao;
import com.ty.dto.Item;
import com.ty.dto.Orders;

@RestController
public class OrderController {

	OrderDao dao = new OrderDao();

	@RequestMapping("displayorder")
	public ModelAndView confirmOrder(HttpServletRequest request) {
		Orders orders = (Orders) request.getAttribute("orders");
		ModelAndView andView = new ModelAndView();
		andView.addObject("orders", orders);
		andView.setViewName("displayorder.jsp");
		return andView;
	}

	@RequestMapping("saveorder")
	public ModelAndView saveOrder(HttpServletRequest request) {
		Orders order = (Orders) request.getSession().getAttribute("orders");
		dao.saveOrder(order);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("userhome.jsp");
		return andView;
	}

	@RequestMapping("/vieworder")
	public ModelAndView getAllOrders() {
		List<Orders> orders = dao.getAllOrders();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("vieworders.jsp");
		mv.addObject("orders", orders);
		return mv;
	}
	
	
	@RequestMapping("/editorder")
	public ModelAndView editOrder(@RequestParam int id) {
		Orders orders=dao.getOrderById(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("order",orders);
		mv.setViewName("editorder.jsp");
		return mv;
	}
	
	
	@RequestMapping("updateorder")
	public ModelAndView updateOrder(@ModelAttribute Orders order) {
		Orders orders =dao.getOrderById(order.getId());
		orders.setStatus(order.getStatus());
		ModelAndView view =new ModelAndView();
		dao.updateOrder(orders);
		view.setViewName("vieworder");
		return view;
		
	}
	
	@RequestMapping("getItems")
	public ModelAndView getItemsByOrder(@RequestParam int id) {
		Orders orders=dao.getOrderById(id);
		List<Item> items=orders.getItems();
		ModelAndView view =new ModelAndView();
		view.addObject("items",items);
		view.setViewName("viewitems.jsp");
		return view;
		
	}
}
