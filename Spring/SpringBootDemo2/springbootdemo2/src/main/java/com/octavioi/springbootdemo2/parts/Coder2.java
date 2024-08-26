package com.octavioi.springbootdemo2.parts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Coder2 {

    @Value("1")
    private int version;

	
	Computer computer;

    @Autowired
    public Laptop laptop;

    public Coder2(Computer computer) {
        this.computer = computer;
    }

	public void code() {
        System.out.println("codeing2..");
		computer.compile();
	}

    public int getVersion() {
        return version;
    }

}