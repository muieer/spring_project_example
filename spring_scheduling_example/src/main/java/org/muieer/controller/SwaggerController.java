package org.muieer.controller;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import org.muieer.service.SchedulingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @Resource
    SchedulingService example;

    @GetMapping("/job/add/")
    public void addJob(@Parameter(example = "input") String jobContent, String cornExpression) {
        example.addJob(jobContent, cornExpression);
    }

}
