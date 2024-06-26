package com.jobapplic.jobappbyme.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    Boolean deleteJobById(Long id);
    boolean jobUpdate(Long id,Job job);
}
