package com.octavioi.springwebapp.repo;

import com.octavioi.springwebapp.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    private List<JobPost> jobs;

    JobRepo() {
        this.jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Dev", "Must be okay", Arrays.asList("Java", "Spring")),
                new JobPost(2, "Spring Dev", "Must be good", Arrays.asList("Java", "Spring")),
                new JobPost(3, "Rust Dev", "Must be great", Arrays.asList("Java", "RUST")),
                new JobPost(4, "Js Dev", "Must be okay", Arrays.asList("Js", "Ts")),
                new JobPost(5, "Ts Dev", "Must be okay", Arrays.asList("Ts", "Js"))));
    }

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public void addJob(JobPost job) {
        jobs.add(job);
    }

}
