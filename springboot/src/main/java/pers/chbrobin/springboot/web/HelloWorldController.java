package pers.chbrobin.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/9 0009.
 */
@RestController
@SpringBootApplication
public class HelloWorldController {
    @RequestMapping("/")
    public String hello(){
        return"Hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
    }
}