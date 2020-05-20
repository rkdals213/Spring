package heroes.test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import heros.beans.HulkBuster;
import heros.beans.IronMan;
import heros.config.HeroesConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = HeroesConfig.class)
public class BasicTest2 {
	static Logger logger = LoggerFactory.getLogger(BasicTest2.class);
	
	@Autowired
	HulkBuster hb;
	
	@Autowired
	@Qualifier("ironMan")
	IronMan iman;
	
	@Test
	public void test1() {
		assertThat(hb, is(notNullValue()));
	}
	
	@Test
	public void test2() {
		assertThat(iman, is(notNullValue()));
	}
}
