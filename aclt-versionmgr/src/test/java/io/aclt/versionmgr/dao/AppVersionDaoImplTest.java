package io.aclt.versionmgr.dao;

import static org.junit.Assert.assertEquals;
import io.aclt.versionmgr.model.AppVersion;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/appCtx-vermgr-test.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@ActiveProfiles("dev")
public class AppVersionDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private AppVersionDao appVersionDao;

	public void setAppVersionDao(AppVersionDao appVersionDao) {
		this.appVersionDao = appVersionDao;
	}

	@Test
	@Rollback(true)
	public void testRegister() {
		AppVersion appVersion = new AppVersion();
		appVersion.setAppCode("WFS");
		appVersion.setMajorVersion("1.0");
		appVersion.setMinorVersion(1);
		appVersionDao.register(appVersion);
		AppVersion appVersion1 = appVersionDao.get("WFS");
		System.out.println(">>>>>>>>>>>>" + appVersion.getId());
		assertEquals(appVersion.getMajorVersion(), appVersion1.getMajorVersion());
	}

	@Test
	@Rollback(true)
	public void testGet() {
		AppVersion appVersion = new AppVersion();
		appVersion.setAppCode("WFS");
		appVersion.setMajorVersion("1.0");
		appVersion.setMinorVersion(1);
		appVersionDao.register(appVersion);
		AppVersion appVersion1 = appVersionDao.get("WFS");
		System.out.println(">>>>>>>>>>>>" + appVersion.getId());
		assertEquals(appVersion.getMajorVersion(), appVersion1.getMajorVersion());
		// fail("Not yet implemented");
	}

	@Test
	@Rollback(true)
	public void testUpdate() {

		AppVersion appVersion = new AppVersion();
		appVersion.setAppCode("WFS");
		appVersion.setMajorVersion("1.0");
		appVersion.setMinorVersion(1);
		appVersionDao.register(appVersion);
		AppVersion appVersion1 = appVersionDao.get("WFS");
		appVersion1.increment();
		appVersionDao.update(appVersion1);
		AppVersion appVersion2 = appVersionDao.get("WFS");
		assertEquals(appVersion1.getMinorVersion(), appVersion2.getMinorVersion());

	}

	@Test
	public void testGetAppkeys() {
		AppVersion appVersion = new AppVersion();
		appVersion.setAppCode("WFS");
		appVersion.setMajorVersion("1.0");
		appVersion.setMinorVersion(1);
		appVersionDao.register(appVersion);
		List<String> keys = appVersionDao.getAppkeys();
		assertEquals(1, keys.size());
	}

}
