package com.app.dao;

import java.util.List;

import com.app.pojos.Student;

public interface IStudentDao {
	Student validateStudent(String email, String pass);
	List<Student> getAllStudents();
	Student getStudentById(int studentId);
	Student addStudentDetails(Student s);//e --transient 
	void deleteStudent(Student s);

}
