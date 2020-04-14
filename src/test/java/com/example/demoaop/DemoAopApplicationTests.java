package com.example.demoaop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoAopApplicationTests {

	@Autowired
	private DomainService service;

	@Test
	public void testGetDomainObjectById() {
		service.getDomainObjectById(10L);
	}

}
