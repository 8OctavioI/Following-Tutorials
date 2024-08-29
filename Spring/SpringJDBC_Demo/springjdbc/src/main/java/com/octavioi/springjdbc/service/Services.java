package com.octavioi.springjdbc.service;

import com.octavioi.springjdbc.repo.*;
import com.octavioi.springjdbc.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

    private DatabaseConnection dbc;

    @Autowired
    public void setDbc(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public List<Student> getStudents(){
        return dbc.findAll();
    }

    public int lastStudentID() {
        return dbc.getLastStudentID();
    }

    public boolean addStudent(Student student) {
        
        try {
            dbc.save(student);
            return true;
        }
        finally {

        }
    
    }
    
}
