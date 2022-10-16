package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exception.StudentManageException;
import com.demo.exception.StudentNotFoundException;
import com.demo.vo.StudentVO;

public class StudentDAO {
	
	private Connection createConnection() throws SQLException{
		String url= "jdbc:mysql://localhost:3306/library_management_system?useSSL=false";
		String user="root";
		String pwd="root";
		return DriverManager.getConnection(url, user, pwd);
	}
	public boolean addStudent(StudentVO vo) throws StudentManageException{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=createConnection();
			String query = "insert into Student_details values(?,?,?,?,?)";
			ps=conn.prepareStatement(query);
			ps.setInt(1, vo.getStuentId());
			ps.setString(2, vo.getStudentName());
			ps.setInt(3, vo.getStudentAge());
			ps.setString(4, vo.getDept());
			ps.setLong(5, vo.getMobileNo());
			
			int i=ps.executeUpdate();
			if(i>0) {
				flag=true;
				System.out.println("Record inserted successfully");
			}
			
		}
		catch(SQLException e) {
			throw new StudentManageException("please give correct value");
		}
		finally {
			try {
				conn.close();
				ps.close();
			}catch(SQLException e) {
				throw new StudentManageException("Please give  proper values ");
			}
		}
		return flag;
	}
	public boolean update(StudentVO vo)throws StudentManageException{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=createConnection();
			String query="update student_details set student_name=?,student_age=?,dept=?,mobile_no=? where student_id=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, vo.getStudentName());
			ps.setInt(2, vo.getStudentAge());
			ps.setString(3, vo.getDept());
			ps.setLong(4, vo.getMobileNo());
			ps.setInt(5, vo.getStuentId());
			
			int i =ps.executeUpdate();
			if(i>0) {
				flag=true;
				System.out.println("Update successfully");
			}
			
		}
		catch(SQLException e) {
			throw new StudentManageException("Error while updating student details");
		}
		finally {
			try {
				conn.close();
				ps.close();
			}
			catch(SQLException e ){
				throw new StudentManageException("Error while updating student details");
				
			}
		}
		return flag;
	}

	public StudentVO fetchStudent(int studentId)throws StudentNotFoundException{
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StudentVO vo = new StudentVO();
		
		try {
			conn=createConnection();
			String query="select * from Student_details where student_id=?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, studentId);
			rs=ps.executeQuery();
			while(rs.next()) {
		        vo.setStuentId(rs.getInt("student_Id"));	
		        vo.setStudentName(rs.getString("student_Name"));
		        vo.setStudentAge(rs.getInt("student_Age"));
		        vo.setDept(rs.getString("dept"));
		        vo.setMobileNo(rs.getLong("mobile_No"));
		      }
		}catch(SQLException e) {
			throw new StudentNotFoundException("Please Enter a valid Student Id");
		}
		finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			}
			catch(SQLException e){
				throw new StudentNotFoundException("Please Enter a valid student Id");
			}
		}
		return vo;
	}

	public List<StudentVO> fetchAllStudents() throws StudentNotFoundException{
		List<StudentVO> list =new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=createConnection();
			String query="select * from Student_details";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				StudentVO vo =new StudentVO();
				vo.setStuentId(rs.getInt("student_Id"));
				vo.setStudentName(rs.getString("Student_Name"));
				vo.setStudentAge(rs.getInt("Student_age"));
				vo.setDept(rs.getString("dept"));
				vo.setMobileNo(rs.getLong("mobile_No"));
				list.add(vo);
			}
			
		}
		catch(SQLException e) {
			throw new StudentNotFoundException("Error while fetching details");
		}
		finally {
			try {
				conn.close();
				ps.close();
				rs.close();
			}
			catch(SQLException e){
				throw new StudentNotFoundException("Error while fetching details");
			}
		}
		return list;
	}
	public boolean deleteDetail(int studentId)throws StudentNotFoundException{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=createConnection();
			String query="delete from Student_details where student_id=?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, studentId);
			
			int i=ps.executeUpdate();
			if(i!=0) {
				flag=true;
			}
		}
		catch(SQLException e) {
			throw new StudentNotFoundException("Please enter a student it that exist database");
		}
		finally {
			try {
				conn.close();
				ps.close();
			}
			catch(SQLException e){
				throw new StudentNotFoundException("Please enter a student it that exist database");
			}
		}
		return flag;
	}
}
