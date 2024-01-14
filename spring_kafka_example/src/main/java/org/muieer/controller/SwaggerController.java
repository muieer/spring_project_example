package org.muieer.controller;

import io.swagger.v3.oas.annotations.Parameter;
import org.muieer.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @Autowired
    MessageProducer messageProducer;

    @GetMapping("/hello")
    public String hello(@Parameter(description = "输入你要打招呼对象的名称") String name) {
        messageProducer.sendMessage(name);
        return "hello " + name;
    }
}
