package com.octavioi.parts;

public class Coder {

	
	Laptop laptop;

	public void code() {
        System.out.println("codeing..");
		laptop.compile();
	}

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Laptop getLaptop() {
        return this.laptop;
    }
}