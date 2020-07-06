package com.swashtech.cricket.domain;

public class Matches {

	private int unique_id;
	private String toss_winner_team;
	private String dateTimeGMT;
	private String winner_team;
	private String type;
	private String date;
	private boolean squad;
	private String team_1;
	private String team_2;
	private boolean matchStarted;

	public int getUnique_id() {
		return unique_id;
	}

	public void setUnique_id(int unique_id) {
		this.unique_id = unique_id;
	}

	public String getToss_winner_team() {
		return toss_winner_team;
	}

	public void setToss_winner_team(String toss_winner_team) {
		this.toss_winner_team = toss_winner_team;
	}

	public String getDateTimeGMT() {
		return dateTimeGMT;
	}

	public void setDateTimeGMT(String dateTimeGMT) {
		this.dateTimeGMT = dateTimeGMT;
	}

	public String getWinner_team() {
		return winner_team;
	}

	public void setWinner_team(String winner_team) {
		this.winner_team = winner_team;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isSquad() {
		return squad;
	}

	public void setSquad(boolean squad) {
		this.squad = squad;
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

	public boolean isMatchStarted() {
		return matchStarted;
	}

	public void setMatchStarted(boolean matchStarted) {
		this.matchStarted = matchStarted;
	}

}
