package com.perscholas.spring_mvc_sba.classified_adds.repositories;

import com.perscholas.spring_mvc_sba.classified_adds.models.User;

public interface UserRepository {
	void addUser(User u);

	User getUser(String username);
}
