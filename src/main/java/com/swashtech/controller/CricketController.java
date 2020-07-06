package com.swashtech.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/swashtech/cricket")
public class CricketController {

	@ApiOperation(value = "View a list of new matches", response = Iterable.class)
	@RequestMapping(value = "/newmatches", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> newmatches() throws IOException, JSONException {
//		String json = readJsonFromUrl("https://cricapi.com/api/matches/BAyxFsI0UbN5nMPSIkROowYDMZM2").toString();
		String json = readJsonFromUrl2("https://cricscore-api.appspot.com/csa").toString();
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@ApiOperation(value = "View match score", response = Iterable.class)
	@RequestMapping(value = "/cricketscore/{unique_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> cricketscore(@PathVariable int unique_id) throws IOException, JSONException {
		String json = readJsonFromUrl2("https://cricscore-api.appspot.com/csa?id="+unique_id).getJSONObject(0).toString();
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	
	public static JSONArray readJsonFromUrl2(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

}
