package com.youcodehub.spring.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.youcodehub.spring.domain.Request;

public class JdbcRequestDao extends JdbcDaoSupport implements RequestDao{

	@Override
	public List<Request> getRequests() {
		String sql = "select * from requests";
		List<Request> requests = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Request.class));
		return requests;
	}

	@Override
	public List<Request> getRequestsByOwner(String owner) {
		String sql = "select * from requests where personincharge='" + owner +"'";
		List<Request> requests = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Request.class));
		return requests;
	}

	@Override
	public List<Request> getRequestsByRequester(String requester) {
		String sql = "select * from requests where username = '" + requester + "'";
		List<Request> requests = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Request.class));
		return requests;
	}

}
