package org.muieer.beans;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ToString
@Component
public class Car {

    public String name = "奥迪";

//    @Autowired
//    Person owner;
}
