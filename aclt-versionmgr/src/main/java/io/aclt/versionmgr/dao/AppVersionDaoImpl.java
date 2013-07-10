package io.aclt.versionmgr.dao;

import io.aclt.versionmgr.model.AppVersion;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AppVersionDaoImpl implements AppVersionDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void register(final AppVersion appVersion) {
		sessionFactory.getCurrentSession().save(appVersion);

	}

	@Override
	@Transactional(readOnly = true)
	public AppVersion get(final String appName) {

		return (AppVersion) sessionFactory.getCurrentSession().createQuery("from AppVersion a where a.appCode= ? ")
				.setParameter(0, appName).uniqueResult();

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(final AppVersion appVersion) {
		sessionFactory.getCurrentSession().update(appVersion);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<String> getAppkeys() {
		return sessionFactory.getCurrentSession().createCriteria(AppVersion.class)
				.setProjection(Projections.property("appCode")).list();
	}

}
