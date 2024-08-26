package com.octavioi;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.octavioi.parts.Coder;
import com.octavioi.parts.Coder2;


public class App_Spring_XML 
{
	public static void main(String[] args) {
		//ApplicationContext context = SpringApplication.run(SpringdemoApplication.class, args);
		//Coder coder = context.getBean(Coder.class);

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Coder coder = context.getBean("coder", Coder.class);
		coder.code();
    
        Coder2 coder2 = (Coder2) context.getBean("coder2");
        coder2.code();

        Coder coder3 = context.getBean("coder3", Coder.class);
		coder3.code();

	}

}











