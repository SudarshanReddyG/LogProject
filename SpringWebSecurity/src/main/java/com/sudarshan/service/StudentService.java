package com.sudarshan.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

import com.sudarshan.model.Student;

public interface StudentService {
	
	//@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@PreAuthorize("isAnonymous()")
	void saveStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudent(int studentId);
	
	//@Secured("ROLE_ADMIN")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	Student getStudent(int studentId);
	
	List<Student> getAllStudent(); 

}
