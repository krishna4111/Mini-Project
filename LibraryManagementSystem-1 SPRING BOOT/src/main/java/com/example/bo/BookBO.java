package com.example.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.BookRepository;
import com.example.entity.Book;

@Component
public class BookBO {
	@Autowired
	BookRepository brep = null;

	public Book addBook(Book book) {
		return brep.save(book);
	}

	public Book fetchById(Integer bid) {
		Optional<Book> book = brep.findById(bid);
		return (book.get());
	}

	public List<Book> fetchAllBook() {
		return brep.findAll();
	}
	
}
