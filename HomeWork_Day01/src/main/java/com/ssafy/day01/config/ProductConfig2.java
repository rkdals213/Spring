package com.ssafy.day01.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


// 환경 설정 파일이에요..

@Configuration
// 패키기 기반으로 빈 찾아보기
@ComponentScan({"com.ssafy.day01.model.repo","com.ssafy.day01.model.service"})
public class ProductConfig2 {
	
	// 내부에는 스프링이 관리할 빈을 어떻게 만들지 설명한다
	@Bean
	// DataSource 타입의 빈을 만들겁니다.. 그 Bean의 이름은 dataSource로 해주세요
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		return ds;
	}	
}
