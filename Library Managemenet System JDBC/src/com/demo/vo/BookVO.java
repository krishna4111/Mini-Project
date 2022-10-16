package com.demo.vo;

public class BookVO {
	private int bookId;
	private String bookName;
	private String authorName;
	private String editions;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEditions() {
		return editions;
	}

	public void setEditions(String editions) {
		this.editions = editions;
	}

	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", editions="
				+ editions + "]";
	}

}
