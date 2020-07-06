package com.swashtech.cricket.domain;

import java.util.List;

public class Cricket {

	private String creditsLeft;
	private String v;
	private int ttl;
	private List<Matches> matches;
	private Provider provider;

	public String getCreditsLeft() {
		return creditsLeft;
	}

	public void setCreditsLeft(String creditsLeft) {
		this.creditsLeft = creditsLeft;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	public List<Matches> getMatches() {
		return matches;
	}

	public void setMatches(List<Matches> matches) {
		this.matches = matches;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

}
