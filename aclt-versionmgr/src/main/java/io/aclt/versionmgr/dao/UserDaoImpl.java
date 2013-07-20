package io.aclt.versionmgr.dao;

import io.aclt.versionmgr.model.User;

public class UserDaoImpl extends AbstractHibernateDao<User> implements UserDao {

	@Override
	public User getUserById(String eId) {
		return (User) currentSession().createQuery("from User u where u.name = ?").setParameter(0, eId).uniqueResult();
	}

}
