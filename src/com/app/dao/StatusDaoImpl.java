package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Status;

@Repository
@Transactional
public class StatusDaoImpl implements IStatusDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Status addStatusDetails(Status st) {
		sf.getCurrentSession().persist(st);
		return st;
	}
	
	public List<Status> getAllStatus() {
		String jpql = "select s from Status s";
		return sf.getCurrentSession().createQuery(jpql, Status.class).getResultList();
	}

	@Override
	public Status getStatusById(int statusId)
	{
		
		return sf.getCurrentSession().get(Status.class, statusId);
	}

	@Override
	public void updateStatus(int StatusId, Status Status) {
		Status oldStatus= sf.getCurrentSession().byId(Status.class).load(StatusId);
		
		oldStatus.setStatus(Status.getStatus());
				sf.getCurrentSession().flush();
	}

}
