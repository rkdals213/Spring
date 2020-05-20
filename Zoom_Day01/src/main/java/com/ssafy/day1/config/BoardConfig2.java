package com.ssafy.day1.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.ssafy.day1.model.repo.BoardRepo;
import com.ssafy.day1.model.repo.BoardRepoImpl;
import com.ssafy.day1.model.service.BoardService;
import com.ssafy.day1.model.service.BoardServiceImpl;

// 환경 설정 파일이에요..

@Configuration
// 패키기 기반으로 빈 찾아보기
@ComponentScan({"com.ssafy.day1.model.repo","com.ssafy.day1.model.service"})
public class BoardConfig2 {
	
	// 내부에는 스프링이 관리할 빈을 어떻게 만들지 설명한다
	@Bean
	// DataSource 타입의 빈을 만들겁니다.. 그 Bean의 이름은 dataSource로 해주세요
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		return ds;
	}
	
	/*
	 * @Bean // BoardRepo 타입의 Bean을 만들어 주세요. 이름은 boardRepo로 해주시고요.. public BoardRepo
	 * boardRepo() { // 생성자를 호출하면서 dataSource를 넘겨주세요 BoardRepo repo = new
	 * BoardRepoImpl(dataSource()); return repo; }
	 * 
	 * @Bean public BoardService boardService() { BoardServiceImpl service = new
	 * BoardServiceImpl(); service.setBoardRepo(boardRepo()); return service; }
	 */
}
