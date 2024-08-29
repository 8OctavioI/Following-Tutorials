package com.octavioi.springjdbc;

import com.octavioi.springjdbc.model.*;
import com.octavioi.springjdbc.service.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringjdbcApplication.class, args);
		Services service = context.getBean(Services.class);
		Student student = context.getBean(Student.class);

		for (var stu: service.getStudents()) {
			System.out.println(stu);
		}

		student.setId(service.lastStudentID() + 1);
		student.setName("Monroe II");
		student.setMajor("Art of Seduction III");
		service.addStudent(student);
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//System.out.println(student);
		
		for (var stu: service.getStudents()) {
			System.out.println(stu);
		}
	}

}
