package com.perscholas.book_club_exercise.models;

import java.sql.Date;

public class Book {
	private Integer bookID;
	private String title;
	private String synopsis;
	private String author;
	private Date pDate;
	private Integer memberID;

	public Book() {
		this.bookID = null;
		this.title = null;
		this.synopsis = null;
		this.author = null;
		this.pDate = null;
		this.memberID = null;
	}

	public Book(Integer bookID, String title, String synopsis, String author, Date pDate, Integer memberID) {
		this.bookID = bookID;
		this.title = title;
		this.synopsis = synopsis;
		this.author = author;
		this.pDate = pDate;
		this.memberID = memberID;
	}

	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", synopsis=" + synopsis + ", author=" + author
				+ ", pDate=" + pDate + ", memberID=" + memberID + "]";
	}
}
