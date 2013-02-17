package com.youcodehub.spring.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.youcodehub.spring.domain.RepairJob;

public class JdbcRepairJobDao extends JdbcDaoSupport implements RepairJobDao{

	@Override
	public RepairJob getRepairJobById(int id) {
		String sql = "select * from repair_jobs where rid=?";
		RepairJob repairJob = getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper(RepairJob.class), new Object[]{id} );
		return repairJob;
	}

}
