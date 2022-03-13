package com.ty.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.ProductDao;
import com.ty.dao.UserDao;
import com.ty.dto.Item;
import com.ty.dto.Orders;
import com.ty.dto.Product;
import com.ty.dto.User;
import com.ty.service.ProductService;



@Controller
public class ItemController {

	
	@RequestMapping("/addproduct")
	public ModelAndView addProduct(@RequestParam int id) {
		Product product=new ProductDao().getProductById(id);	
		Item item=new Item();
		item.setName(product.getName());
		item.setCost(product.getCost());
		System.out.println(id);
		ModelAndView view = new ModelAndView();
		view.addObject("item",item);
		view.setViewName("quantity.jsp");
		return view;
	}
	
	@RequestMapping("placeOrder")
	public ModelAndView placeOrder(HttpServletRequest request,Item item) {
		HttpSession httpSession=request.getSession();
		Object object=httpSession.getAttribute("myItems");
		System.out.println(object);
		if(object==null) {
			ArrayList<Item> items=new ArrayList<Item>();
			items.add(item);
			httpSession.setAttribute("myItems", items);
		}else {
			ArrayList<Item> items=(ArrayList<Item>) httpSession.getAttribute("myItems");
			items.add(item);
			httpSession.setAttribute("myItems", items);
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("vieworderproducts");
		return mv;
	}
	
	@RequestMapping("cartproducts")
	public ModelAndView cartProducts(HttpServletRequest request) {
		HttpSession httpSession=request.getSession();
		List<Item> items=(List<Item>) httpSession.getAttribute("myItems");
		System.out.println(items +"cartProducts");
		ModelAndView mv=new ModelAndView();
		mv.addObject("myItems",items);
		mv.setViewName("viewcart.jsp");
		return mv;
	}
	
	
	@RequestMapping("availoffer")
	public ModelAndView availOffer(HttpServletRequest request) {
		HttpSession httpSession=request.getSession();
		int id=(int) httpSession.getAttribute("id");
		
		User user=new UserDao().getUserById(id);
		
		ProductService productService=new ProductService();
		
		List<Item> items=(List<Item>) httpSession.getAttribute("myItems");
		System.out.println(items);
		Orders orders =productService.createOrder(items, user,request.getParameter("code"));
		
		httpSession.setAttribute("orders", orders);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("createcustomer");
		return mv;
	
	}	
	
		
	}
	
	