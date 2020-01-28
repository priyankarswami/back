package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojos.Student;
@Repository
@Transactional
public class StudentDaoImpl implements IStudentDao {
	@Autowired
	private SessionFactory sf;

	public List<Student> getAllStudents() {
		String jpql = "select s from Student s";
		return sf.getCurrentSession().createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public Student getStudentById(int studentId)
	{
		
		return sf.getCurrentSession().get(Student.class, studentId);
	}

	@Override
	public Student addStudentDetails(Student s) {
		sf.getCurrentSession().save(s);
		return s;
	}
	@Override
	public void deleteStudent(Student s) {
		sf.getCurrentSession().delete(s);
		
	}

	@Override
	public Student validateStudent(String email1, String pass1) {
		String jpql = "select s from Student s where s.email=:em and s.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Student.class).setParameter("em", email1)
				.setParameter("pass", pass1).getSingleResult();
	}
}
