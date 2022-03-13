package com.ty.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ty.dao.CustomerDao;
import com.ty.dao.OfferDao;
import com.ty.dto.Item;
import com.ty.dto.Offers;
import com.ty.dto.Orders;
import com.ty.dto.User;

@Service
public class ProductService {

	public Orders createOrder(List<Item> items, User user,String code) {
		Orders orders = new Orders();
		orders.setDateTime(LocalDateTime.now());
		orders.setStatus("Active");
		orders.setUsers(user);
		orders.setUsername(user.getName());
		double total=totalCost(items);
		orders.setUsers(user);
		orders.setItems(items);
		orders.setUsername(user.getName());
		if(offer(code)) {
			orders.setOffercost((20.0/100.0)*total);
		}
		orders.setTotalcost(total-orders.getOffercost());
		return orders;
	}

	public double totalCost(List<Item> items) {
		double total = 0;
		for (Item item : items) {
			item.setCost((item.getCost())*(item.getQuantity()));
			total = total+item.getCost();
		}
		return total + tax(total);
	}

	public double tax(double cost) {

		return ((3.0 / 100.0) * cost);
	}
	
	public boolean offer(String code) {
		
		OfferDao  dao=new OfferDao();
		List<Offers> offers=dao.getAllOffers();
		if(offers!=null) {
			for(Offers offer:offers) {
				if((offer.getCode()).equals(code)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
