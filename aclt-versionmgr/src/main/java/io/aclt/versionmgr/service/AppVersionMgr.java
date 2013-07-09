package io.aclt.versionmgr.service;

import io.aclt.versionmgr.model.AppVersion;


public interface AppVersionMgr {

	public AppVersion getNextVersion(String appId);

	public void register(AppVersion appVersion);

	public void updateMajorVersion(String appId, String majorVersion);

}
