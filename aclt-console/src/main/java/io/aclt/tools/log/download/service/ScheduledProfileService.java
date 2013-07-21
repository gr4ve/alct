package io.aclt.tools.log.download.service;

import io.aclt.tools.log.download.model.ScheduledProfile;

import java.util.List;

public interface ScheduledProfileService {
	

	public List<ScheduledProfile> loadActivedScheduledProfiles();

}
