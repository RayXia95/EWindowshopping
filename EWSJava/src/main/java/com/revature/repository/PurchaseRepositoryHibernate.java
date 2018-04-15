package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Purchase;
@Transactional
@Repository("purchaseRepository")
public class PurchaseRepositoryHibernate implements PurchaseRepository {
	private static Logger logger= Logger.getLogger(PurchaseRepositoryHibernate.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Purchase purchase) {
		System.out.println("TESTING TESTING TESTING");
		sessionFactory.getCurrentSession().save(purchase);
	}

	@Override
	public List<Purchase> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Purchase.class).list();
	}

}
