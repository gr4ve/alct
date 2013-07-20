package io.aclt.versionmgr.dao;

import io.aclt.versionmgr.model.Group;

public interface GroupDao extends GenericDataOperation<Group> {

	public Group getGroupByName(String name);

}
