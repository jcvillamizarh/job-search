package com.jcvh.jobsearch.api;

import com.jcvh.jobsearch.model.JobPosition;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

@Headers("Accept: application/json")
public interface APIJobs {

    @RequestLine("GET /positions.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /positions/{id}.json")
    JobPosition job(@Param("id") String id);
}
