package com.demo.response;

import java.util.List;

import com.demo.vo.StudentVO;

public class ResponseObjectStudent {
	String successMessage;
	String failureMessage;
	
	StudentVO fetchStudent;
	List<StudentVO> fetchAllStudents;
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
	public StudentVO getFetchStudent() {
		return fetchStudent;
	}
	public void setFetchStudent(StudentVO fetchStudent) {
		this.fetchStudent = fetchStudent;
	}
	public List<StudentVO> getFetchAllStudents() {
		return fetchAllStudents;
	}
	public void setFetchAllStudents(List<StudentVO> fetchAllStudents) {
		this.fetchAllStudents = fetchAllStudents;
	}
	
	

}
