package com.sudarshan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.dao.StudentDAO;
import com.sudarshan.model.Student;
import com.sudarshan.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		studentDAO.deleteStudent(studentId);
	}

	@Override
	public Student getStudent(int studentId) {
		return studentDAO.getStudent(studentId);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentDAO.getAllStudent();
	}

}
