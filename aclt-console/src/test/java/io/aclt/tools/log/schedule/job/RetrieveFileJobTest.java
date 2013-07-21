package io.aclt.tools.log.schedule.job;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/appCtx-console-test.xml")
@ActiveProfiles("dev")
public class RetrieveFileJobTest extends AbstractJUnit4SpringContextTests {

	@Test
	public void testJob() throws Exception {
		Thread.sleep(50000);
	}

}
