package io.aclt.tools.log.download.service;

import io.aclt.tools.log.download.model.DownloadRequest;
import io.aclt.tools.log.download.model.ScheduledProfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DownloadServiceImpl implements DownloadService {

	@Autowired
	private ScheduledProfileService scheduledProfileService;

	public void setScheduledProfileService(ScheduledProfileService scheduledProfileService) {
		this.scheduledProfileService = scheduledProfileService;
	}

	@Override
	public void download() {

		List<ScheduledProfile> scheduledProfiles = scheduledProfileService.loadActivedScheduledProfiles();
		for (ScheduledProfile profile : scheduledProfiles) {

		}

	}

	private DownloadRequest createRequestByProfile(ScheduledProfile profile) {

		DownloadRequest request = new DownloadRequest();
		request.setAppCode(profile.getAppCode());
		request.setContext(profile.getContext());
		return request;

	}

}
