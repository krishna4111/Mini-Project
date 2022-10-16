package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookDTO;
import com.example.dto.LibraryDTO;
import com.example.entity.Book;
import com.example.entity.Library;
import com.example.service.BookService;
import com.example.service.LibraryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	@Autowired
	LibraryService lser;

	@Autowired
	BookService bser;

	@RequestMapping(value = "/addLibrary", method = RequestMethod.POST)
	public LibraryDTO addLibrary(@RequestBody LibraryDTO ldto) {
		Library l = new Library();
		l.setLibraryName(ldto.getLibraryName());
		l.setPlace(ldto.getPlace());
		l.setContactNo(ldto.getContactNO());
		Library l1 = lser.insertLibrary(l);
		ldto.setLibraryId(l1.getLibraryId());
		ldto.setCreatedAt(l1.getCreatedAt());
		ldto.setUpdatedAt(l1.getUpdatedAt());
		return ldto;
	}

	@RequestMapping(value = "/addBooks", method = RequestMethod.POST)
	public BookDTO addbook(@RequestBody BookDTO bdto) {
		Book b = new Book();
		b.setBookName(bdto.getBookName());
		b.setAuthorName(bdto.getAuthorName());
		b.setDept(bdto.getDept());
		b.setLibrary(bdto.getLibrary());
		Book b2 = bser.insertBook(b);
		bdto.setBookId(b2.getBookId());
		bdto.setCreatedAt(b2.getCreatedAt());
		bdto.setUpdatedAt(b2.getUpdatedAt());

		return bdto;

	}

	@RequestMapping(value = "/fetchLibrary", method = RequestMethod.POST)
	public LibraryDTO fetchLibrary(@RequestBody String lid) {

		Library l = lser.findLibraryById(new Integer(lid));
		LibraryDTO ldto = new LibraryDTO();
		ldto.setLibraryName(l.getLibraryName());
		ldto.setPlace(l.getPlace());
		ldto.setContactNO(l.getContactNo());
		ldto.setLibraryId(l.getLibraryId());
		ldto.setCreatedAt(l.getCreatedAt());
		ldto.setUpdatedAt(l.getUpdatedAt());
		return ldto;
	}

	/*
	 * @RequestMapping(value = "/addBook", method = RequestMethod.POST) public Book
	 * addBook(@RequestBody Book b) { Library lib
	 * =lser.findLibraryById(b.getLibrary().getLibraryId()); Book b1=new Book();
	 * b1.setBookName(b.getBookName()); b1.setAuthorName(b.getAuthorName());
	 * b1.setDept(b.getDept()); b.setLibrary(lib); Book b2=bser.insertBook(b);
	 * return b2;
	 * 
	 * }
	 */
	@RequestMapping(value = "/fetchBook", method = RequestMethod.POST)
	public BookDTO fetchBook(@RequestBody String bid) {
		Book b = bser.findBookById(new Integer(bid));
		BookDTO bdto = new BookDTO();
		bdto.setBookName(b.getBookName());
		bdto.setAuthorName(b.getAuthorName());
		bdto.setDept(b.getDept());
		bdto.setBookId(b.getBookId());
		bdto.setCreatedAt(b.getCreatedAt());
		bdto.setUpdatedAt(b.getUpdatedAt());
		bdto.setLibraryId(b.getLibrary().getLibraryId());
		return bdto;

	}

	@RequestMapping(value = "/fetchAllBooks", method = RequestMethod.POST)
	public List<Book> fetchAllBooks() {
		List<Book> li = bser.findAll();
		System.out.println("Books fetched successfully");
		return li;
	}

	@RequestMapping(value = "/fetchAllLibrary", method = RequestMethod.GET)
	public List<Library> fetchAllLibrary() {
		System.out.println("Library fetched successfully");
		List<Library> lis = lser.findAll();

		return lis;
	}
	@RequestMapping(value="/updateLibrary" , method=RequestMethod.POST)
	public Library updateLibrary(@RequestBody Library library) {
		return lser.updateLibrary(library);
		
	}

	
	
	
	
	
	
	
}