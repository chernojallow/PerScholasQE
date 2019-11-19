package com.perscholas.hibernate_validation_dao.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.hibernate_validation_dao.dao.BookDAO;
import com.perscholas.hibernate_validation_dao.models.Book;

@Controller
public class BookController {
	
	@Autowired
	BookDAO b_dao;
	
	@GetMapping("/")
	public String showBooks(Model model) throws SQLException {
		List<Book> allBooks = b_dao.getAllBooks();
		model.addAttribute("allBooks", allBooks);
		model.addAttribute("book", new Book());
		return "Books";
	}
	
	@PostMapping("/addBook")
	public String addBook(@Valid @ModelAttribute("book") Book book, 
			BindingResult result, Model model) 
					throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			List<Book> allBooks = b_dao.getAllBooks();
			model.addAttribute("allBooks", allBooks);
			return "Books";
		}
		
		Integer bookId = b_dao.addBook(book);

		if (bookId == -1) {
			List<Book> allBooks = b_dao.getAllBooks();
			model.addAttribute("allBooks", allBooks);
			model.addAttribute("errorMessage", "Add book failed.");
			return "Books";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/removeBook/{bookId}")
	public String removeBook(@PathVariable Integer bookId) 
			throws IOException, SQLException {
		Boolean b = b_dao.removeBook(bookId);
		System.out.println(b);
		return "forward:/";
	}
}