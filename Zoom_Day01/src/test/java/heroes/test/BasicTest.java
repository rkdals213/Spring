package heroes.test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import heros.beans.HulkBuster;
import heros.config.HeroesConfig;

public class BasicTest {
	static Logger logger = LoggerFactory.getLogger(BasicTest.class);

	static ApplicationContext ctx;
	
	@BeforeClass
	public static void beforeClass() {
//		logger.debug("모든 클래스 테스트 이전에 준비 작업");
		ctx = new AnnotationConfigApplicationContext(HeroesConfig.class);
	}
	
	@Before
	public void before() {
		logger.debug("각각의 테스트마다 실행");
	}
	
	@Test
	public void test1() {
//		logger.debug("test1");
		HulkBuster hb = ctx.getBean(HulkBuster.class);
//		logger.debug("Bean 확인 : {}", hb);
		assertThat(hb, is(notNullValue()));
	}
	
	@Test
	public void test2() {
//		logger.debug("test2");
		HulkBuster hb1 = ctx.getBean(HulkBuster.class);
		HulkBuster hb2 = (HulkBuster) ctx.getBean("hb");	
		assertThat(hb1, is(hb2));
	}
}
