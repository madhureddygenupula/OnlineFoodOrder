package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Product;

public class ProductDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project");
	EntityManager entityManager=entityManagerFactory.createEntityManager();

	
	public void saveProduct(Product product) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
	}
	
	public Product getProductById(int id)
	{
		return entityManager.find(Product.class,id);
	}
	
	public void updateProduct(Product product) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(product);
		entityTransaction.commit();
	}
	public boolean deleteProduct(int id) {

		Product product=entityManager.find(Product.class, id);
		if(product !=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		 entityManager.remove(product);
		 entityTransaction.commit();
		 return true;
		 }
		else
			return false;
	}
	
	public List<Product> getAllProducts() {
	Query query =entityManager.createQuery("select p from Product p");
	 return 
			 query.getResultList();
	}
}
