package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Customer;

public class CustomerDao {
	
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project");
	EntityManager entityManager=entityManagerFactory.createEntityManager();



	public void saveCustomer(Customer customer) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
	}
	
	public Customer getCustomerById(int id)
	{
		return entityManager.find(Customer.class,id);
	}
	
	public void updateCustomer(Customer customer) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
	}
	public boolean deleteCustomer(int id) {

		Customer customer=entityManager.find(Customer.class, id);
		if(customer !=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		 entityManager.remove(customer);
		 entityTransaction.commit();
		 return true;
		 }
		else
			return false;
	}
	
	public List<Customer> getAllCustomer() {
	Query query =entityManager.createQuery("select i from Customer i");
	 return 
			 query.getResultList();
	}



}
