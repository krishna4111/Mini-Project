package com.demo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.exception.StudentManageException;
import com.demo.exception.StudentNotFoundException;
import com.demo.response.ResponseObject;
import com.demo.response.ResponseObjectStudent;
import com.demo.service.BookService;
import com.demo.service.StudentService;
import com.demo.vo.StudentVO;

public class StudentMain {

	public static void main(String[] args) throws StudentManageException,StudentNotFoundException {
		// TODO Auto-generated method stub
		boolean isRunning=true;
		while(true) {
			System.out.println("please select any one of the below options");
			System.out.println("1.Add student details");
			System.out.println("2.Update student details");
			System.out.println("3.Fetch student details");
			System.out.println("4.Fetch all student details");
			System.out.println("5.Delete student details");
			System.out.println("6.exit");
			Scanner s=new Scanner(System.in);
			int value=Integer.parseInt(s.nextLine());
			
			switch(value) {
			case 1:
				addStudent();
				break;
			case 2:
				updateStudent();
				break;
			
			case 3:
				fetchStudent();
				break;
			
			case 4:
				fetchAll();
				break;
			case 5:
				deleteStudentDetail();
				break;
				
			case 6:
			    System.out.println("Thank you!.. visit Again");
			    isRunning=false;
			    break;
			default:
				System.exit(value);
				
			}
		}
	}

	private static void deleteStudentDetail() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		StudentService service=new StudentService();
		Scanner s=new Scanner (System.in);
		System.out.println("Enter the Book id to delete the book details");
		int studentId=Integer.parseInt(s.nextLine());
		
		
		ResponseObjectStudent ro=new ResponseObjectStudent();
		ro = service.delete(studentId);
		if(ro.getSuccessMessage()!=null) {
			System.out.println(ro.getSuccessMessage());
		}
		else {
			System.out.println(ro.getFailureMessage());

		}
		
	}

	private static void fetchAll() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		StudentVO vo= new StudentVO();
		ResponseObjectStudent obj=new ResponseObjectStudent();
		StudentService ss=new StudentService();
		List<StudentVO> list=new ArrayList<>();
		obj=ss.fetchAll();
		list=obj.getFetchAllStudents();
		System.out.println("==========================================================================================================");
		System.out.println("Student Id"+'\t' +"Student Name" + '\t'+"Student Age"+'\t'+"Departmen"+'\t'+"Mobile No");
		System.out.println("===========================================================================================================");
		System.out.println(vo.getStuentId()+"\t\t"+vo.getStudentName()+"\t\t"+vo.getStudentAge()+"\t\t"+vo.getDept()+"\t\t"+vo.getMobileNo());
		if(obj.getFetchAllStudents() != null) {
			for(StudentVO co : list) {
				System.out.println(co.getStuentId() + "\t\t" + co.getStudentName() + "\t\t\t" + co.getStudentAge() + "\t\t"
						+ co.getDept()+"\t\t"+ co.getMobileNo());
			}
		}
		else {
			System.out.println(obj.getFailureMessage());
		}
		
	}

	private static void fetchStudent() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Enter StudentId to fetch Student Details");
		Scanner s = new Scanner(System.in);
		Integer studentId= Integer.parseInt(s.nextLine());
		
		StudentService ss=new StudentService();
		ResponseObjectStudent obj=new ResponseObjectStudent();
		StudentVO vo = new StudentVO();
		
		obj=ss.fetchStudent(studentId);
		vo=obj.getFetchStudent();
		
		if(vo != null) {
			System.out.println("=======================================================================================");
			System.out.println("Student Id"+'\t' +"Student Name" + '\t'+"Student Age"+'\t'+"Departmen"+'\t'+"Mobile No");
			System.out.println("=======================================================================================");
			System.out.println(vo.getStuentId()+"\t\t"+vo.getStudentName()+"\t\t"+vo.getStudentAge()+"\t\t"+vo.getDept()+"\t\t"+vo.getMobileNo());
		}
		else {
			System.out.println(obj.getFailureMessage());
		}
		
	}

	private static void updateStudent() throws StudentManageException  {
		// TODO Auto-generated method stub
		System.out.println("Enter a student Id to update student detail");
		Scanner s = new Scanner(System.in);
		Integer studentid=Integer.parseInt(s.nextLine());
		System.out.println("Enter student Name");
		String studentName = s.nextLine();
		System.out.println("Enter student Age");
		Integer age=Integer.parseInt(s.nextLine());
		System.out.println("Enter student's department");
		String dept=s.nextLine();
		System.out.println("Enter student's Mobile Number");
		Long mobno=Long.parseLong(s.nextLine());
		
		StudentVO vo=new StudentVO();
		vo.setStudentName(studentName);
		vo.setStudentAge(age);
		vo.setDept(dept);
		vo.setMobileNo(mobno);
		vo.setStuentId(studentid);
		
	    StudentService ss=new StudentService();
	    ResponseObjectStudent obj=new ResponseObjectStudent();
	    obj=ss.update(vo);
	    if(obj.getSuccessMessage() != null) {
	    	System.out.println(obj.getSuccessMessage());
	    }
	    else {
	    	System.out.println(obj.getFailureMessage());
	    }
	    
		
	}

	private static void addStudent() throws StudentManageException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter studenet Id");
		Integer studentid=Integer.parseInt(s.nextLine());
		System.out.println("Enter student Name");
		String studentName=s.nextLine();
		System.out.println("Enter student Age");
		Integer studentAge=Integer.parseInt(s.nextLine());
		System.out.println("Enter students department");
		String dept=s.nextLine();
		System.out.println("Enter student Mobile Number");
		Long mobileNo=Long.parseLong(s.nextLine());
		
		StudentService ss=new StudentService();
		StudentVO vo=new StudentVO();
		vo.setStuentId(studentid);
		vo.setStudentName(studentName);
		vo.setStudentAge(studentAge);
		vo.setDept(dept);
		vo.setMobileNo(mobileNo);
		
		ResponseObjectStudent obj=new ResponseObjectStudent();
		obj=ss.addStudent(vo);
		if(obj.getSuccessMessage() != null) {
			obj.getSuccessMessage();
		}
		else {
			obj.getFailureMessage();
		}
		
		
	}

}
