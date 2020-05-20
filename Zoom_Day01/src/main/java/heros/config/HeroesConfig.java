package heros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import heros.beans.Heroes;
import heros.beans.HulkBuster;
import heros.beans.IronMan;

// 이것은 환경설정 파일입니다
@Configuration
@ComponentScan(basePackageClasses = HulkBuster.class) // HulkBuster가 있는 패키지를 찾아봐라
public class HeroesConfig {
	
	/*
	 * @Bean public IronMan iman() { // iman: 나중에 생성되는 빈의 이름 return new IronMan(); }
	 * 
	 * @Bean public HulkBuster hb() { return new HulkBuster(); }
	 * 
	 * @Bean public Heroes heroes() { Heroes heroes = new Heroes(iman());
	 * heroes.setHulkBuster(hb()); return heroes; }
	 */
}
