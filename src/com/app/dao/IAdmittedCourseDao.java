package com.app.dao;

import java.util.List;

import com.app.pojos.AdmittedCourse;



public interface IAdmittedCourseDao {
	List<AdmittedCourse> getAllAdmittedCourses();
	AdmittedCourse getAdmittedCourseById(int admittedCourseId);
	AdmittedCourse addAdmittedCourseDetails(AdmittedCourse a);//e --transient 
	void deleteAdmittedCourse(AdmittedCourse a);
}
