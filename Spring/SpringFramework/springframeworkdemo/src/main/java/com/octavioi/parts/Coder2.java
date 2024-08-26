package com.octavioi.parts;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Coder2 {

	
	Computer computer;

    public Coder2(Computer computer) {
        this.computer = computer;
    }

	public void code() {
        System.out.println("codeing2..");
		computer.compile();
	}

}