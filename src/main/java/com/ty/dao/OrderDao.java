package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Orders;

public class OrderDao {

	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project");
	EntityManager entityManager=entityManagerFactory.createEntityManager();



	public void saveOrder(Orders orders) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(orders);
		entityTransaction.commit();
	}
	
	public Orders getOrderById(int id)
	{
		return entityManager.find(Orders.class,id);
	}
	
	public void updateOrder(Orders orders) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(orders);
		entityTransaction.commit();
	}
	public boolean deleteOrder(int id) {

		Orders orders=entityManager.find(Orders.class, id);
		if(orders !=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		 entityManager.remove(orders);
		 entityTransaction.commit();
		 return true;
		 }
		else
			return false;
	}
	
	public List<Orders> getAllOrders() {
	Query query =entityManager.createQuery("select i from Orders i");
	 return 
			 query.getResultList();
	}



	
}
