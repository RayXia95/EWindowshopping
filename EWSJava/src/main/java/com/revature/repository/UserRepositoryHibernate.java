package com.revature.repository;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Transactional
@Repository("userRepository")
public class UserRepositoryHibernate implements UserRepository{

	private static Logger logger = Logger.getLogger(UserRepositoryHibernate.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserRepositoryHibernate() { }
	
	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public User select(String username) {
		try {
			return (User) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.like("username", username).ignoreCase()).list().get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
}
