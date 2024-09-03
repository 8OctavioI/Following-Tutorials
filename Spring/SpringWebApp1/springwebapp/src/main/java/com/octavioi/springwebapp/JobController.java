package com.octavioi.springwebapp;

import com.octavioi.springwebapp.service.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.octavioi.springwebapp.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("getalljobs")
    @ResponseBody
    public List<JobPost> getAllJobs() {
        var jobs = service.getAllJobs();
        System.out.println(jobs);
        return jobs;
    }

    @PostMapping("addjob")

    public void addjob(@RequestBody JobPost job) {
        System.out.println(job);
        service.addJob(job);
    }

}
