package com.ssafy.s0518.step4.di;

public class MessageBeanImpl implements MessageBean{
     
	private String greeting;
	private String name;	
	
	public MessageBeanImpl() {
	   System.out.println("MessageBeanImpl기본생성자");
	}
	
	public MessageBeanImpl(String name) {
		System.out.println("MessageBeanImpl오버로딩생성자");
		this.name=name;
	}	

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	
	@Override
	public void sayHello() {
		String str=greeting+", "+name+"!!!";
		System.out.println(str);//콘솔출력
	}
}
