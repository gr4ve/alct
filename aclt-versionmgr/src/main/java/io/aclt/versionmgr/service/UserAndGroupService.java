package io.aclt.versionmgr.service;

import io.aclt.versionmgr.model.Group;
import io.aclt.versionmgr.model.User;

public interface UserAndGroupService {

	public void saveUser(User user);

	public void saveGroup(Group group);

	public void updateUser(User user);

	public void updateGroup(Group group);

	public User getUserById(String name);

	public Group getGroupByName(String name);

}
