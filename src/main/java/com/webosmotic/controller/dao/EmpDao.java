package com.webosmotic.controller.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.webosmotic.controller.modal.Employee;

public class EmpDao {
	
	JdbcTemplate jdbcTemplate;
	
	public void setTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public int save(Employee employee) {
		
		String sql="insert into Employee values(id,name,salary,designation)";
		return jdbcTemplate.update(sql);
	}
	
	public int update(Employee employee) {
		String sql="update Employee set name=? where salary=30000";
	     return jdbcTemplate.update(sql);
	}
	
	public int delete(int id) {
		String sql="delete from employee where id="+id+"";
		return jdbcTemplate.update(sql);
	}
	
	public Employee getEmpById(int id) {
		String sql="select * from employee where id="+id+"";
		return jdbcTemplate.queryForObject(sql, Employee.class);
	}

}
