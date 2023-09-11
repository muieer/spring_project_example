package org.muieer.beans;

import jakarta.annotation.PostConstruct;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ToString
@Component
public class Person {

    public String name = "test";

    @Autowired
    Car car;

    @PostConstruct
    public void init() {
        System.out.println("Person init: " + car);
    }
}
