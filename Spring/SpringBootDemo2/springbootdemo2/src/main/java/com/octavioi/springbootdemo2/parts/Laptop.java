package com.octavioi.springbootdemo2.parts;


import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
	public void compile() {
		System.out.println("Laptop: Compiling.");
	}
}
