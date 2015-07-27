package com.sudarshan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sudarshan.model.Student;
import com.sudarshan.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentSrvc;
	
	@RequestMapping("/viewstudents")
	public String studentInfo(Map<String, Object> map) {
		Student student = new Student();
		List<Student> allStudents = studentSrvc.getAllStudent();
		map.put("student", student);
		map.put("allStudents", allStudents);
		return "student";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value="studentops",method=RequestMethod.POST )
	public String studentOperations(@ModelAttribute Student student, BindingResult result, @RequestParam String operation, Map<String, Object> map) {
		Student newStudent = null;
		List<Student> studentList = null;
		switch(operation.toLowerCase()) {
		case "add" :
			studentSrvc.saveStudent(student);
			newStudent = student;
			break;
		case "update" :
			studentSrvc.updateStudent(student);
			newStudent = student;
			break;
		case "delete" :
			studentSrvc.deleteStudent(student.getId());
			newStudent = new Student();
			break;
		case "getstudent" :
			newStudent = studentSrvc.getStudent(student.getId());
			break;
		}
		studentList = studentSrvc.getAllStudent();
		map.put("student", newStudent);
		map.put("allStudents", studentList);
		return "student";
	}
	
	@RequestMapping("/login/sessioninvalidated")
	public String sessionInvalidloginPage(Map<String, Object> map) {
		map.put("sessionInfo", "Session has become invalid..Please login again");
		return "login";
	}
	
	@RequestMapping("/login/sessionexpired")
	public String sessionExpiredloginPage(Map<String, Object> map) {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		map.put("sessionInfo", "Session has Expired..Please login again");
		return "login";
	}
}
