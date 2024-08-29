package com.octavioi.springjdbc.repo;

import java.sql.*;
import com.octavioi.springjdbc.model.*;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseConnection {
    private JdbcTemplate jdbc;
    
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public int getLastStudentID() {
        String sql = "SELECT MAX(StudentID) FROM Students;";
        return jdbc.query(sql,  (ResultSet rs, int n) -> {
            return rs.getInt(1);
        }).get(0);
    }
    

    public List<Student> findAll() {
        String sql = "SELECT * FROM Students;";

        RowMapper<Student> rowMapper = (ResultSet rs, int n) -> {
            return new Student(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            );
        };

        List<Student> students = jdbc.query(sql, rowMapper);
        return students;
    }
    
    public boolean save(Student student) {
        try {
            String saveSQL = "INSERT INTO Students (StudentID, StudentName, Major) VALUES(?,?,?);";
            int added = jdbc.update(saveSQL, student.getId(), student.getName(), student.getMajor());
            if (added > 0) 
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }


}
