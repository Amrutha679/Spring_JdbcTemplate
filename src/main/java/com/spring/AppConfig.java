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
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackageClasses = SpringJdbcTemplate.class)
public class AppConfig {
	
    @Bean
    public DataSource getDataSource() {
    	
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/mondee");
        ds.setUsername("Amrutha");
        ds.setPassword("Amrutha@890");
        return ds;
    }
//   @Bean
//    public JdbcTemplate getJt(DataSource dataSource) {
//	   
//        JdbcTemplate jt = new JdbcTemplate(dataSource);
//        jt.setResultsMapCaseInsensitive(true);
//        return jt;
//    }
    
    @Bean
  public NamedParameterJdbcTemplate getNjt(DataSource ds) {
  	NamedParameterJdbcTemplate jt = new NamedParameterJdbcTemplate(ds);
      return jt;
  }
   
//   @Bean(value="getSpringTemplate")
//	public SpringJdbcTemplate getSpringTemplate(JdbcTemplate jt)
//	{
//		SpringJdbcTemplate sj=new SpringJdbcTemplate();
//		sj.setJt(jt);
//		return sj;
//	}
    
    @Bean(value="getSpringTemplate")
	public SpringJdbcTemplate getSpringTemplate(NamedParameterJdbcTemplate njt)
	{
		SpringJdbcTemplate sj=new SpringJdbcTemplate();
		sj.setNjt(njt);
		return sj;
	}

    
}
