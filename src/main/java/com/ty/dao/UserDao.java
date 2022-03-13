package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Admin;
import com.ty.dto.User;

public class UserDao {


	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project");
	EntityManager entityManager=entityManagerFactory.createEntityManager();

	public void createUser(User user) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	
	public void editUser(User user) {
		
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
	
	
	public List<User> getAllUsers()
	{
		Query query=entityManager.createQuery("Select u from User u");
		return query.getResultList();
	}
	
    public User validateUser(String email,String password) {
		
    	Query query = entityManager.createQuery("select a from User a where email=?1 and password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		System.out.println(users);
		if (users.size()!=0) {
			System.out.println(users.get(0)+"users si");
			return users.get(0);
		} else {
			return null;
			}
    }
    public User getUserById(int id) {
    	
    	return entityManager.find(User.class, id);
    }
    
    public boolean deleteUser(int id) {
    	
    	User user=entityManager.find(User.class, id);
    	
    if(user !=null) {
    	
    	EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		return true;
    }
    return false;
    }
}
