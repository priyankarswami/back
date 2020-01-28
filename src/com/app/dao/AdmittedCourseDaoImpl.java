package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AdmittedCourse;

@Repository
@Transactional
public class AdmittedCourseDaoImpl implements IAdmittedCourseDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<AdmittedCourse> getAllAdmittedCourses() {
		String jpql = "select a from AdmittedCourse a";
		return sf.getCurrentSession().createQuery(jpql, AdmittedCourse.class).getResultList();
	
	}

	@Override
	public AdmittedCourse getAdmittedCourseById(int admittedCourseId) {
		return sf.getCurrentSession().get(AdmittedCourse.class, admittedCourseId);
	}

	@Override
	public AdmittedCourse addAdmittedCourseDetails(AdmittedCourse a) {
		sf.getCurrentSession().persist(a);
		return a;
	}

	@Override
	public void deleteAdmittedCourse(AdmittedCourse a) {
		sf.getCurrentSession().delete(a);
		
	}
}
