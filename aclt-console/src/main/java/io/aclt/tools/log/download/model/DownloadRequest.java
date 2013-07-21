package io.aclt.tools.log.download.model;

public class DownloadRequest {

	private String appCode;
	private String environment;

	private String context;

	private String date;

	private Integer fromTime;
	private Integer toTime;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getFromTime() {
		return fromTime;
	}

	public void setFromTime(Integer fromTime) {
		this.fromTime = fromTime;
	}

	public Integer getToTime() {
		return toTime;
	}

	public void setToTime(Integer toTime) {
		this.toTime = toTime;
	}

}
