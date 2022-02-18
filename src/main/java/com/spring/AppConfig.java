package com.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.jdbc")
public class AppConfig {
	
    @Bean
    public DataSource getDataSource() {
    	
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mondee");
        ds.setUsername("Amrutha");
        ds.setPassword("Amrutha@890");
        return ds;
    }
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.setResultsMapCaseInsensitive(true);
//        return jdbcTemplate;
//    }
    
    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource ds) {
    	NamedParameterJdbcTemplate jt = new NamedParameterJdbcTemplate(ds);
        return jt;
    }
}
