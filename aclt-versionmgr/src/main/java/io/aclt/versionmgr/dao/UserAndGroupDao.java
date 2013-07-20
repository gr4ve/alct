package io.aclt.versionmgr.dao;

import io.aclt.versionmgr.model.Group;
import io.aclt.versionmgr.model.User;

public interface UserAndGroupDao {

	void saveUser(User user);

	void saveGroup(Group group);

	void updateUser(User user);

	void updateGroup(Group group);

	public User getUserById(String eId);

	public Group getGroupByName(String name);

}
