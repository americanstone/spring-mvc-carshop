package com.youcodehub.spring.repository;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.youcodehub.spring.domain.Category;

public class JdbcCategoryDao extends JdbcDaoSupport implements CategoryDao{

	@Override
	public Category getCategoryById(int id) {
		String sql = "select * from category where cid = ?";
		Category category = getJdbcTemplate().queryForObject(sql, ParameterizedBeanPropertyRowMapper.newInstance(Category.class), new Object[]{id});		
		return category;
	}

}
