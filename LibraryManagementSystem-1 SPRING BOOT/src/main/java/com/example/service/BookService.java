package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bo.BookBO;
import com.example.entity.Book;

@Component
public class BookService {
	@Autowired
	BookBO bo = null;

	public Book insertBook(Book boo) {
		return bo.addBook(boo);
	}

	public Book findBookById(Integer bid) {
		return bo.fetchById(bid);
	}

	public List<Book> findAll() {
		return bo.fetchAllBook();
	}

}
