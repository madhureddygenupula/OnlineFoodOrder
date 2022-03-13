package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Offers;


public class OfferDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project");
	EntityManager entityManager=entityManagerFactory.createEntityManager();


	public void saveOffer(Offers offers) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(offers);
		entityTransaction.commit();
	}
	
	public Offers getOfferById(int id)
	{
		return entityManager.find(Offers.class,id);
	}
	
	public void updateOffer(Offers offers) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(offers);
		entityTransaction.commit();
	}
	public boolean deleteOffer(int id) {

		Offers item=entityManager.find(Offers.class, id);
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
	
	public List<Offers> getAllOffers() {
	Query query =entityManager.createQuery("select i from Offers i");
	 return 
			 query.getResultList();
	}


}
