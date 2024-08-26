package com.octavioi.parts;

import org.springframework.stereotype.Component;


public class Laptop implements Computer {
	public void compile() {
		System.out.println("Laptop: Compiling.");
	}
}
