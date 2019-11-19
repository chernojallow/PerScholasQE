package com.perscholas.hibernate_validation_dao.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Book {
	@Id
	@GeneratedValue
	private Integer bookId;
	
	@Size(min=2, max=50,  message="Title must be between 2 and 50 characters long.")
	@NotBlank(message="Title is required.")
	private String title;
	
	@Size(min=2, max=50,  message="Author name must be between 2 and 50 characters long.")
	@NotBlank(message="Author name is required.")
	private String author;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
