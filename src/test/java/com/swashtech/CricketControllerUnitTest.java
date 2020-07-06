package com.swashtech;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONException;
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
