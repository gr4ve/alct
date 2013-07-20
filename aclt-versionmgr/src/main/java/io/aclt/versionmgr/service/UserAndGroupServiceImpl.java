package io.aclt.versionmgr.service;

import io.aclt.versionmgr.dao.GroupDao;
import io.aclt.versionmgr.dao.UserDao;
import io.aclt.versionmgr.model.Group;
import io.aclt.versionmgr.model.User;

public class UserAndGroupServiceImpl implements UserAndGroupService {

	private UserDao userDao;
	private GroupDao groupDao;

	@Override
	public void saveUser(User user) {
		Group group = user.getGroup();
		if (group.getId() == null) {
			groupDao.save(group);
		}
		userDao.save(user);
	}

	@Override
	public void saveGroup(Group group) {
		groupDao.save(group);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void updateGroup(Group group) {
		groupDao.update(group);
	}

	@Override
	public User getUserById(String name) {
		return userDao.getUserById(name);
	}

	@Override
	public Group getGroupByName(String name) {
		return groupDao.getGroupByName(name);
	}

}
