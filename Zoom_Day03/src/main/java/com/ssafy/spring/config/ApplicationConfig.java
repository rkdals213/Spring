package com.ssafy.spring.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ssafy.zoom3.model.repo.UserRepo;
import com.ssafy.zoom3.model.service.UserService;

@Configuration
// 백엔드 서비스와관련된 설정
@ComponentScan(basePackageClasses = {UserRepo.class, UserService.class})
public class ApplicationConfig {

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds) {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds);
		String configLoc = "classpath:/mybatis/mybatis_config.xml";
		factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLoc));
		return factoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactoryBean sfb) throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(sfb.getObject());
		return template;
	}

	@Bean
	public DataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC");
		ds.setUsername("ssafy");
		ds.setPassword("ssafy");
		return ds;
	}

}
