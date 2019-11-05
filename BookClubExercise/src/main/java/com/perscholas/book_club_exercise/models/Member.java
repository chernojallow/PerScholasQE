package com.perscholas.book_club_exercise.models;

public class Member {
	private Integer memberID;
	private String name;
	private String email;
	private String password;
	private String fGenre;

	public Member() {
		this.memberID = null;
		this.name = null;
		this.email = null;
		this.password = null;
		this.fGenre = null;
	}

	public Member(Integer memberID, String name, String email, String password, String fGenre) {
		this.memberID = memberID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.fGenre = fGenre;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfGenre() {
		return fGenre;
	}

	public void setfGenre(String fGenre) {
		this.fGenre = fGenre;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", fGenre=" + fGenre + "]";
	}
}
