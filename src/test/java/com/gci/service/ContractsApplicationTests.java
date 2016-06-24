package com.gci.service;

import com.gci.service.contract.ContractsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ContractsApplication.class)
@WebAppConfiguration
public class ContractsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
