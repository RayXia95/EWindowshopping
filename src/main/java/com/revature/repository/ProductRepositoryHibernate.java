package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Product;

@Repository("productRepository")
@Transactional
public class ProductRepositoryHibernate implements ProductRepository {

	private static Logger logger = Logger.getLogger(ProductRepositoryHibernate.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		
		logger.info("====================================================");
		logger.info("Retrieving List of Products");
		logger.info("====================================================");
		
		return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	}

}
