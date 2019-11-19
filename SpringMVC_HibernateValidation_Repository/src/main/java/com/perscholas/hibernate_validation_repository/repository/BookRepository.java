package com.perscholas.hibernate_validation_repository.repository;

import java.util.List;

import com.perscholas.hibernate_validation_repository.models.Book;

public interface BookRepository {
	List<Book> showBooks();
	Integer addBook(Book book);
	Boolean removeBook(Integer bookId);
}
