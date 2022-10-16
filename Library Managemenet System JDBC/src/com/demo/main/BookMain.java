package com.demo.main;

import java.util.List;
import java.util.Scanner;

import com.demo.exception.BookManagementException;
import com.demo.exception.BookNotFoundException;
import com.demo.response.ResponseObject;
import com.demo.service.BookService;
import com.demo.vo.BookVO;

public class BookMain {

	public static void main(String[] args) throws BookManagementException, BookNotFoundException {
		// TODO Auto-generated method stub
		boolean isRunning=true;
	while(isRunning){
		System.out.println("please select  one of the below option");
		System.out.println("1. Add Book");
		System.out.println("2. Fetch Book by BookId");
		System.out.println("3. Fetch All Books");
		System.out.println("4. Update Book details");
		System.out.println("5.Delete a record");
		System.out.println("6. Exit");
		Scanner s = new Scanner(System.in);
		int selected = s.nextInt();

		switch (selected) {
		case 1:
			AddBooks();
			break;
		case 2:
			fetchBookId();
			break;
		case 3:
			fetchAllBook();
			break;
		case 4:
			updateBookDetails();
			break;
		case 5:
			deleteRecord();
			break;
		case 6:
			System.out.println("Thank You. Visit again");
			isRunning=false;
			break;
		default:
			System.exit(selected);

		}
		
	}

	}

	private static void deleteRecord() throws BookManagementException {
		// TODO Auto-generated method stub
		BookService service=new BookService();
		Scanner s=new Scanner (System.in);
		System.out.println("Enter the Book id to delete the book details");
		int bookid=Integer.parseInt(s.nextLine());
		
		
		ResponseObject ro=new ResponseObject();
		ro = service.deleteRecord(bookid);
		if(ro.getSuccessMessage()!=null) {
			System.out.println(ro.getSuccessMessage());
		}
		else {
			System.out.println(ro.getFailureMessage());

		}
	}

	private static void updateBookDetails() throws BookManagementException {
		// TODO Auto-generated method stub
		BookService bookservice = new BookService();
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter the BookId : ");
		Integer bookid = Integer.parseInt(s.nextLine());
		System.out.println("please Enter The Book Name: ");
		String bookname = s.nextLine();
		System.out.println("Please Enter The Author Name: ");
		String authorname = s.nextLine();
		System.out.println("please Enter The Edition Of The Book");
		String edition = s.nextLine();

		BookVO vo = new BookVO();
		vo.setBookId(bookid);
		vo.setBookName(bookname);
		vo.setAuthorName(authorname);
		vo.setEditions(edition);

		ResponseObject obj = new ResponseObject();
		obj = bookservice.updateBook(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchAllBook() throws BookNotFoundException {
		// TODO Auto-generated method stub StudentService stuser = new StudentService();
		BookService bookservice = new BookService();
		ResponseObject obj = new ResponseObject();
		System.out.println(bookservice.fetchAllBooks());
		obj = bookservice.fetchAllBooks();
		List<BookVO> list;
		list = obj.getBooklist();

		System.out.println("=======================================================================================");
		System.out.println("Book ID" + "\t\t" + "Book Name" + "\t\t" + "Author Name" + '\t' + "Editions" + '\t');
		System.out.println("=======================================================================================");
		if (list != null) {
			for (BookVO vo : list) {
				System.out.println(vo.getBookId() + "\t\t" + vo.getBookName() + "\t\t\t" + vo.getAuthorName() + "\t\t"
						+ vo.getEditions());
			}
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchBookId() throws BookNotFoundException {
		// TODO Auto-generated method stub
		BookService bookservice = new BookService();
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter the book id to be Fetched");
		Integer bookid = Integer.parseInt(s.nextLine());

		BookVO vo = new BookVO();
		ResponseObject obj;
		obj = bookservice.fetchBook(bookid);
		vo = obj.getBookdetailsvo();
		if (vo != null) {
			System.out
					.println("=======================================================================================");
			System.out.println("Book ID" + "\t\t" + "Book Name" + '\t' + "Author Name" + '\t' + "Edition" + '\t');
			System.out
					.println("=======================================================================================");
			System.out.println(vo.getBookId() + "\t\t" + vo.getBookName() + "\t\t" + vo.getAuthorName() + "\t\t"
					+ vo.getEditions());

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void AddBooks() throws BookManagementException {
		// TODO Auto-generated method stub
		BookService bookservice = new BookService();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter book id");
		Integer bookid = Integer.parseInt(s.nextLine());
		System.out.println("Enter book name");
		String bookname = s.nextLine();
		System.out.println("Enter Name of the author");
		String authorname = s.nextLine();
		System.out.println("Enter the edition of the book");
		String edition = s.nextLine();

		BookVO vo = new BookVO();
		vo.setBookId(bookid);
		vo.setBookName(bookname);
		vo.setAuthorName(authorname);
		vo.setEditions(edition);

		ResponseObject obj = new ResponseObject();
		obj = bookservice.saveBook(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
}
