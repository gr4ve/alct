package io.aclt.versionmgr.dao;

import io.aclt.versionmgr.model.User;

public interface UserDao extends GenericDataOperation<User> {

	public User getUserById(String eId);

}
