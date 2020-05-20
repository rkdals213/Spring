package com.ssafy.day1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.spring.config.ApplicationConfig;
import com.ssafy.zoom3.model.repo.UserRepo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class BeanTest {
	
	static Logger logger = LoggerFactory.getLogger(BeanTest.class);
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionTemplate temp;
	
	@Autowired
	UserRepo urepo;
	
	@Test
	public void test() throws SQLException {
		assertThat(ds, is(notNullValue()));
		assertThat(temp, is(notNullValue()));
		
		logger.debug("db확인 : {}", ds.getConnection());
		
		assertThat(urepo, is(notNullValue()));
	}
	
}
