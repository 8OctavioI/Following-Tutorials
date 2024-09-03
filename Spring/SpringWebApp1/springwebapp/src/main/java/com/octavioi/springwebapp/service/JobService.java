package com.octavioi.springwebapp.service;

import com.octavioi.springwebapp.repo.*;
import com.octavioi.springwebapp.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public void addJob(JobPost job) {
        repo.addJob(job);
    }

}
