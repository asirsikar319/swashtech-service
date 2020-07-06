package com.swashtech;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.swashtech.config.SwaggerConfig;

public class SwaggerConfigUnitTest {

	private SwaggerConfig swaggerConfig;

	@Before
	public void setUp() throws Exception {
		swaggerConfig = new SwaggerConfig();
	}

	@Test
	public void test() {
		swaggerConfig.postsApi();
		assertTrue(true);
	}

}
