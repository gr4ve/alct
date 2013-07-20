package io.aclt.versionmgr.dao;

import org.hibernate.SessionFactory;

import io.aclt.versionmgr.model.Group;
import io.aclt.versionmgr.model.User;

public class UserAndGroupDaoImpl implements UserAndGroupDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveUser(User user) {

		sessionFactory.getCurrentSession().save(user);

	}

	@Override
	public void saveGroup(Group group) {
		sessionFactory.getCurrentSession().save(group);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);

	}

	@Override
	public void updateGroup(Group group) {
		sessionFactory.getCurrentSession().update(group);
	}

	@Override
	public User getUserById(String eId) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.eId = ?")
				.setParameter(0, eId).uniqueResult();
	}

	@Override
	public Group getGroupByName(String name) {
		return (Group) sessionFactory.getCurrentSession().createQuery("from Group g where g.name = ?")
				.setParameter(0, name).uniqueResult();
	}

}
