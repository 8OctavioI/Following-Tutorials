package com.octavioi.springjdbc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int id;
    private String name;
    private String major;

    Student() {
        
    }

    public Student(int id, String name, String major) {
        setId(id);
        setName(name);
        setMajor(major);
    }





    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", major=" + major + "]";
    }
    

    
    
}
