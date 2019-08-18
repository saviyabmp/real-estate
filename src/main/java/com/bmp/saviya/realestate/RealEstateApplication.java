package com.bmp.saviya.realestate;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class RealEstateApplication {

    @RequestMapping("/")
	String home() {
		return "Welcome to the Front Page!";
	}

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, HttpServletResponse response) {
        //Heroku does not add this Header.
        response.setHeader("Access-Control-Allow-Origin", "*");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
	}

}

class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
         this.id = id;
         this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
         return content;
    }
}
