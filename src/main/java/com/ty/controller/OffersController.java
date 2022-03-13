package com.ty.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dao.AdminDao;
import com.ty.dao.OfferDao;
import com.ty.dto.Admin;
import com.ty.dto.Offers;

@Controller
public class OffersController {


OfferDao dao=new OfferDao();
	
	@RequestMapping(value = "/createoffer")
	public ModelAndView createProduct() {
		ModelAndView view = new ModelAndView();
		view.setViewName("createoffer.jsp");
		view.addObject("offer", new Offers());
		return view;
	}

	@RequestMapping("/saveoffer")
	public ModelAndView saveOffer(@ModelAttribute Offers offers) {
		AdminDao dao2=new AdminDao();
		Admin admin=dao2.getAdminById(offers.getAdminId());
		offers.setAdmin(admin);
		dao.saveOffer(offers);
		ModelAndView view = new ModelAndView();
		view.setViewName("message.jsp");
		view.addObject("message"+ offers.getCode() + " is saved");
		return view;
	}
	

	
	@RequestMapping("/viewoffers")
	public ModelAndView getAllOffers(){
		List<Offers> offers=dao.getAllOffers();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("displayoffers.jsp");
		mv.addObject("offers",offers);
		return mv;
	}	
	
	@RequestMapping("/updateoffer")
	public ModelAndView updateOffer(@ModelAttribute Offers offers) {
		AdminDao dao2=new AdminDao();
		Admin admin=dao2.getAdminById(offers.getAdminId());
		offers.setAdmin(admin);
		dao.updateOffer(offers);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("message.jsp");
		mv.addObject("message", "Offer is Updated");
		return mv;
	}
	
	@RequestMapping("/editoffer")
	public ModelAndView editOffer(@RequestParam int id) {
		
		Offers offers=dao.getOfferById(id);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("editoffer.jsp");
		mv.addObject("offers",offers);
		return mv;
		
	}
	
	@RequestMapping("/deleteoffer")
	public ModelAndView deleteoffer(@RequestParam int id) {
		dao.deleteOffer(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("message.jsp");
		mv.addObject("message", "Offer is Deleted");
		return mv;
	}
	

}
