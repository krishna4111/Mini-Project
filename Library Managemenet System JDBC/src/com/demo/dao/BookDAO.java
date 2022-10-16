package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.BookManagementException;
import com.demo.exception.BookNotFoundException;
import com.demo.vo.BookVO;

public class BookDAO {

	private Connection createConnection() throws SQLException {
		String user = "root";
		String pwd = "root";
		String url = "jdbc:mysql://localhost:3306/library_management_system?useSSL=false";
		return DriverManager.getConnection(url, user, pwd);
	}

	public boolean addBook(BookVO vo) throws BookManagementException {
		boolean flag = false;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = createConnection();
			System.out.println("DB connected successfully");
			String query = "insert into Book_Details values (?,?,?,?);";
			ps = conn.prepareStatement(query);
			ps.setInt(1, vo.getBookId());
			ps.setString(2, vo.getBookName());
			ps.setString(3, vo.getAuthorName());
			ps.setString(4, vo.getEditions());
			int i = ps.executeUpdate();
			if (i != 0) {
				flag = true;

			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new BookManagementException("Error when adding the Book");
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new BookManagementException("Error when adding the book");

			}

		}
		return flag;
	}
	/*
	 * public boolean addBooks(BookDetailsVO vo) throws BookManagementException {
	 * boolean flag = false; Connection conn = null;
	 * 
	 * 
	 * try { conn = createConnection();
	 * System.out.println("DB connected successfully"); String query =
	 * "insert into book_details values(?,?,?,?)"; PreparedStatement ps =
	 * conn.prepareStatement(query); ps.setInt(1, vo.getBookId()); ps.setString(2,
	 * vo.getBookName()); ps.setString(3, vo.getAuthorName()); ps.setString(4,
	 * vo.getEditions()); int i = ps.executeUpdate(); System.out.println(i); if (i
	 * != 0) { flag = true; } } catch (SQLException e) { throw new
	 * BookManagementException("Error When Adding This Book"); } finally { try {
	 * 
	 * ps.close(); conn.close(); } catch (SQLException e) { throw new
	 * BookManagementException("Error When Adding This Book"); }
	 * 
	 * } return flag; }
	 */

	public BookVO fetchBook(int BookId) throws BookNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BookVO vo = new BookVO();
		try {
			conn = createConnection();
			// System.out.println("DB Connected Successfully");

			String query = "select * from Book_Details where Book_Id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, BookId);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo.setBookId(rs.getInt("Book_Id"));
				vo.setBookName(rs.getString("Book_Name"));
				vo.setAuthorName(rs.getString("Author_Name"));
				vo.setEditions(rs.getString("Editions"));
			}

		} catch (SQLException e) {
			throw new BookNotFoundException("fetching bookId is not found in database");
		} finally {
			try {
				conn.close();
				ps.close();
				rs.close();

			} catch (SQLException e) {
				throw new BookNotFoundException("fetching bookId is not found in database");
			}

		}
		return vo;

	}

	public List<BookVO> fetchAllBook() throws BookNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BookVO vo = new BookVO();
		List<BookVO> list = new ArrayList<>();
		try {
			conn = createConnection();
			// System.out.println("DB connected successfully");

			String query = "select * from Book_Details";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				vo = new BookVO();
				vo.setBookId(rs.getInt("Book_Id"));
				vo.setBookName(rs.getString("Book_Name"));
				vo.setAuthorName(rs.getString("Author_Name"));
				vo.setEditions(rs.getString("Editions"));
				list.add(vo);

			}
		} catch (SQLException e) {
			/* e.printStackTrace(); */
			throw new BookNotFoundException("list of table is not found in database");

		} finally {
			try {
				ps.close();
				conn.close();
				rs.close();
				
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new BookNotFoundException("list of table is not found in database");
			}

		}
		
		return list;

	}

	public boolean updateBook(BookVO vo) throws BookManagementException {
		boolean flag = false;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = createConnection();
			// System.out.println("Updated Successfully");
			String query = "update Book_Details set Book_Name=?,Author_Name=?,Editions=? where Book_Id=? ;";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getBookName());
			ps.setString(2, vo.getAuthorName());
			ps.setString(3, vo.getEditions());
			ps.setInt(4, vo.getBookId());

			int i = ps.executeUpdate();
			if (i != 0) {
				flag = true;

			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new BookManagementException("Updating book detail fails");

		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new BookManagementException("Updating book detail fails");
			}

		}
		return flag;
	}
	public boolean deleteRecord(int BookId) throws BookManagementException{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn = createConnection();
			String query="delete from Book_details where Book_Id=?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, BookId);
			int i=ps.executeUpdate();
			if(i>0) {
				flag=true;
			}
		}
		catch(SQLException e) {
			throw new BookManagementException("Book id is not present in database");
		}finally {
			try {
				conn.close();
				ps.close();
			}
			catch(SQLException e){
				throw new BookManagementException("Book Id is Not Fount");
			}
		}
		
		return flag;
		
	}

}
