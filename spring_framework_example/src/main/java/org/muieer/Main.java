package org.muieer;

import org.muieer.beans.Config;
import org.muieer.beans.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        context.scan("org.muieer");
//        context.refresh();
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}