package com.swashtech.cricket.domain;

public class Score {

	private String stat;
	private String score;
	private String description;
	private boolean matchStarted;
	private String team_1;
	private String team_2;
	private String creditsLeft;
	private String v;
	private int ttl;
	private Provider provider;

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isMatchStarted() {
		return matchStarted;
	}

	public void setMatchStarted(boolean matchStarted) {
		this.matchStarted = matchStarted;
	}

	public String getTeam_1() {
		return team_1;
	}

	public void setTeam_1(String team_1) {
		this.team_1 = team_1;
	}

	public String getTeam_2() {
		return team_2;
	}

	public void setTeam_2(String team_2) {
		this.team_2 = team_2;
	}

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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

}
