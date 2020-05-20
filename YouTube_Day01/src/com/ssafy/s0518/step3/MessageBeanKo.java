package com.ssafy.s0518.step3;

public class MessageBeanKo implements MessageBean {

	public MessageBeanKo() {
		System.out.println(">>>MessageBeanKo기본생성자");
	}

	@Override
	public void sayHello(String name) {
		System.out.println("안녕, "+name+"!!");   	
	}

}
