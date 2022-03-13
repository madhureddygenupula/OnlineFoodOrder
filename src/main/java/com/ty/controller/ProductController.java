package com.ty.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.AdminDao;
import com.ty.dao.ProductDao;
import com.ty.dto.Admin;
import com.ty.dto.Product;

@RestController
public class ProductController {

	ProductDao dao=new ProductDao();

	@RequestMapping(value = "/createproduct")
	public ModelAndView createProduct() {

		ModelAndView view = new ModelAndView();
		view.setViewName("createproduct.jsp");
		view.addObject("product", new Product());
		return view;
	}
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute Product product) {

		AdminDao dao2=new AdminDao();
		Admin admin=dao2.getAdminById(product.getAdminId());
		product.setAdmin(admin);
		dao.saveProduct(product);
		ModelAndView view = new ModelAndView();
		view.setViewName("viewproducts");
		return view;
	}
	
	@RequestMapping("/vieworderproducts")
	public ModelAndView getAllOrderProducts(){
		List<Product> products=dao.getAllProducts();
		ModelAndView mv=new ModelAndView();
		mv.addObject("products",products);
		mv.setViewName("viewproducts.jsp");
		return mv;
	}	
	
	
	
	
	@RequestMapping("/viewproducts")
	public ModelAndView getAllProducts(){
		List<Product> products=dao.getAllProducts();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("displayproduct.jsp");
		mv.addObject("products",products);
		return mv;
	}	
	
	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		AdminDao dao2=new AdminDao();
		Admin admin=dao2.getAdminById(product.getAdminId());
		product.setAdmin(admin);
		dao.updateProduct(product);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewproducts");
		return mv;
	}
	
	@RequestMapping("/editproduct")
	public ModelAndView editProduct(@RequestParam int id) {
		Product product=dao.getProductById(id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("editproduct.jsp");
		mv.addObject("product",product);
		return mv;
	}
	

	
	@RequestMapping("/deleteproduct")
	public ModelAndView deleteProduct(@RequestParam int id) {
		dao.deleteProduct(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewproducts");
		return mv;
	}
	
		
}
