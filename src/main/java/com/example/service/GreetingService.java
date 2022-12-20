package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserModel;
import com.example.repository.IGreetingRepo;

@Service
public class GreetingService implements IGreetingService {

	@Autowired
	IGreetingRepo greetingRepo;

	@Override
	public String greetingMessage() {
		return "Hello World";
	}

	@Override
	public String greetMessageWithUser(String firstName, String lastName) {
		if (firstName.isEmpty() && lastName.isEmpty()) {
			return greetingMessage();
		} else if (lastName.equals("") && !firstName.equals("")) {
			return "Hello! " + firstName + ", Welcome to the World!";
		} else if (!lastName.equals("") && firstName.equals("")) {
			return "Hello! " + lastName + ", Welcome to the Earth!";
		}
		return "Hello! " + firstName + " " + lastName + ", Welcome to the GreetingApp!";
	}

	@Override
	public UserModel getGreeting(UserModel greeting) {
		greetingRepo.save(greeting);
	        return greeting;
	}

	@Override
	public Optional<UserModel> sayHelloById(long id) {
		return greetingRepo.findById(id);
	}

	@Override
	public List<UserModel> findByAllGreet() {
		return greetingRepo.findAll();
	}

	@Override
	public UserModel editGreeting(UserModel greeting, long id) {
		UserModel existingGreet = greetingRepo.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setMessage(greeting.getMessage());
            return greetingRepo.save(existingGreet);
        } else
            return null;
	}

	@Override
	public void deleteGreeting(long id) {
		greetingRepo.deleteById(id);
		
	}
}
