package com.revature.repository;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Selling;
@Transactional
@Repository("sellingRepository")
public class SellingRepositoryHibernate implements SellingRepository {
	private static Logger logger= Logger.getLogger(SellingRepositoryHibernate.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Selling selling) {
		sessionFactory.getCurrentSession().save(selling);

	}

	@Override
	public void update(Selling selling) {
		sessionFactory.getCurrentSession().saveOrUpdate(selling);
		
	}

}
