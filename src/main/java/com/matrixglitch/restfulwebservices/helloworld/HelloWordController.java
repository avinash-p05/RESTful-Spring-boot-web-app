package com.matrixglitch.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWordController {

    private MessageSource messageSource;

    public HelloWordController(MessageSource messageSource){
        this.messageSource=messageSource;
    }
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return  "Hello World!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return  new HelloWorldBean("Hello World Bean!");
    }

    //Path parameters - url variables
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return  new HelloWorldBean("Hello "+name);
    }

    @GetMapping(path = "/hello-world-internationalize")
    public String helloWorldInternationalize(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
//        return  "Hello World Internationalize!";
    }

}
