package com.youcodehub.spring.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.youcodehub.spring.domain.Cars;
import com.youcodehub.spring.domain.Users;

public class JdbcCarDao extends JdbcDaoSupport implements CarDao{

	@Override
	public List<Cars> getCarList() {
		String sql = "SELECT * FROM USERS";
		List<Cars> cars = this.getJdbcTemplate().query(sql,new BeanPropertyRowMapper(Cars.class));
		return cars;
	}

	@Override
	public List<Cars> getCarList(String username) {
		String sql = "SELECT * FROM USERS NATURAL JOIN CARS NATURAL JOIN USER_CAR WHERE USERNAME = ?";
		List<Cars> cars = this.getJdbcTemplate().query(sql, new Object[]{username},new BeanPropertyRowMapper(Cars.class));
		return cars;
	}

	@Override
	public void saveCar(final Cars car) {
		String sql = "INSERT INTO CARS VALUE" + "(platenumber,make,model,image,vin,cartype,year) VALUE(? ? ? ? ? ? ?)";
		this.getJdbcTemplate().update(sql, new PreparedStatementSetter(){
			public void setValues(PreparedStatement ps) throws SQLException{
					ps.setString(1, car.getPlatenumber());
					ps.setString(2, car.getMake());
					ps.setString(3, car.getModel());
					ps.setString(4, car.getImage());
					ps.setString(5, car.getVin());
					ps.setString(6, car.getCartype());
					ps.setDate(7, car.getYear());
			}
			
			
		});
		
	}
	
	

}
