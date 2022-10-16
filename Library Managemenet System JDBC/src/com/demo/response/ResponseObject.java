package com.demo.response;

import java.util.List;

import com.demo.vo.BookVO;

public class ResponseObject {
	String successMessage;
	String failureMessage;

	BookVO bookDetailsVo;
	List<BookVO> bookList;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public BookVO getBookdetailsvo() {
		return bookDetailsVo;
	}

	public void setBookdetailsvo(BookVO bookdetailsvo) {
		this.bookDetailsVo = bookdetailsvo;
	}

	public List<BookVO> getBooklist() {
		return bookList;
	}

	public void setBooklist(List<BookVO> booklist) {
		this.bookList = booklist;
	}

}
