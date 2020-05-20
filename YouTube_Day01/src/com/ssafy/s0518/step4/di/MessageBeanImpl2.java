package com.ssafy.s0518.step4.di;

public class MessageBeanImpl2 implements MessageBean{
     
	private String greeting;
	private String name;
	private FileOutput fo; 
	
	
	public MessageBeanImpl2() {
	   System.out.println("MessageBeanImpl기본생성자");
	}
	
	public MessageBeanImpl2(String name) {
		System.out.println("MessageBeanImpl오버로딩생성자");
		this.name=name;
	}	
	public void setFo(FileOutput fo) {
		this.fo = fo;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	
	@Override
	public void sayHello() {
		String str=greeting+", "+name+"!!!";
		System.out.println(str);//콘솔출력
		fo.output(str);//파일출력
	}
}
