package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Item;

public class ItemDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project");
	EntityManager entityManager=entityManagerFactory.createEntityManager();


	public void saveItem(Item item) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
	}
	
	public Item getItemById(int id)
	{
		return entityManager.find(Item.class,id);
	}
	
	public void updateItem(Item item) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
	}
	public boolean deleteItem(int id) {

		Item item=entityManager.find(Item.class, id);
		if(item !=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		 entityManager.remove(item);
		 entityTransaction.commit();
		 return true;
		 }
		else
			return false;
	}
	
	public List<Item> getAllItem() {
	Query query =entityManager.createQuery("select i from Item i");
	 return 
			 query.getResultList();
	}

	
}
