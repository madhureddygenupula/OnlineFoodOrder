package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Admin;
import com.ty.dto.Orders;

public class AdminDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("project");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Admin validateAdmin(String email, String password) {

		Query query = entityManager.createQuery("select a from Admin a where email=?1 and password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Admin> admins = query.getResultList();
		if (admins.size()!=0) {
			return admins.get(0);
		} else
			return null;

	}

	public Admin getAdminById(int id) {
		return entityManager.find(Admin.class, id);
	}

	public void createAdmin(Admin admin)

	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
	}
}
