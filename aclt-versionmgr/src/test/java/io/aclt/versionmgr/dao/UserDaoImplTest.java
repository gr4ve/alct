package io.aclt.versionmgr.dao;

import static org.junit.Assert.*;
import io.aclt.versionmgr.model.Group;
import io.aclt.versionmgr.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/appCtx-vermgr-test.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@ActiveProfiles("dev")
public class UserDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserDao userDao;

	@Autowired
	private GroupDao groupDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Test
	public void testSaveUser() {
		Group group = new Group();
		group.setName("Team1");
		groupDao.save(group);
		User user = new User();
		user.setName("abc");
		user.setGroup(group);
		userDao.save(user);
	}

	@Test
	public void testUpdateUser() {

		Group group = new Group();
		group.setName("Team1");
		groupDao.save(group);
		User user = new User();
		user.setName("abc");
		user.setGroup(group);
		userDao.save(user);

		User user1 = userDao.getUserById("abc");
		assertEquals(user.getName(), user1.getName());
		user1.setName("hig");
		userDao.update(user1);
		User user2 = userDao.getUserById("hig");
		assertEquals(user1.getName(), user2.getName());
	}

	@Test
	public void testGetUserById() {
		fail("Not yet implemented");
	}

}
