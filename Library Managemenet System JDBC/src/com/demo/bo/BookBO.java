package com.demo.bo;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.BookDAO;
import com.demo.exception.BookManagementException;
import com.demo.exception.BookNotFoundException;
import com.demo.vo.BookVO;

public class BookBO {
	BookDAO dao = new BookDAO();
	BookVO vo = new BookVO();
	List<BookVO> list = new ArrayList<>();

	public boolean insertBook(BookVO vo) throws BookManagementException {
		boolean flag = false;
		try {
			flag = dao.addBook(vo);
		} catch (BookManagementException e) {
			throw new BookManagementException("Error When Adding This Book");
		}
		return flag;
	}

	public BookVO fetchBook(int BookId) throws BookNotFoundException {
		try {
			vo = dao.fetchBook(BookId);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException(e.getMessage());
		}
		return vo;

	}

	public List<BookVO> fetchAllBook() throws BookNotFoundException {
		try {
			list = dao.fetchAllBook();
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("Error");
		}
		return list;
	}

	public boolean updateBook(BookVO vo) throws BookManagementException {
		boolean flag = false;
		
		try {
			flag = dao.updateBook(vo);
		} catch (BookManagementException e) {
			throw new BookManagementException("update book detaile fails");
		}
		return flag;
	}
	public boolean deleteRecord(int BookId) throws BookManagementException{
		boolean flag;
		try {
			flag=dao.deleteRecord(BookId);
		}
		catch(BookManagementException e) {
			throw new BookManagementException("Book id is not fount");
		}
		return flag;
	}

}
