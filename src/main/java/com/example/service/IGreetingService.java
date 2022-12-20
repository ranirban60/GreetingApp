package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.UserModel;

public interface IGreetingService {

	public String greetingMessage();

	public String greetMessageWithUser(String firstName, String lastName);

	public UserModel getGreeting(UserModel greeting);

	public Optional<UserModel> sayHelloById(long id);

	public List<UserModel> findByAllGreet();

	public UserModel editGreeting(UserModel greeting, long id);

	public void deleteGreeting(long id);

}
