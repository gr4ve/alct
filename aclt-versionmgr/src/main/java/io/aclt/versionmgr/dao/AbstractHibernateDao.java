package io.aclt.versionmgr.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractHibernateDao<T> {

	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T object) {
		currentSession().save(object);
	}

	public void update(T object) {
		currentSession().update(object);
	}

}
