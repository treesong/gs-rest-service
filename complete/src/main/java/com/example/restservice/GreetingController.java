package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "你好, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "云计算") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
