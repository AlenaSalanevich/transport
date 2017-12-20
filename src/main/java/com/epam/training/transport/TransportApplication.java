package com.epam.training.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Controller
@SpringBootApplication
public class TransportApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(TransportApplication.class, args);
    }

    @RequestMapping(value = "/root")
    public String root() {
        return "index";
    }
}
