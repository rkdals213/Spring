package com.ssafy.s0518.step4.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
   public static void main(String[] args) {
	   ApplicationContext ctx =
          new ClassPathXmlApplicationContext("com/ssafy/s0518/step4/di/applicationContext.xml");
	   //---> applicationContext.xml에 등록된 클래스를 사용할 준비작업이 끝났음!!	
	   
	   MessageBean msg = (MessageBean) ctx.getBean("msgBean");
	   
	   msg.sayHello();
	   
   }
}
