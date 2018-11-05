package com.gcu.data;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

//parent spring class for containing datasource and spring jdbc template
public class Spring {

	
	//data access variables
	protected DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;
	
	//auto wired injection setter
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	
	
}
