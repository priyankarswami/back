package com.app.dao;

import java.util.List;

import com.app.pojos.Status;

public interface IStatusDao {
	
	Status addStatusDetails(Status st);
	Status getStatusById(int statusId);
	List<Status> getAllStatus();
	void updateStatus(int StatusId, Status Status);

}
