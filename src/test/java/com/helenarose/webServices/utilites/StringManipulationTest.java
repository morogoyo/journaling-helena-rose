package com.helenarose.webServices.utilites;

import com.helenarose.webServices.model.Users;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringRunner.class)
@SpringBootTest
class StringManipulationTest {

	Logger LOOGER = LoggerFactory.getLogger(StringManipulationTest.class);

	Users user;

	@BeforeEach
	public void init() {
		user = new Users();

		user.setFname("Ilene");
		user.setLname("Torres");
		user.setGender("f");
		user.setStreetAddress("807 Sterling Spring Rd");
		user.setState("Florida");
		user.setZipcode(32828);
		user.setCity("Orlando");

	}

	@Test
	void testingGenericMethod() throws JsonProcessingException {

		String test1 = user.getFname() != null ? "Ilene" : "null";
		LOOGER.info(test1);
		Object test = StringManipulation.lowerCase(user);
		LOOGER.info(test.toString());
		Assert.assertEquals("Ilene", test1);
	}

}
