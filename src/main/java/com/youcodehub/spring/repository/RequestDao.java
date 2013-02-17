package com.youcodehub.spring.repository;

import java.util.List;

import com.youcodehub.spring.domain.Request;

public interface RequestDao {
	
	List<Request> getRequests();
	
	List<Request> getRequestsByOwner(String owner);
	
	List<Request> getRequestsByRequester(String requester);

}
