package com.swashtech;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.swashtech.controller.HelloController;

public class HelloControllerUnitTest {

	private HelloController helloController;

	@Before
	public void setUp() throws Exception {
		helloController = new HelloController();
	}

	@Test
	public void sayHello() {
		helloController.sayHello();
		assertTrue(true);
	}

}
