package io.aclt.versionmgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VERSIONS")
public class AppVersion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "APPVERSION_SEQ", allocationSize = 0)
	@Column(name = "ID")
	private Long id;

	@Column(name = "APP_CODE")
	private String appCode;

	// private Scope scope;
	@Column(name = "MAJOR_VERSION")
	private String majorVersion;

	@Column(name = "MINOR_VERSION")
	private int minorVersion = 0;

	public AppVersion() {
	}

	public AppVersion(String appCode, String majorVersion) {
		this.appCode = appCode;
		this.majorVersion = majorVersion;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppVersion increment() {
		this.minorVersion += 1;
		return this;
	}

}
