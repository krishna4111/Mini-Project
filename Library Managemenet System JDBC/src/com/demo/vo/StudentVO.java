package com.demo.vo;

public class StudentVO {
	private int stuentId;
	private String studentName;
	private int studentAge;
	private String dept;
	private Long mobileNo;
	public int getStuentId() {
		return stuentId;
	}
	public void setStuentId(int stuentId) {
		this.stuentId = stuentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "StudentVO [stuentId=" + stuentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", dept=" + dept + ", mobileNo=" + mobileNo + "]";
	}
	

}
