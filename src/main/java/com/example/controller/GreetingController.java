package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserModel;
import com.example.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	@Autowired
	IGreetingService greetingService;

	@GetMapping(value = { "", "/", "/home" })
	public String greeting(@RequestParam(value = "name", defaultValue = "Anirban") String name) {
		return "Hello World " + name;
	}

	@GetMapping("/{name}")
	public String greetings(@PathVariable String name) {
		return "Hello World " + name;
	}

	@GetMapping("/service")
	public String greeting() {
		return greetingService.greetingMessage();

	}

	@GetMapping("/user")
	public String greetMessageWithUser(@RequestParam(value = "firstName", defaultValue = "") String firstName,
			@RequestParam(value = "lastName", defaultValue = "") String lastName) {
		return greetingService.greetMessageWithUser(firstName, lastName);
	}

	@PostMapping("/post")
	public UserModel get(@RequestBody UserModel greeting) {
		return greetingService.getGreeting(greeting);
	}

	@GetMapping("/get/{id}")
	public Optional<UserModel> sayHelloById(@PathVariable long id) {
		Optional<UserModel> response = greetingService.sayHelloById(id);
		return response;
	}

	@GetMapping("/allGreetings")
	public List<UserModel> findAllGreetings() {
		return greetingService.findByAllGreet();
	}

	@PutMapping("/editGreet/{id}")
	public UserModel editGreeting(@RequestBody UserModel greeting, @PathVariable long id) {
		return greetingService.editGreeting(greeting, id);
	}
	
	@DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable long id) {
        greetingService.deleteGreeting(id);
        return "Message Deleted";
    }
}
