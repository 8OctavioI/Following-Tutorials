package com.octavioi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringdemoApplication.class, args);
		Coder coder = context.getBean(Coder.class);
		coder.code();
	}

}

@Component
class Coder {

	@Autowired
	Laptop laptop;

	public void code() {
		laptop.compile();
	}
}

@Component
class Laptop {
	public void compile() {
		System.out.println("Compiling.");
	}
}
