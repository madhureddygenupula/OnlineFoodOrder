package com.ty.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import com.ty.dto.Item;
import com.ty.dto.Orders;

public class OrderService {

	public void orderBill(Orders orders) throws FileNotFoundException {
		FileOutputStream fileOutputStream=new FileOutputStream("D:\\abc.txt");
		PrintWriter writer=new PrintWriter(fileOutputStream);
		writer.println("Order For "+orders.getCustomername());
		writer.println("Order By "+orders.getUsername());
		writer.println("Order DateTime "+orders.getDateTime());
		writer.println();
		writer.println();
		writer.println("*******************************************************************");
		writer.println();
		writer.println("Item Name                                 Item Cost");
		writer.println();
		writer.println("*******************************************************************");
		for(Item item:orders.getItems()) {
			writer.println(item.getName()+"                                 "+item.getCost());
			writer.println();
		}

		writer.println();
		writer.println("Order Offer Cost: "+orders.getOffercost());
		writer.println("Order Total Cost(including tax/ offer if exists): "+orders.getTotalcost());
		writer.println("*******************************************************************");
		writer.flush();
	}
	
}
