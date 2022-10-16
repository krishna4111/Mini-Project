package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.bo.StudentBO;
import com.demo.exception.StudentManageException;
import com.demo.exception.StudentNotFoundException;
import com.demo.response.ResponseObjectStudent;
import com.demo.vo.StudentVO;

public class StudentService {
	ResponseObjectStudent obj=new ResponseObjectStudent();
	StudentBO bo=new StudentBO();
	StudentVO vo=new StudentVO();
	List<StudentVO> list=new ArrayList<>();
	
	public ResponseObjectStudent addStudent(StudentVO vo) throws StudentManageException{
		boolean flag;
		try {
			flag=bo.insertStudent(vo);
			obj.setSuccessMessage("value inserted successfully");
			
		}
		catch(StudentManageException e){
			obj.setFailureMessage("please enter valid input");
			
		}
		return obj; 
	}
	public ResponseObjectStudent update(StudentVO vo) throws StudentManageException{
		boolean flag;
		try {
			flag=bo.update(vo);
			obj.setSuccessMessage("Student detail Updated Successfully");
		}
		catch(StudentManageException e) {
			obj.setFailureMessage("Error when updating Student Details");
		}
		return obj;
	}
	public ResponseObjectStudent fetchStudent(int studentId)throws StudentNotFoundException{	
		
		try {
			vo = bo.fetchStudent(studentId);
			if(vo.getStuentId()>0) {
				obj.setFetchStudent(vo);
			}
			else {
				throw new StudentNotFoundException("Please Enter a valid student Id");
			}
		}
		catch(StudentNotFoundException e ) {
			obj.setFailureMessage("Please Enter a valid student Id");
		}
		return obj;
	}
	public ResponseObjectStudent fetchAll()throws StudentNotFoundException{
		try {
			list = bo.fetchAll();
		    obj.setFetchAllStudents(list);
		    
		}
		catch(StudentNotFoundException e) {
			obj.setFailureMessage("Error when fetching Student Details");
		}
		return obj;
	}
	public ResponseObjectStudent delete(int studentId)throws StudentNotFoundException{
		boolean flag;
		try {
			flag=bo.delete(studentId);
			obj.setSuccessMessage("Student detail deleted successfully");
		}
		catch(StudentNotFoundException e) {
			obj.setFailureMessage("please enter a student Id that exist in then database");
		}
		return obj;
	}

}
