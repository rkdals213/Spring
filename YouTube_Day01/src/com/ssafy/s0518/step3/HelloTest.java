package com.ssafy.s0518.step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
	public static void main(String[] args) {
		//applicationContext.xml문서 읽기
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("com/ssafy/s0518/step3/applicationContext.xml");

		// XML문서에 정의 Bean 가져오기 ==> ctx.getBean("정의된 id명");
		MessageBean msg = (MessageBean)ctx.getBean("msgBean");
		msg.sayHello("김주원");
	}
}



