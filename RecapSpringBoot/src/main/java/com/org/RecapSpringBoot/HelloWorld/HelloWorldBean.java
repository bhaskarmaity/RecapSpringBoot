package com.org.RecapSpringBoot.HelloWorld;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HelloWorldBean {
	private String message;
	public HelloWorldBean(String msg) {
		this.message=msg;
	}
}
