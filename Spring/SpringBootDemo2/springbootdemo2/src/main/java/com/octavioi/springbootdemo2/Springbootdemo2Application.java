package com.octavioi.springbootdemo2;

import com.octavioi.springbootdemo2.parts.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springbootdemo2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springbootdemo2Application.class, args);

		var coder = context.getBean(Coder2.class);

		coder.code();
		coder.laptop.compile();
		System.out.println("Version: " + coder.getVersion());


	}

}
