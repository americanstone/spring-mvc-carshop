package com.youcodehub.spring.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import com.youcodehub.spring.domain.Users;

public class JdbcUserDao extends JdbcDaoSupport implements UserDao{

	public List<Users> getUserList() {
		String sql = "select * from users";
		List<Users> users = this.getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Users.class));
		return users;
	}
	

	@Override
	public boolean findUser(String email) {
		String sql = "SELECT count(*) FROM USERS WHERE USERNAME = ?";
		int count = (int) this.getJdbcTemplate().queryForInt(sql,new Object[] {email},new int[]{Types.VARCHAR});
		return ((count !=0)? true: false);
	}

	@Override
	public void saveUser(final Users user) {
		String sql ="insert into users (username, password, fname, lname, role) values (?,?,?,?,?)";
		//this.getJdbcTemplate().update(sql, new Object[]{user.getUsername(), user.getPassword(), user.getFname(), user.getLname(), user.getRole()});
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFname());
				ps.setString(4, user.getLname());
				ps.setString(5, user.getRole());
			}
		});
	}

	@Override
	public boolean validUser(String email, String password) {
		String sql = "SELECT count(*) FROM USERS WHERE USERNAME = ? and PASSWORD = ?";
		int count = (int)this.getJdbcTemplate().queryForInt(sql,new Object[] {email,password},new int[]{Types.VARCHAR,Types.VARCHAR});
		return ((count !=0)? true: false);
	}


	@Override
	public String getRole(String username) {
		String sql = "SELECT role FROM USERS WHERE USERNAME = ?";
		return getJdbcTemplate().queryForObject(sql,new Object[]{username},String.class);
	}

}