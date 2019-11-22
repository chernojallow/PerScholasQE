package com.perscholas.practice_sba.qe_snack_signup.repositories;

import java.util.List;

import com.perscholas.practice_sba.qe_snack_signup.model.Snack;

public interface SnackRepository {
	Integer create(Snack snack);

	Snack getById(Integer snackId);
	
	Snack getByName(String name);

	List<Snack> getAll();

	Boolean update(Snack snack);

	Boolean delete(Integer snackId);
}
