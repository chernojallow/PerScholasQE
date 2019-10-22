package com.perscholas.junit.sba6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private Integer userId;
	private String name;
	private String password;
	private Double javaScore;
	private Double sqlScore;

	public User() {
	}

	public User(Integer userId, String name, String password, Double javaScore, Double sqlScore) throws InvalidPasswordException {
		this.setUserId(userId);
		this.setName(name);
		this.setPassword(password);
		this.setJavaScore(javaScore);
		this.setSqlScore(sqlScore);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Pattern p = Pattern.compile("^[a-zA-Z]+$");
		Matcher m = p.matcher(name);
		if (m.matches()) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Please enter a valid name (must include only alpha characters).");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws InvalidPasswordException {
		if (password.length() < 8 || password.length() > 25) {
			throw new InvalidPasswordException("Password must be at least 8 " + "and no more than 25 characters");
		}
		this.password = password;
	}

	public Double getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(Double javaScore) {
		if (javaScore < 0 || javaScore > 100) {
			throw new IllegalArgumentException("Java Score must be between 0 and 100");
		}
		this.javaScore = javaScore;
	}

	public Double getSqlScore() {
		return sqlScore;
	}

	public void setSqlScore(Double sqlScore) {
		if (sqlScore < 0 || sqlScore > 100) {
			throw new IllegalArgumentException("SQL Score must be between 0 and 100");
		}
		this.sqlScore = sqlScore;
	}

	public Integer calculateCredits() {
		Integer credits = 0;
		if (this.javaScore >= 70) {
			credits++;
		}
		if (this.sqlScore >= 70) {
			credits++;
		}
		return credits;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", javaScore=" + javaScore
				+ ", sqlScore=" + sqlScore + "]";
	}
}
