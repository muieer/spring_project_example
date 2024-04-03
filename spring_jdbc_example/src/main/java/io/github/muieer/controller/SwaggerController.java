package io.github.muieer.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerController.class);

    @GetMapping("/hello")
    public String hello(@Parameter(description = "输入你要打招呼对象的名称") String name) {
        LOGGER.info("hello {}", name);
        return "hello " + name;
    }
}
