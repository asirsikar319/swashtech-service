package com.swashtech;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.swashtech.controller.CricketController;

public class CricketControllerUnitTest {

	private CricketController cricketController;

	@Before
	public void setUp() throws Exception {
		cricketController = new CricketController();
	}

	@Test
	public void list() throws Exception {
//		cricketController.newmatches();
		assertTrue(true);
	}

}
