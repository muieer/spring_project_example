package org.muieer;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @Resource
    SchedulingService example;

    @GetMapping("/job/add/")
    public void addJob(String jobContent, String cornExpression) {
        example.addJob(jobContent, cornExpression);
    }

}
