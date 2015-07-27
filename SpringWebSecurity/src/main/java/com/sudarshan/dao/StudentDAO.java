package com.sudarshan.dao;

import java.util.List;

import com.sudarshan.model.Student;

public interface StudentDAO {
	
	void saveStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudent(int studentId);
	
	Student getStudent(int studentId);
	
	List<Student> getAllStudent(); 
}
