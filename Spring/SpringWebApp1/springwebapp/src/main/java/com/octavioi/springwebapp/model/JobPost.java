package com.octavioi.springwebapp.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {
    private int jobID;
    private String jobTitle;
    private String jobDesc;
    private List<String> jobTechStack;
}
