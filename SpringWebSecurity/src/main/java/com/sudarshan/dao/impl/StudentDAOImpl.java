package com.sudarshan.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.sudarshan.dao.StudentDAO;
import com.sudarshan.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFac;

	@Override
	public void saveStudent(Student student) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	@Override
	public void updateStudent(Student student) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();	
	}

	@Override
	public void deleteStudent(int studentId) {
		Student student = getStudent(studentId);
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		session.delete(student);
		session.getTransaction().commit();		
	}

	@Override
	public Student getStudent(int studentId) {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		Student student = (Student) session.get(Student.class, studentId);
		//Student student = (Student) session.load(Student.class, studentId);
		session.getTransaction().commit();
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		Session session = sessionFac.getCurrentSession();
		session.beginTransaction();
		List<Student> studntsList = session.createQuery("from Student").list();
		session.getTransaction().commit();
		return studntsList;
	}

}
