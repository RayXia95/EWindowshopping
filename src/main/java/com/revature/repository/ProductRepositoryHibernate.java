package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Selling;

@Transactional
@Repository("productRepository")
public class ProductRepositoryHibernate implements ProductRepository {

	private static Logger logger = Logger.getLogger(ProductRepositoryHibernate.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Selling> findAll() {
		logger.trace("===================================================================================================");
		logger.trace("===================================In DAO==========================================================");
		logger.trace("===================================================================================================");
		//logger.trace(sessionFactory.getCurrentSession().createCriteria(Product.class).list() + "=========================");
		return sessionFactory.getCurrentSession().createCriteria(Selling.class).list();
		
	}
	
}
