package org.muieer.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @GetMapping("/hello")
    public String hello(@Parameter(description = "输入你要打招呼对象的名称") String name) {
        return "hello " + name;
    }

}
