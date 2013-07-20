package io.aclt.versionmgr.dao;

import io.aclt.versionmgr.model.Group;

public class GroupDaoImpl extends AbstractHibernateDao<Group> implements GroupDao {

	@Override
	public Group getGroupByName(String name) {
		return (Group) sessionFactory.getCurrentSession().createQuery("from Group g where g.name = ?")
				.setParameter(0, name).uniqueResult();
	}

}
