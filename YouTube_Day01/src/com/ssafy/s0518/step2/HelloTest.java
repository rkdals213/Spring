package com.ssafy.s0518.step2;

public class HelloTest {
   public static void main(String[] args) {
	  //부모클래스 = 자식클래스!!   Parent p = new Child();
	  MessageBean  msg;//인터페이스
//	               msg = new MessageBeanKo();
//	               msg = new MessageBeanEn();
	               msg = new MessageBeanVi();
	               
       msg.sayHello("길라임");	               
   }
}
