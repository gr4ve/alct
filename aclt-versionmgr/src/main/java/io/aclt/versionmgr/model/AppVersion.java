package io.aclt.versionmgr.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "APPLICATION_VERSIONS")
public class AppVersion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "APPVERSION_SEQ", allocationSize = 0)
	@Column(name = "ID")
	private Long id;

	@Basic
	@Column(name = "APP_CODE")
	private String appCode;

	// private Scope scope;
	@Basic
	@Column(name = "MAJOR_VERSION")
	private String majorVersion;

	@Basic
	@Column(name = "MINOR_VERSION")
	private Integer minorVersion = 0;

	@Version
	@Column(name = "OPT_LOCK")
	private Integer version;

	public AppVersion() {
	}

	public AppVersion(String appCode, String majorVersion) {
		this.appCode = appCode;
		this.majorVersion = majorVersion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(Integer minorVersion) {
		this.minorVersion = minorVersion;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public AppVersion increment() {
		this.minorVersion += 1;
		return this;
	}

}
