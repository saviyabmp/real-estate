package com.bmp.saviya.realestate.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

	@RequestMapping("/")
	String home() {
		return "Welcome to the Front Page!";
	}

	private static final String template = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
			HttpServletResponse response) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
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
