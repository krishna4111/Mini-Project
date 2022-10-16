package com.demo.service;

import java.util.List;

import com.demo.bo.BookBO;
import com.demo.exception.BookManagementException;
import com.demo.exception.BookNotFoundException;
import com.demo.response.ResponseObject;
import com.demo.vo.BookVO;

public class BookService {
	BookBO bo = new BookBO();
	ResponseObject obj = new ResponseObject();

	public ResponseObject saveBook(BookVO vo) throws BookManagementException {
		boolean flag;
		try {
			flag = bo.insertBook(vo);
			obj.setSuccessMessage("Book Added Successfully");
		} catch (BookManagementException e) {
			obj.setFailureMessage("Error When Adding This Book " + e);
		}
		return obj;
	}

	public ResponseObject fetchBook(int BookId) throws BookNotFoundException {
		try {
			BookVO vo;
			vo = bo.fetchBook(BookId);
			if (vo.getBookId() > 0) {
				obj.setBookdetailsvo(vo);
			} else {
				throw new BookNotFoundException("fetching BookId is not exsist in database");
			}
		} catch (BookNotFoundException e) {
			obj.setFailureMessage(e.getMessage());
		}
		return obj;
	}

	public ResponseObject fetchAllBooks() throws BookNotFoundException {
		
		try {
			List<BookVO> list;
			list = bo.fetchAllBook();
			
			
			obj.setBooklist(list);

		} catch (BookNotFoundException e) {
			obj.setFailureMessage("list of books not exist in database");

		}
		return obj;
	}

	public ResponseObject updateBook(BookVO vo) throws BookManagementException {
		boolean flag = bo.updateBook(vo);
		try {
			if (flag != false) {

				obj.setSuccessMessage("Book details updated successfully");
			} else {
				throw new BookManagementException("Book Detail update is fails");
			}
		} catch (BookManagementException e) {
			obj.setFailureMessage(e.getMessage() + "Book details update fails");
		}
		return obj;

	}
	public ResponseObject deleteRecord(int BookId) throws BookManagementException{
		boolean flag;
		try {
			flag=bo.deleteRecord(BookId);
			
			if(flag!=false) {
				obj.setSuccessMessage("Record Deleted Successfully!!..");
			}
			else {
				throw new BookManagementException("Book id is not founded");
			}
		}
		catch(BookManagementException e) {
			obj.setFailureMessage("Book id is not founded");
		}
		return obj;
	}
}
