package com.demo.bo;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.StudentDAO;
import com.demo.exception.StudentManageException;
import com.demo.exception.StudentNotFoundException;
import com.demo.vo.StudentVO;

public class StudentBO {
	StudentDAO dao=new StudentDAO();
	StudentVO vo = new StudentVO();
	
	public boolean insertStudent(StudentVO vo) throws StudentManageException{
		boolean flag;
		try {
			flag=dao.addStudent(vo);
		}catch(StudentManageException e) {
			throw new StudentManageException("Please enter valid input");
		}
		return flag;
		
	}
	public boolean update(StudentVO vo) throws StudentManageException{
		boolean flag;
		try{
			flag=dao.update(vo);
		}
		catch(StudentManageException e) {
			throw new StudentManageException("Error while Updating Student Details");
		}
		return flag;
		
	}
	public StudentVO fetchStudent(int studentId)throws StudentNotFoundException{
		try {
			vo=dao.fetchStudent(studentId);
		}
		catch(StudentNotFoundException e) {
			throw new StudentNotFoundException("Please Enter a valid stuent Id");
		}
		return vo;
	}
	public List<StudentVO> fetchAll()throws StudentNotFoundException{
		List<StudentVO> list=new ArrayList<>();
		try {
			list=dao.fetchAllStudents();
		}
		catch(StudentNotFoundException e) {
			throw new StudentNotFoundException("Error whe fetching Stuent details");
		}
		return list;
	}
	public boolean delete(int StudentId)throws StudentNotFoundException{
		boolean flag;
		try {
			flag=dao.deleteDetail(StudentId);
			
		}
		catch(StudentNotFoundException e) {
			throw new StudentNotFoundException("Please enter a student it that exist database");
		}
		return flag;
	}

}
