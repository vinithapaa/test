package com.ncit.userservice;

public interface UserService {

	public boolean isUserValid(User user);
	
	public boolean registerUser(User user);
}
